package com.werockstar.redditreader.manager.https;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.werockstar.redditreader.model.RedditCollection;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.mock.MockRetrofit;

import static org.junit.Assert.*;

public class RedditApiServiceTest {

    public Retrofit retrofit;

    public Gson gson;

    @Rule
    public MockWebServer server = new MockWebServer();

    @Mock
    public RedditApiService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        gson = new GsonBuilder()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit).build();

        service = retrofit.create(RedditApiService.class);
    }

    @Test
    public void checkRetrofitNotNullPointer() {
        assertNotNull(retrofit);
    }

    @Test
    public void checkServiceNotNullPointer() {
        assertNotNull(service);
    }

    @Test
    public void checkServerNotNullPointer() {
        assertNotNull(server);
    }

    @Test
    public void checkHttpStatus200() throws IOException {
        server.enqueue(new MockResponse().setResponseCode(200));

        Call<RedditCollection> call = service.getRedditItem();
        Response response = call.execute();
        assertEquals(200, response.code());
    }

    @Test
    public void getJsonShouldBeReturnPostTitle() throws IOException {
        String res = "{" +
                "\"data\": {" +
                        "\"children\": ["+
                            "{" +
                                "\"data\": {" +
                                        "\"title\": \"Weekly \"who's hiring\" thread!\""+
                                    "}"+
                            "}"+
                        "]"+
                    "}" +
                "}";
        server.enqueue(new MockResponse().setBody(res));
        Call<RedditCollection> call = service.getRedditItem();
        Response<RedditCollection> response = call.execute();
        RedditCollection collection = response.body();

        assertEquals("Weekly \"who's hiring\" thread!", collection.getDatas().getChildrenList().get(0).getData().getTitle());
    }

    @Test
    public void getItemSizeShouldBeMoreThanZero() throws IOException{
        Call<RedditCollection> call = service.getRedditItem();
        Response<RedditCollection> response = call.execute();
        RedditCollection collection = response.body();

        assertTrue(collection.getDatas().getChildrenList().size() > 0);
    }
}
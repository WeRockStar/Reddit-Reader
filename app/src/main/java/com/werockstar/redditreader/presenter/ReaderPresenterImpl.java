package com.werockstar.redditreader.presenter;

import com.werockstar.redditreader.manager.https.RedditApiService;
import com.werockstar.redditreader.model.RedditCollection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReaderPresenterImpl implements ReaderPresenter {

    private ReaderPresenter.View view;
    private RedditApiService service;

    public ReaderPresenterImpl(ReaderPresenter.View view) {
        this.view = view;
    }

    @Override
    public void setRedditItem() {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.reddit.com/")
                .build();

        service = retrofit.create(RedditApiService.class);
        Call<RedditCollection> call = service.getRedditItem();
        call.enqueue(new Callback<RedditCollection>() {
            @Override
            public void onResponse(Call<RedditCollection> call, Response<RedditCollection> response) {
                if(response.isSuccessful() && response.body() != null){
                    view.showRedditItem(response.body());
                }
            }

            @Override
            public void onFailure(Call<RedditCollection> call, Throwable t) {
            }
        });

    }
}

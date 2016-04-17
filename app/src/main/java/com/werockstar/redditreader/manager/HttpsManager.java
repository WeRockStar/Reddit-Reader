package com.werockstar.redditreader.manager;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.werockstar.redditreader.manager.https.RedditApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpsManager {
    private static HttpsManager httpsManager;

    public static HttpsManager getInstance() {
        if (httpsManager == null)
            httpsManager = new HttpsManager();

        return httpsManager;
    }

    private RedditApiService service;
    private Context mContext;

    private HttpsManager() {
        mContext = Contextor.getInstance().getContext();

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(RedditApiService.class);
    }

    public RedditApiService getService() {
        return service;
    }

}

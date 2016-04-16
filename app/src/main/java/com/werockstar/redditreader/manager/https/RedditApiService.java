package com.werockstar.redditreader.manager.https;

import com.werockstar.redditreader.model.RedditCollection;

import retrofit2.Call;
import retrofit2.http.GET;

interface RedditApiService {

    @GET("r/androiddev.json")
    Call<RedditCollection> getRedditItem();
}

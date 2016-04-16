package com.werockstar.redditreader;

import android.app.Application;

import com.werockstar.redditreader.manager.Contextor;

public class RedditApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        Contextor.getInstance().init(getApplicationContext());
    }
}

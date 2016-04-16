package com.werockstar.redditreader.presenter;

import com.werockstar.redditreader.model.RedditCollection;

import java.util.List;

public interface ReaderPresenter {
    interface View {
        void showRedditItem(RedditCollection list);
    }

    void setRedditItem();
}

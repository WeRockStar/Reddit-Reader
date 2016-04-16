package com.werockstar.redditreader.presenter;

import com.werockstar.redditreader.model.RedditCollection;

import java.util.List;

interface ReaderPresenter {
    interface View {
        void showRedditItem(List<RedditCollection> list);
    }

    void setRedditItem();
}

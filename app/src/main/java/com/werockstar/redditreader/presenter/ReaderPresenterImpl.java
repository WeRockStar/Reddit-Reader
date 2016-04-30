package com.werockstar.redditreader.presenter;

import android.widget.Toast;

import com.werockstar.redditreader.manager.Contextor;
import com.werockstar.redditreader.manager.HttpsManager;
import com.werockstar.redditreader.model.RedditCollection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReaderPresenterImpl implements ReaderPresenter {

    private ReaderPresenter.View view;

    public ReaderPresenterImpl(ReaderPresenter.View view) {
        this.view = view;
    }

    @Override
    public void setRedditItem() {
        Call<RedditCollection> call = HttpsManager.getInstance().getService().getRedditItem();
        call.enqueue(new RedditCallback());
    }

    class RedditCallback implements Callback<RedditCollection> {
        @Override
        public void onResponse(Call<RedditCollection> call, Response<RedditCollection> response) {
            if (response.isSuccessful() && response.body() != null) {
                view.showRedditItem(response.body());
            } else {
                Toast.makeText(Contextor.getInstance().getContext(),
                        response.message(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<RedditCollection> call, Throwable t) {
            Toast.makeText(Contextor.getInstance().getContext(),
                    t.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

}

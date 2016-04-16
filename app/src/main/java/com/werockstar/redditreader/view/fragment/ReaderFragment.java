package com.werockstar.redditreader.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.werockstar.redditreader.R;
import com.werockstar.redditreader.adapter.ReaderAdapter;
import com.werockstar.redditreader.manager.Contextor;
import com.werockstar.redditreader.model.RedditCollection;
import com.werockstar.redditreader.presenter.ReaderPresenter;
import com.werockstar.redditreader.presenter.ReaderPresenterImpl;

import java.util.List;

public class ReaderFragment extends Fragment implements ReaderPresenter.View {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ReaderPresenter presenter;
    private ReaderAdapter adapter;

    public ReaderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reader, container, false);

        initInstance(view);
        setupViews();

        adapter = new ReaderAdapter();
        presenter = new ReaderPresenterImpl(this);
        presenter.setRedditItem();

        return view;
    }

    private void setupViews() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initInstance(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(Contextor.getInstance().getContext(),
                LinearLayoutManager.VERTICAL, false);
    }

    @Override
    public void showRedditItem(RedditCollection list) {
        recyclerView.setAdapter(adapter);
        if(list != null){
            adapter.setDataChage(list.getDatas().getChildrenList());
        }

        adapter.notifyDataSetChanged();
    }
}

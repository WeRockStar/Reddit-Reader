package com.werockstar.redditreader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.werockstar.redditreader.R;
import com.werockstar.redditreader.model.RedditCollection;

import java.util.List;

public class ReaderAdapter extends RecyclerView.Adapter<ReaderAdapter.RedditViewHolder> {

    List<RedditCollection.Datas.Children> list;

    @Override
    public RedditViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reddit_item_row, parent, false);
        return new RedditViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RedditViewHolder holder, int position) {
        RedditCollection.Datas.Children item = list.get(position);
        if (item != null) {
            holder.tvTitle.setText(item.getData().getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void setDataChage(List<RedditCollection.Datas.Children> list) {
        this.list = list;
    }

    public class RedditViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle;

        public RedditViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        }
    }

}

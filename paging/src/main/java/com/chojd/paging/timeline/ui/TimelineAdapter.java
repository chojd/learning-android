package com.chojd.paging.timeline.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.chojd.paging.R;
import com.chojd.paging.timeline.model.TimelineBean;


public class TimelineAdapter extends PagedListAdapter<TimelineBean, TimelineViewHolder> {

    private Context context;
    private PagedList<TimelineBean> pagedList;

    protected TimelineAdapter(@NonNull DiffUtil.ItemCallback diffCallback, Context context) {
        super(diffCallback);
        this.context = context;
    }

    @NonNull
    @Override
    public TimelineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.paging_card, parent, false);
        TimelineViewHolder timelineViewHolder = new TimelineViewHolder(view);
        return timelineViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TimelineViewHolder holder, int position) {
        TimelineBean timelineBean = getItem(position);
        holder.textView.setText(timelineBean.getText());
    }
}


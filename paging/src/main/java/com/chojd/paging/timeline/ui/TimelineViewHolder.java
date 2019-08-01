package com.chojd.paging.timeline.ui;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;

import com.chojd.paging.R;

public class TimelineViewHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public TimelineViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.text_view);
    }
}

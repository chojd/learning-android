package com.chojd.paging.timeline.ui;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.chojd.paging.timeline.model.TimelineBean;

public class TimelineBeanDiffCallback extends DiffUtil.ItemCallback<TimelineBean> {

    @Override
    public boolean areItemsTheSame(@NonNull TimelineBean oldItem, @NonNull TimelineBean newItem) {
        return oldItem.hashCode() == newItem.hashCode();
    }

    @Override
    public boolean areContentsTheSame(@NonNull TimelineBean oldItem, @NonNull TimelineBean newItem) {
        return oldItem.getText().hashCode() == newItem.getText().hashCode();
    }
}

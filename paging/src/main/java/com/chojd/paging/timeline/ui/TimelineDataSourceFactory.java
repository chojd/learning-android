package com.chojd.paging.timeline.ui;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.chojd.paging.timeline.api.TimelineService;

public class TimelineDataSourceFactory extends DataSource.Factory {
    @NonNull
    @Override
    public DataSource create() {
        TimelineDataSource timelineDataSource = new TimelineDataSource(new TimelineService());
        return timelineDataSource;
    }

}

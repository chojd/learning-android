package com.chojd.paging.timeline.ui;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.chojd.paging.timeline.api.TimelineService;
import com.chojd.paging.timeline.model.TimelineBean;

import java.util.ArrayList;
import java.util.List;

public class TimelineDataSource extends PositionalDataSource {

    private TimelineService service;

    public TimelineDataSource(TimelineService service) {
        this.service = service;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
        List<TimelineBean> timelineBeans = this.service.fetchTimeline();
        callback.onResult(timelineBeans, 0);
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback callback) {
//        List<TimelineBean> timelineBeans = this.service.fetchTimeline();
        List<TimelineBean> timelineBeans = new ArrayList<>();
        callback.onResult(timelineBeans);
    }
}

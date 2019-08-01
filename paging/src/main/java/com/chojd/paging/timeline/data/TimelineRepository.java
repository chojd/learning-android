package com.chojd.paging.timeline.data;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.chojd.paging.timeline.api.TimelineService;
import com.chojd.paging.timeline.model.TimelineBean;
import com.chojd.paging.timeline.ui.TimelineDataSource;

import java.util.List;

import javax.inject.Inject;

public class TimelineRepository extends DataSource.Factory<Integer, TimelineBean> {

    @Inject
    public TimelineService timelineService;

    @Inject
    public TimelineRepository(TimelineService timelineService) {
        this.timelineService = timelineService;
    }

    @NonNull
    @Override
    public DataSource<Integer, TimelineBean> create() {
        List<TimelineBean> timelineBeans = this.timelineService.fetchTimeline();
        return new TimelineDataSource(timelineService);
    }

}


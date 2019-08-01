package com.chojd.paging.timeline.api;

import com.chojd.paging.timeline.model.TimelineBean;

import org.checkerframework.checker.signature.qual.InternalFormForNonArray;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TimelineService {

    @Inject
    public TimelineService(){ }

    public List<TimelineBean> fetchTimeline(){
        ArrayList<TimelineBean> timelineBeans = new ArrayList<>();

        TimelineBean timelineBean1 = new TimelineBean("1");
        timelineBeans.add(timelineBean1);

        TimelineBean timelineBean2 = new TimelineBean("2");
        timelineBeans.add(timelineBean2);

        TimelineBean timelineBean3 = new TimelineBean("3");
        timelineBeans.add(timelineBean3);

        TimelineBean timelineBean4 = new TimelineBean("4");
        timelineBeans.add(timelineBean4);

        return timelineBeans;
    }
}

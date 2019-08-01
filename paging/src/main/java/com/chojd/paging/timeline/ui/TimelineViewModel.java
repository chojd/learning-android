package com.chojd.paging.timeline.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.chojd.paging.timeline.data.TimelineRepository;
import com.chojd.paging.timeline.model.TimelineBean;

import javax.inject.Inject;

public class TimelineViewModel extends ViewModel {

    public MediatorLiveData<PagedList<TimelineBean>> mediatorLiveData = new MediatorLiveData<>();

    private final PagedList.Config config = new PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(20)
            .setPageSize(20)
            .build();

    private LiveData liveData = new LivePagedListBuilder<>(new TimelineDataSourceFactory(), config).build();

    public void refresh() {
        mediatorLiveData.addSource(liveData, mediatorLiveData::setValue);
    }
}

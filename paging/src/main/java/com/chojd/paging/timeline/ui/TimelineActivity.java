package com.chojd.paging.timeline.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chojd.paging.R;
import com.chojd.paging.timeline.model.TimelineBean;

public class TimelineActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PagedListAdapter pagedListAdapter;

    public TimelineViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        pagedListAdapter = new TimelineAdapter(new TimelineBeanDiffCallback(), this);
        recyclerView.setAdapter(pagedListAdapter);

        viewModel = ViewModelProviders.of(this).get(TimelineViewModel.class);
        viewModel.mediatorLiveData.observe(this,this::dataSourceChanged);

        viewModel.refresh();
    }

    private void dataSourceChanged(PagedList<TimelineBean> pagedList) {
        pagedListAdapter.submitList(pagedList);
    }


}

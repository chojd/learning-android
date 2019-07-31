package com.chojd.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    protected RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);


        RecyclerBean bean = new RecyclerBean();
        bean.text = "abg";

        List <RecyclerBean>list = new ArrayList<>();
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);
        list.add(bean);

        recyclerView.setAdapter(new RecyclerAdapter(list,this));
    }
}

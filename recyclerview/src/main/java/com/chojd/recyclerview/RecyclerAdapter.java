package com.chojd.recyclerview;


import android.content.Context;
import androidx.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerAdapterViewHolder> {

    private List<RecyclerBean>list;
    private Context context;

    public RecyclerAdapter(List<RecyclerBean> list,Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_holder, viewGroup,false);
        return new RecyclerAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterViewHolder recyclerAdapterViewHolder, int i) {
        recyclerAdapterViewHolder.textView.setText(list.get(i).text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

        protected TextView textView;

        public RecyclerAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.text_view);
        }
    }

}

package com.application.sxm.revie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.sxm.revie.R;
import com.application.sxm.revie.model.MovieItemBean;
import com.application.sxm.revie.viewholder.BaseViewHolder;

import java.util.List;

/**
 * 首页adapter
 * Created by shixiaoming on 18/9/11.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private List<MovieItemBean> data;
    public HomeAdapter(List<MovieItemBean> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.revie_home_list_item, parent, false);
        return new HomeViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.textView.setText(data.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public HomeViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.content);
        }
    }


}

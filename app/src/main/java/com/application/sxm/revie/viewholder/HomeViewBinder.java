package com.application.sxm.revie.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.application.sxm.revie.R;
import com.application.sxm.revie.model.MovieItemBean;
import com.facebook.drawee.view.SimpleDraweeView;

import me.drakeet.multitype.ItemViewBinder;

/**
 * 首页adapter绑定数据
 * Created by shixiaoming on 18/9/11.
 */
public class HomeViewBinder extends ItemViewBinder<MovieItemBean, HomeViewBinder.HomeViewHolder> {


    static class HomeViewHolder extends RecyclerView.ViewHolder {

        private final TextView text;

        private final SimpleDraweeView cover;

        HomeViewHolder(View itemView) {
            super(itemView);
            this.text = itemView.findViewById(R.id.content);
            this.cover = itemView.findViewById(R.id.cover);
        }
    }

    @NonNull
    @Override
    protected HomeViewBinder.HomeViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.revie_home_list_item, parent, false);
        return new HomeViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull HomeViewHolder holder, @NonNull MovieItemBean item) {
        holder.text.setText(item.getTitle());
        holder.cover.setImageURI(item.getImages().getLarge());
    }
}

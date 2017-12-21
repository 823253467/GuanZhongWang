package com.bawei.guanzhongwang.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.util.GlideRoundTransform;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MK on 2017/12/15.
 */

public class recy03Adapter extends RecyclerView.Adapter<recy03Adapter.ViewHolder> {
    Context context;
    List<String> list;
    List<String> listText;
    List<String> listText2;

    public recy03Adapter(Context context, List<String> list, List<String> listText, List<String> listText2) {
        this.context=context;
        this.list = list;
        this.listText = listText;
        this.listText2 = listText2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_recyitem03, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).transform(new GlideRoundTransform(context,30)).into(holder.image01);
        //Glide.with(context).load(list.get(position)).into(holder.image01);
        holder.text01.setText(listText.get(position));
        holder.text02.setText(listText2.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image01)
        ImageView image01;
        @BindView(R.id.text01)
        TextView text01;
        @BindView(R.id.text02)
        TextView text02;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

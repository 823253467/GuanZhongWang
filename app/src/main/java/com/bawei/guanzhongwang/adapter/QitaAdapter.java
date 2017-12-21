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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MK on 2017/12/16.
 */

public class QitaAdapter extends RecyclerView.Adapter<QitaAdapter.ViewHolder> {
    Context context;

    public QitaAdapter(Context context) {
        this.context = context;

    }

    @Override
    public QitaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.adapter_qitafragment, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QitaAdapter.ViewHolder holder, int position) {
        List<String> list = new ArrayList<>();
        list.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        list.add("http://pic2.ooopic.com/11/98/31/31bOOOPIC12_1024.jpg");
        list.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        list.add("http://pic2.ooopic.com/12/22/94/30b1OOOPIC5c.jpg");
        list.add("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg");
        list.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");
        list.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        list.add("http://img.taopic.com/uploads/allimg/121019/234917-121019231h258.jpg");
        list.add("http://img.taopic.com/uploads/allimg/120727/201995-120HG1030762.jpg");
        list.add("http://pic2.ooopic.com/11/98/31/31bOOOPIC12_1024.jpg");
        list.add("http://pic4.nipic.com/20091217/3885730_124701000519_2.jpg");

        List<String> listText = new ArrayList<>();
        listText.add("虾米");
        listText.add("小崔");
        listText.add("阿尼哈塞呦");
        listText.add("可大泉");
        listText.add("啊");
        listText.add("光棍节快乐");
        listText.add("啦啦");
        listText.add("公司可能飞机上看");
        listText.add("测试不需要审核收费");
        listText.add("测试yqm");
        listText.add("经典音乐剧");

        List<String> listText2 = new ArrayList<>();
        listText2.add("¥299~999");
        listText2.add("免费");
        listText2.add("免费");
        listText2.add("43~65");
        listText2.add("免费");
        listText2.add("免费");
        listText2.add("66~90");
        listText2.add("34~100");
        listText2.add("免费");
        listText2.add("免费");
        listText2.add("免费");

        Glide.with(context).load(list.get(position)).transform(new GlideRoundTransform(context,30)).into(holder.image01);
        holder.text01.setText(listText.get(position));
        holder.text02.setText(listText2.get(position));

    }

    @Override
    public int getItemCount() {
        return 11;
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

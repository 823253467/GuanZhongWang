package com.bawei.guanzhongwang.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MK on 2017/12/15.
 */

public class QuanbuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                int currentItem = viewHolder01.viewpagerBunlo.getCurrentItem();
                viewHolder01.viewpagerBunlo.setCurrentItem(currentItem + 1);
                handler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };
    Context context;
    private ViewHolder01 viewHolder01;
    private ViewHolder02 viewHolder02;
    private List<String> imagelist;
    private ViewHolder03 viewHolder03;

    public QuanbuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        }
        return 2;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = View.inflate(context, R.layout.adapter_viewpagerlunbo, null);
            viewHolder01 = new ViewHolder01(view);
            return viewHolder01;
        } else if (viewType == 1) {
            View view = View.inflate(context, R.layout.adapter_daohangitem02, null);
            viewHolder02 = new ViewHolder02(view);
            return viewHolder02;
        } else{
            View view = View.inflate(context, R.layout.adapter_recycleritem03, null);
            viewHolder03 = new ViewHolder03(view);
            return viewHolder03;

        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder01) {
            //图片集合
            imagelist = new ArrayList<>();
            imagelist.add("http://img4.imgtn.bdimg.com/it/u=976451458,3066418296&fm=27&gp=0.jpg");
            imagelist.add("http://img1.imgtn.bdimg.com/it/u=1882381551,1757495536&fm=27&gp=0.jpg");
            //小圆点
            initDoc();
            DocAdapter adapter = new DocAdapter(context, imagelist, handler);
            ((ViewHolder01) holder).viewpagerBunlo.setAdapter(adapter);
            ((ViewHolder01) holder).viewpagerBunlo.setCurrentItem(imagelist.size() * 1000);
            handler.sendEmptyMessageDelayed(0, 2000);
            ((ViewHolder01) holder).viewpagerBunlo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {

                    for (int i = 0; i < image.size(); i++) {
                        if (i == position % imagelist.size()) {
                            image.get(i).setImageResource(R.drawable.doc_yes);
                        } else {
                            image.get(i).setImageResource(R.drawable.doc_no);

                        }
                    }
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        } else if (holder instanceof ViewHolder02) {
                ((ViewHolder02) holder).linear01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "热门", Toast.LENGTH_SHORT).show();
                    }
                });
        }else if (holder instanceof ViewHolder03){
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
            ((ViewHolder03) holder).recclerviewid.setFocusable(false);
            recy03Adapter recy03Adapter = new recy03Adapter(context, list, listText, listText2);
            ((ViewHolder03) holder).recclerviewid.setLayoutManager(new LinearLayoutManager(context));
            ((ViewHolder03) holder).recclerviewid.setAdapter(recy03Adapter);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }


    static class ViewHolder01 extends RecyclerView.ViewHolder {
        @BindView(R.id.viewpager_bunlo)
        ViewPager viewpagerBunlo;
        @BindView(R.id.linear01)
        LinearLayout linear01;

        ViewHolder01(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }

    static class ViewHolder02 extends RecyclerView.ViewHolder {
        @BindView(R.id.linear01)
        LinearLayout linear01;
        @BindView(R.id.linear02)
        LinearLayout linear02;
        @BindView(R.id.linear03)
        LinearLayout linear03;

        ViewHolder02(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<ImageView> image;
    private ImageView imageView;

    private void initDoc() {

        image = new ArrayList<>();

        viewHolder01.linear01.removeAllViews();

        for (int i = 0; i < imagelist.size(); i++) {
            imageView = new ImageView(context);

            if (i == 0) {
                imageView.setImageResource(R.drawable.doc_yes);
            } else {
                imageView.setImageResource(R.drawable.doc_no);

            }


            image.add(imageView);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(5, 0, 5, 0);
            viewHolder01.linear01.addView(imageView, params);


        }
    }

    static class ViewHolder03 extends RecyclerView.ViewHolder {
        @BindView(R.id.recclerviewid)
        RecyclerView recclerviewid;

        ViewHolder03(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

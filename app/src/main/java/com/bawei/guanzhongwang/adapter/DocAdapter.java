package com.bawei.guanzhongwang.adapter;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.guanzhongwang.util.ImageLoaderUtil;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by MK on 2017/9/15.
 */
public class DocAdapter extends PagerAdapter{
    Context context;
    List<String> imagelist;
    Handler handler;


    public DocAdapter(Context context, List<String> imagelist, Handler handler) {
        this.context=context;
        this.imagelist=imagelist;
        this.handler=handler;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
       // ImageLoader.getInstance().displayImage(imagelist.get(position%imagelist.size()),imageView, ImageLoaderUtil.getoption());
        Glide.with(context)
                .load(imagelist.get(position%imagelist.size()))
                .into(imageView);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                boolean isdian = true;
                switch (motionEvent.getAction()){

                    case MotionEvent.ACTION_DOWN:
                        handler.removeCallbacksAndMessages(null);
                        break;//按下
                    case MotionEvent.ACTION_MOVE:
                        isdian = false;
                        handler.removeCallbacksAndMessages(null);
                        break;//移动
                    case MotionEvent.ACTION_CANCEL:
                        isdian = false;
                        handler.sendEmptyMessageDelayed(0,2000);
                        break;//取消
                    case MotionEvent.ACTION_UP:
                        if (isdian){
                            Toast.makeText(context,"sas",Toast.LENGTH_SHORT).show();
                        }
                        handler.sendEmptyMessageDelayed(0,2000);

                        break;//抬起
                }
                return true;
            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
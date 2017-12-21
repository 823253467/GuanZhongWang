package com.bawei.guanzhongwang.application;

import android.app.Application;

import com.bawei.guanzhongwang.util.ImageLoaderUtil;

/**
 * Created by MK on 2017/12/15.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderUtil.getInit(this);
    }
}

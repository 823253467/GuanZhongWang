package com.bawei.guanzhongwang.common;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by MK on 2017/12/5.
 */

public class OkHttpUtils {
    private static OkHttpClient client = null;

    public static OkHttpClient getInstance(){

        if (client==null){
            synchronized (OkHttpUtils.class){
                if (client==null){
                    client = new OkHttpClient.Builder()
                            .connectTimeout(20000,TimeUnit.SECONDS)
                            .writeTimeout(20000,TimeUnit.SECONDS)
                            .readTimeout(20000,TimeUnit.SECONDS)
                            .build();

                }
            }
        }
        return client;
    }
}

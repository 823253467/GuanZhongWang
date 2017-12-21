package com.bawei.guanzhongwang.common;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by MK on 2017/12/5.
 */

public class APIFactory {
    private APIFactory(){

    }
    private static APIFactory factory = null;

    public static APIFactory getInstance(){
        if (factory==null){
            synchronized (APIFactory.class){
                if (factory==null){
                    factory=new APIFactory();
                }
            }
        }
        return factory;
    }

    public void get(String url, Map<String,String> map, Observer<String> observer){
            RetrofitUtils.getInstance().get(url,map)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(observer);
    }

    public void get(String url,Observer<String> observer){
        RetrofitUtils.getInstance().get(url)
                // 指定 被观察者 所在一个IO线程
                .subscribeOn(Schedulers.io())
                    //指定观察者所在 住县城
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void post(String url,Map<String,String> map,Observer<String> observer){
        RetrofitUtils.getInstance().post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }


}

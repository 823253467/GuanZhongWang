package com.bawei.guanzhongwang.base;

/**
 * Created by MK on 2017/12/5.
 */

public class BasePresenter<V> {
    //相当于V的接口
    public V view;


    //presenter 持有view接口
    public void attach(V v){
        this.view = v;
    }

    //prsenter 释放持有view的接口 防止内存泄漏
    public void datach(){
        this.view = null;
    }

}

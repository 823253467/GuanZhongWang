package com.bawei.guanzhongwang.common;


import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by MK on 2017/12/5.
 */

public abstract class AbstractObserver<T> implements Observer<String>{

    public abstract void onSuccess(T t);
    public abstract void onFailure(int code);
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(String result) {

        Type type = getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        Class calzz = (Class) types[0];
        Gson gson = new Gson();
        T t = (T) gson.fromJson(result,calzz);
        onSuccess(t);

    }

    @Override
    public void onError(Throwable e) {
        onFailure(1);
        System.out.println(e);
    }

    @Override
    public void onComplete() {

    }
}

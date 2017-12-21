package com.bawei.guanzhongwang.model;

import com.bawei.guanzhongwang.bean.LoginBean;
import com.bawei.guanzhongwang.service.GithubService;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MK on 2017/12/16.
 */

public class LoginModel {
    public void getData(String name, String pwd, final IModel iModel){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.zhaoapi.cn")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        GithubService githubService = retrofit.create(GithubService.class);
        Map<String, String> map=new HashMap<>();
        //    https://www.zhaoapi.cn/user/login?mobile=15933886597&password=123456
        map.put("mobile",name);
        map.put("password",pwd);
        githubService.loginpost(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
                        iModel.success(bean);
                    }
                });
    }
    public interface IModel{
        public void success(LoginBean bean);
    }
}

package com.bawei.guanzhongwang.service;

import com.bawei.guanzhongwang.bean.LoginBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by MK on 2017/12/16.
 */

public interface GithubService {
//    https://www.zhaoapi.cn/user/login?mobile=15933886597&password=123456
    @FormUrlEncoded
    @POST("/user/login")
    Observable<LoginBean> loginpost(@FieldMap Map<String,String> map);
}

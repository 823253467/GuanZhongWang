package com.bawei.guanzhongwang.common;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by MK on 2017/12/5.
 */

public interface APIService {
    @GET
    Observable<String> get(@Url String url, @QueryMap Map<String, String> map);

    @GET
    Observable<String> get(@Url String url);

    @FormUrlEncoded
    @POST
    Observable<String> post(@Url String url, @FieldMap Map<String, String> map);
}

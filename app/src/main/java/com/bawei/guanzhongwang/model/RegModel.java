package com.bawei.guanzhongwang.model;

import com.bawei.guanzhongwang.bean.RegBean;
import com.bawei.guanzhongwang.common.APIFactory;
import com.bawei.guanzhongwang.common.AbstractObserver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MK on 2017/12/16.
 */

public class RegModel{
    public void getData(String name, String pwd, final IModel iModel){
        Map<String, String> map = new HashMap<>();
//        https://www.zhaoapi.cn/user/reg?mobile=15933886666&password=123456
        map.put("mobile",name);
        map.put("password",pwd);
        APIFactory.getInstance().post("/user/reg", map, new AbstractObserver<RegBean>() {
            @Override
            public void onSuccess(RegBean bean) {
                iModel.success(bean);
            }

            @Override
            public void onFailure(int code) {

            }
        });
    }
    public interface IModel{
        public void success(RegBean bean);
    }
}

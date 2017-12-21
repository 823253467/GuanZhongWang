package com.bawei.guanzhongwang.presenter;

import com.bawei.guanzhongwang.base.BasePresenter;
import com.bawei.guanzhongwang.bean.RegBean;
import com.bawei.guanzhongwang.model.RegModel;
import com.bawei.guanzhongwang.view.RegView;

/**
 * Created by MK on 2017/12/16.
 */

public class RegPresenter extends BasePresenter<RegView>{

    private final RegModel model;

    public RegPresenter() {
        model = new RegModel();
    }

    public void regpost(String name, String pwd){
        model.getData(name, pwd, new RegModel.IModel() {
            @Override
            public void success(RegBean bean) {
                if (bean!=null){
                    view.success(bean);
                }

            }
        });
    }
}

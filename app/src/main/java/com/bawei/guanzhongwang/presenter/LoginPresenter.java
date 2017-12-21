package com.bawei.guanzhongwang.presenter;

import com.bawei.guanzhongwang.bean.LoginBean;
import com.bawei.guanzhongwang.model.LoginModel;
import com.bawei.guanzhongwang.view.LoginView;

/**
 * Created by MK on 2017/12/16.
 */

public class LoginPresenter {
    LoginView view;
    private final LoginModel model;

    public LoginPresenter(LoginView view) {
        this.view = view;
        model = new LoginModel();
    }

    public void loginpost(String name,String pwd){
        model.getData(name, pwd, new LoginModel.IModel() {
            @Override
            public void success(LoginBean bean) {
                if (bean!=null){
                    view.success(bean);
                }
            }
        });
    }
    public void datach(){
        this.view = null;
    }
}

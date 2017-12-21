package com.bawei.guanzhongwang.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.bean.LoginBean;
import com.bawei.guanzhongwang.bean.MessageEvent;
import com.bawei.guanzhongwang.presenter.LoginPresenter;
import com.bawei.guanzhongwang.view.LoginView;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.btn_imagefanhui)
    ImageView btnImagefanhui;
    @BindView(R.id.edit01)
    EditText edit01;
    @BindView(R.id.edit02)
    EditText edit02;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_textreg)
    TextView btnTextreg;
    private LoginPresenter loginPresenter;
    private SharedPreferences.Editor edit;
    private SharedPreferences config;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        //shaerdpreferences
        config = getSharedPreferences("config", 0);
        //拿到编辑对象
        edit = config.edit();
        //返回
        btnImagefanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //登录
        loginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(edit01.getText().toString()) && !TextUtils.isEmpty(edit02.getText().toString())) {
                    //如果都不为空,请求接口
                    loginPresenter.loginpost(edit01.getText().toString(),edit02.getText().toString());
                } else {
                    Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //注册
        btnTextreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void success(final LoginBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
        if ("登录成功".equals(bean.getMsg())){
            int uid = bean.getData().getUid();
            String suid = String.valueOf(uid);
            //sharedpreferences存值,记录已经登录
            edit.putString("uid",suid);//将当前的uid存进去,1650
            edit.commit();
            //如果登录成功了,,eventbus传值给wodefragment
            EventBus.getDefault().postSticky(new MessageEvent(bean.getData().getUsername(),"http://img0.imgtn.bdimg.com/it/u=2097996470,2706206864&fm=27&gp=0.jpg"));
            //登录成功以后 跳转到活动页面,也就是mainactivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.datach();
    }
}

package com.bawei.guanzhongwang.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.base.BaseMvpActivity;
import com.bawei.guanzhongwang.bean.RegBean;
import com.bawei.guanzhongwang.presenter.RegPresenter;
import com.bawei.guanzhongwang.view.RegView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegActivity extends BaseMvpActivity<RegView,RegPresenter> implements RegView {

    @BindView(R.id.btn_imagefanhui)
    ImageView btnImagefanhui;
    @BindView(R.id.edit01)
    EditText edit01;
    @BindView(R.id.edit02)
    EditText edit02;
    @BindView(R.id.btn_reg)
    Button btnReg;

    @Override
    public RegPresenter initPresenter() {
        return new RegPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        ButterKnife.bind(this);

        //返回
        btnImagefanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //注册
        t.attach(this);
        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.regpost(edit01.getText().toString(),edit02.getText().toString());
            }
        });
    }
    @Override
    public void success(RegBean bean) {
        Toast.makeText(this, bean.getMsg(), Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.datach();
    }


}

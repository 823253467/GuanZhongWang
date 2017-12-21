package com.bawei.guanzhongwang.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.bean.MessageEvent;
import com.bawei.guanzhongwang.bean.MessageEventTuichu;
import com.bawei.guanzhongwang.util.GlideCircleTransform;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TuicuActivity extends AppCompatActivity {

    @BindView(R.id.btn_duichu)
    Button btnDuichu;
    @BindView(R.id.image_touxaing)
    ImageView imageTouxaing;
    @BindView(R.id.text_name)
    TextView textName;
    private SharedPreferences config;
    private SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuicu);
        ButterKnife.bind(this);
        //接收方需要注册
        EventBus.getDefault().register(this);
        config = getSharedPreferences("config", 0);
        //拿到编辑对象
        edit = config.edit();


        btnDuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit.putString("uid", null);
                edit.commit();
                //点击退出这个数据传到wodefragment里进行接收
                EventBus.getDefault().postSticky(new MessageEvent("未登录","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513591156171&di=11dad0eb42c06170c1bbc98db7cbf9bc&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D3610704133%2C3947436040%26fm%3D214%26gp%3D0.jpg"));
                String uid = config.getString("uid", null);
                Toast.makeText(TuicuActivity.this, "uid:" + uid, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    //这是wodefragment里传过来的数据
    //在接收的方法上需要加注解, 黏性为true,线程模式为主线程
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onM(MessageEventTuichu event){
        textName.setText(event.getName());
        Glide.with(this).load(event.getUrl()).transform(new GlideCircleTransform(this)).into(imageTouxaing);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

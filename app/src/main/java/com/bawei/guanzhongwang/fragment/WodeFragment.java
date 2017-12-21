package com.bawei.guanzhongwang.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.activity.LoginActivity;
import com.bawei.guanzhongwang.activity.TuicuActivity;
import com.bawei.guanzhongwang.bean.MessageEvent;
import com.bawei.guanzhongwang.bean.MessageEventTuichu;
import com.bawei.guanzhongwang.util.GlideCircleTransform;
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.http.Url;

/**
 * A simple {@link Fragment} subclass.
 */
public class WodeFragment extends Fragment {


    @BindView(R.id.btn_image)
    ImageView btnImage;
    @BindView(R.id.textdengluming)
    TextView textdengluming;
    Unbinder unbinder;
    @BindView(R.id.text_tuichu)
    TextView textTuichu;
    private SharedPreferences config;
    private SharedPreferences.Editor edit;


    public WodeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wode, container, false);
        unbinder = ButterKnife.bind(this, view);
        Glide.with(getActivity()).load(R.drawable.wdltimg).transform(new GlideCircleTransform(getActivity())).into(btnImage);

        //首先注册
        EventBus.getDefault().register(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        config = getActivity().getSharedPreferences("config", 0);
        //拿到编辑对象
        edit = config.edit();
        String uid = config.getString("uid", null);
        if (uid==null){
            //没登录
            EventBus.getDefault().postSticky(new MessageEvent("未登录","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513591156171&di=11dad0eb42c06170c1bbc98db7cbf9bc&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D3610704133%2C3947436040%26fm%3D214%26gp%3D0.jpg"));
        }else {
            //登录
            EventBus.getDefault().postSticky(new MessageEvent("15933886597","http://img0.imgtn.bdimg.com/it/u=2097996470,2706206864&fm=27&gp=0.jpg"));

        }
        //登录
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //退出
        textTuichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uid = config.getString("uid", null);
                if (uid==null){
                    //没登录
                    EventBus.getDefault().postSticky(new MessageEventTuichu("未登录","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1513591156171&di=11dad0eb42c06170c1bbc98db7cbf9bc&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D3610704133%2C3947436040%26fm%3D214%26gp%3D0.jpg"));
                }else {
                    //登录
                    EventBus.getDefault().postSticky(new MessageEventTuichu("15933886597","http://img0.imgtn.bdimg.com/it/u=2097996470,2706206864&fm=27&gp=0.jpg"));

                }
                Intent intent = new Intent(getActivity(), TuicuActivity.class);
                startActivity(intent);
                /*edit.clear();
                edit.commit();
                String uid = config.getString("uid", null);
                Toast.makeText(getActivity(), "uid:" + uid, Toast.LENGTH_SHORT).show();*/
                /*textdengluming.setText("未登录");
                btnImage.setImageResource(R.drawable.weidenglu);*/
            }
        });
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(MessageEvent event) {

        textdengluming.setText(event.getName());
        Glide.with(getActivity()).load(event.getUrl()).transform(new GlideCircleTransform(getActivity())).into(btnImage);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //生命周期销毁的时候 取消注册
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

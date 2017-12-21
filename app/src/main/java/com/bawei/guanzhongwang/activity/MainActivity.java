package com.bawei.guanzhongwang.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.fragment.FabuFragment;
import com.bawei.guanzhongwang.fragment.GuanliFragment;
import com.bawei.guanzhongwang.fragment.HuodongFragment;
import com.bawei.guanzhongwang.fragment.WodeFragment;
import com.bawei.guanzhongwang.util.ImmersedStatusbarUtils;
import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottomtabbar)
    BottomTabBar bottomtabbar;
    @BindView(R.id.chenjinshi)
    LinearLayout chenjinshi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ImmersedStatusbarUtils.initAfterSetContentView(this, chenjinshi);
        bottomtabbar.init(getSupportFragmentManager())
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("活动", R.drawable.huodong, HuodongFragment.class)
                .addTabItem("发布", R.drawable.fabu, FabuFragment.class)
                .addTabItem("管理", R.drawable.guanli, GuanliFragment.class)
                .addTabItem("我的", R.drawable.wode, WodeFragment.class)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
    }
}

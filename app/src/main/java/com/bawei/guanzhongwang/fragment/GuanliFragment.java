package com.bawei.guanzhongwang.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.guanzhongwang.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class GuanliFragment extends Fragment {


    @BindView(R.id.btn_01)
    RadioButton btn01;
    @BindView(R.id.btn_02)
    RadioButton btn02;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.manage_viewpager)
    ViewPager manageViewpager;
    Unbinder unbinder;

    public GuanliFragment() {
        // Required empty public constructor
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onResume() {
        super.onResume();
        /*SharedPreferences preferences = getActivity().getSharedPreferences("config", Context.MODE_APPEND);
        String string = preferences.getString("key", "aaa");
        if (string==)*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_guanli, container, false);
        unbinder = ButterKnife.bind(this, view);
        //radiogroup的点击监听
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.btn_01:
                        //点击第一个radiobutton,显示viewpager的第一页
                        manageViewpager.setCurrentItem(0,false);
                        break;
                    case R.id.btn_02:
                        //点击第二个radiobutton,显示viewpager的第二页
                        manageViewpager.setCurrentItem(1,false);
                        break;
                }
            }
        });
        //viewpager设置适配器

        manageViewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        //当滑动到第一页时候,展示这个fragment
                        fragment = new ManageleftFragment();
                        break;
                    case 1:
                        //当滑动到第二页时候,展示这个fragment
                        fragment = new ManagerightFragment();
                        break;
                }
                return fragment;
            }

            @Override
            public int getCount() {
                //返回viewpager的数量
                return 2;
            }
        });
        //viewpager滑动监听
        manageViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //radiogroup选中对应的radiobutton
                radioGroup.check(radioGroup.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

package com.bawei.guanzhongwang.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bawei.guanzhongwang.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class ManageleftFragment extends Fragment {


    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    Unbinder unbinder;
    @BindView(R.id.view_pagerxiaoren)
    ViewPager viewPagerxiaoren;
    private SharedPreferences config;

    public ManageleftFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manageleft, container, false);
        unbinder = ButterKnife.bind(this, view);
        //sharedpreferences
        config = getActivity().getSharedPreferences("config", 0);
        String uid = config.getString("uid", null);
        Toast.makeText(getActivity(), uid, Toast.LENGTH_SHORT).show();
        if (uid==null) {
            //如果没登录,就显示 哭的小人
            viewPagerxiaoren.setVisibility(View.VISIBLE);//可见
            viewPager.setVisibility(View.GONE);//隐藏
            //设置tablayout和viewpager联动
            tabLayout.setupWithViewPager(viewPagerxiaoren);
        } else {
            //如果已经登录,就显示数据
            viewPager.setVisibility(View.VISIBLE);
            viewPagerxiaoren.setVisibility(View.GONE);
            //设置tablayout和viewpager联动
            tabLayout.setupWithViewPager(viewPager);
        }
        final List<String> list = new ArrayList<>();
        //添加4条数据,作为tablayout标签
        list.add("待审核");
        list.add("待支付");
        list.add("待参加");
        list.add("已完成");

        //设置viewpager可以预加载全部的页数,,不会销毁其他的页面
        viewPager.setOffscreenPageLimit(list.size());
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            private TabqitaFragment qitaFragment;

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {

                if (position == 0) {
                    //当选中第一个tablayout标签时候,展示这个fragment
                    qitaFragment = new TabqitaFragment();
                    return qitaFragment;
                } else {
                    //选中其他tablayou标签时候,展示这个fragment
                    qitaFragment = new TabqitaFragment();
                    return qitaFragment;
                }
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //设置tablayout和viewpager联动
        tabLayout.setupWithViewPager(viewPager);


        //--------------------------------------哭的小人viewpager
        //设置viewpager可以预加载全部的页数,,不会销毁其他的页面
        viewPagerxiaoren.setOffscreenPageLimit(list.size());
        viewPagerxiaoren.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {

            private ManageQuDengluFragment manageQuDengluFragment;

            @Override
            public CharSequence getPageTitle(int position) {
                return list.get(position);
            }

            @Override
            public Fragment getItem(int position) {

                manageQuDengluFragment =new ManageQuDengluFragment();
                return manageQuDengluFragment;
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        //设置tablayout和viewpager联动
        tabLayout.setupWithViewPager(viewPagerxiaoren);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
        //每次进入页面,都判断是否登录
        //sharedpreferences
        String uid = config.getString("uid", null);
        Toast.makeText(getActivity(), uid, Toast.LENGTH_SHORT).show();
        if (uid==null) {
            //如果没登录,就显示 哭的小人
            viewPagerxiaoren.setVisibility(View.VISIBLE);//可见
            viewPager.setVisibility(View.GONE);//隐藏
            //设置tablayout和viewpager联动
            tabLayout.setupWithViewPager(viewPagerxiaoren);
        } else {
            //如果已经登录,就显示数据
            viewPager.setVisibility(View.VISIBLE);
            viewPagerxiaoren.setVisibility(View.GONE);
            //设置tablayout和viewpager联动
            tabLayout.setupWithViewPager(viewPager);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

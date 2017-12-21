package com.bawei.guanzhongwang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import com.bawei.guanzhongwang.fragment.TabqitaFragment;
import com.bawei.guanzhongwang.fragment.TabquanbuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MK on 2017/12/15.
 */

public class TabLayoutAdpter extends FragmentPagerAdapter{
    List<String> list;
    public TabLayoutAdpter(FragmentManager fragmentManager, List<String> list) {
        super(fragmentManager);
        this.list=list;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0){
            return new TabquanbuFragment();
        }
        return new TabqitaFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }
}

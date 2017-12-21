package com.bawei.guanzhongwang.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.adapter.TabLayoutAdpter;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class HuodongFragment extends Fragment {


    @BindView(R.id.text_quanguo)
    TextView textQuanguo;
    @BindView(R.id.image_sousuo)
    ImageView imageSousuo;
    @BindView(R.id.tablayoutid)
    TabLayout tablayoutid;
    Unbinder unbinder;
    @BindView(R.id.viewpagerid)
    ViewPager viewpagerid;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    public HuodongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_huodong, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //全国
        textQuanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        //启动
                startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);

            }
        });
        List<String> list = new ArrayList<>();
        list.add("全部");
        list.add("综艺娱乐");
        list.add("财务访谈");
        list.add("文化旅游");
        list.add("时尚体育");
        list.add("青少科教");
        list.add("养生保健");
        list.add("公益");

        //加载多页不设置只能加载3页
        viewpagerid.setOffscreenPageLimit(list.size());
        TabLayoutAdpter adpter = new TabLayoutAdpter(getFragmentManager(),list);
        viewpagerid.setAdapter(adpter);

        tablayoutid.setupWithViewPager(viewpagerid);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //重写onActivityResult方法
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                textQuanguo.setText("当前选择：" + city);
            }
        }


    }
}

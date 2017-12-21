package com.bawei.guanzhongwang.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.guanzhongwang.R;
import com.bawei.guanzhongwang.adapter.QuanbuAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabquanbuFragment extends Fragment {


    @BindView(R.id.recyclerviewid)
    RecyclerView recyclerviewid;
    Unbinder unbinder;
    private QuanbuAdapter quanbuAdapter;

    public TabquanbuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tabquanbu, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        quanbuAdapter = new QuanbuAdapter(getActivity());
        recyclerviewid.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerviewid.setAdapter(quanbuAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

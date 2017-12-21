package com.bawei.guanzhongwang.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseMvpActivity<V,T extends BasePresenter<V> > extends AppCompatActivity {
    public T t;

    public abstract T initPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        t = initPresenter();
    }


    @Override
    protected void onResume() {
        super.onResume();
        t.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.datach();
    }
}

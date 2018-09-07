package com.example.application.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public abstract class BaseActivity<T extends ViewDataBinding> extends AppCompatActivity {

    protected T t;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        t = (T)DataBindingUtil.setContentView(this,getLayoutId());
        initData();
        initEvent();
    }


    abstract int getLayoutId();

    abstract void initData();

    abstract void initEvent();
}

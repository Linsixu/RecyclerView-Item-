package com.example.application.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public class MyViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private T mBinding;

    private int layoutId;

    public MyViewHolder(T mBinding) {
        super(mBinding.getRoot());
        this.mBinding =  mBinding;
    }
    public T getBinding(){
        return mBinding;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
}

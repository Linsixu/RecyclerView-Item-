package com.example.application.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public abstract class BaseAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Context context;

    protected LayoutInflater layoutInflater;


    public BaseAdapter(Context context) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
//        return onCreateViewHolder(viewGroup,i,layoutInflater);

        return onCreateHolder(viewGroup,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        onBindHolder(myViewHolder,i);
    }

    @Override
    public int getItemCount() {
        return getDetailsItemCount();
    }


    abstract MyViewHolder onCreateHolder(ViewGroup viewGroup,int viewType);


    abstract void onBindHolder(MyViewHolder myViewHolder,int position);

    abstract int getDetailsItemCount();
}

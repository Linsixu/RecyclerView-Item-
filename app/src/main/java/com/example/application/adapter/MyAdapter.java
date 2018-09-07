package com.example.application.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.application.BR;
import com.example.application.R;
import com.example.application.bean.User;
import com.example.application.databinding.ItemAuthorBinding;
import com.example.application.databinding.ItemUserBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public class MyAdapter extends BaseAdapter{

    //文本
    private final int TYPE_OWNER_ONE = 0;
    private final int TYPE_OWNER_TWO = 1;

    private List<User> users;

    private ItemUserBinding dataBinding;

    private ItemTouchHelper itemTouchHelper;

    public MyAdapter(Context context,List<User> users,ItemTouchHelper itemTouchHelper) {
        super(context);
        this.users = users;
        this.itemTouchHelper = itemTouchHelper;
    }

    @Override
    int getDetailsItemCount() {
        return users.size();
    }

    @Override
    void onBindHolder(final MyViewHolder myViewHolder, int position) {
        User user = users.get(position);
        myViewHolder.getBinding().setVariable(BR.item,user);
        ImageView imgMore = myViewHolder.itemView.findViewById(R.id.imgMore);
        imgMore.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    itemTouchHelper.startDrag(myViewHolder);
                }
                return false;
            }
        });
    }

    @Override
    MyViewHolder onCreateHolder(ViewGroup viewGroup, int viewType) {
        if(viewType == TYPE_OWNER_ONE){
            ItemUserBinding binding = DataBindingUtil.inflate(layoutInflater,R.layout.item_user,viewGroup,false);
            return new MyViewHolder(binding);
        }else if(viewType == TYPE_OWNER_TWO){
            ItemAuthorBinding binding1 =  DataBindingUtil.inflate(layoutInflater,R.layout.item_author,viewGroup,false);
            return new MyViewHolder(binding1);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        User user = users.get(position);
        if(user.getType() == 0){
            return TYPE_OWNER_ONE;
        }else{
            return TYPE_OWNER_TWO;
        }
    }
}

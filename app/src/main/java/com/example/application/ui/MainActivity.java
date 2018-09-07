package com.example.application.ui;

import com.example.application.R;
import com.example.application.adapter.MyAdapter;
import com.example.application.bean.User;
import com.example.application.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Magic
 * on 2018/9/7.
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private MyAdapter adapter;
    private List<User> users;

    @Override
    int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    void initData() {
        users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User("我的序号是"+i,i%2);
            users.add(user);
        }
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemHelperCallBack());
        adapter = new MyAdapter(this,users,itemTouchHelper);
        t.include.recycler.setLayoutManager(new LinearLayoutManager(this));
        t.include.recycler.setAdapter(adapter);
        itemTouchHelper.attachToRecyclerView(t.include.recycler);
    }

    @Override
    void initEvent() {

    }
    public class ItemHelperCallBack extends ItemTouchHelper.Callback{

        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int draFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = 0;
            return makeMovementFlags(draFlags,swipeFlags);
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
            adapter.notifyItemMoved(viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
            Collections.swap(users,viewHolder.getAdapterPosition(),viewHolder1.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
            users.remove(viewHolder.getAdapterPosition());
            adapter.notifyDataSetChanged();
        }

        @Override
        public boolean canDropOver(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder current, @NonNull RecyclerView.ViewHolder target) {
            return true;
        }

        /**
         * 是否禁止使用系统默认的长按效果
         * @return true是使用系统默认长按效果，false是禁止使用。
         */
        @Override
        public boolean isLongPressDragEnabled() {
            return false;
        }
    }

}

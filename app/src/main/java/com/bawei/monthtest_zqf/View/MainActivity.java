package com.bawei.monthtest_zqf.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.monthtest_zqf.Adapters.MyRecycleViewAdapter;
import com.bawei.monthtest_zqf.Const;
import com.bawei.monthtest_zqf.JavaBean.NewBean;
import com.bawei.monthtest_zqf.Presenter.Presenter;
import com.bawei.monthtest_zqf.R;

public class MainActivity extends AppCompatActivity implements IGameView {

    private Presenter presenter;
    private RecyclerView mRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        presenter = new Presenter(this, this);
        presenter.getData(Const.url);
    }

    @Override
    public void setGameBean(NewBean gameBean) {
        MyRecycleViewAdapter adapter = new MyRecycleViewAdapter(gameBean, this);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(adapter);
        adapter.setmMyItemclickListener(new MyRecycleViewAdapter.MyItemclickListener() {
            @Override
            public void itemclick(View view, int position) {
                startActivity(new Intent(MainActivity.this,ShoppingActivity.class));
            }
        });
    }

    private void initView() {
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerview);
    }
}

package com.application.sxm.revie.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * activity基类
 * Created by shixiaoming on 18/9/10.
 */
public abstract class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewRes());
        // 注解绑定
        ButterKnife.bind(this);
        //禁止屏幕切换
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //初始化View
        initView();
        //初始化数据
        initData();
    }


    //获取contentview布局id
    public abstract int getContentViewRes();

    //初始化View
    public abstract void initView();

    //初始化数据
    public abstract void initData();
}

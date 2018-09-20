package com.application.sxm.revie.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 基础application
 * 初始化工作
 * Created by shixiaoming on 18/9/12.
 */
public class BaseAppliaction extends Application{

    private static BaseAppliaction instance;

    public static BaseAppliaction getInstance() {
        if (instance == null) {
            instance = new BaseAppliaction();
        }
        return instance;
    }

    public BaseAppliaction(){}

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Fresco.initialize(this);
        ARouter.init(this);
    }


}

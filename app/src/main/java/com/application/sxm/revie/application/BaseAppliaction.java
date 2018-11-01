package com.application.sxm.revie.application;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.model.AppConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.smtt.sdk.QbSdk;

/**
 * 基础application
 * 初始化工作
 * Created by shixiaoming on 18/9/12.
 */
public class BaseAppliaction extends Application {

    private static BaseAppliaction instance;

    public static BaseAppliaction getInstance() {
        if (instance == null) {
            instance = new BaseAppliaction();
        }
        return instance;
    }

    public BaseAppliaction() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        initBaseSDK();
    }

    /**
     * 基础SDK初始化
     */
    private void initBaseSDK() {
        Fresco.initialize(this);
        ARouter.init(this);
        initTbs();
    }

    /**
     * X5初始化
     */
    private void initTbs() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.i(AppConstants.LOG_WEB_MSG, "X5初始化完成");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Log.i(AppConstants.LOG_WEB_MSG, String.format("X5初始化%s", b ? "成功" : "失败"));
            }
        };
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

}

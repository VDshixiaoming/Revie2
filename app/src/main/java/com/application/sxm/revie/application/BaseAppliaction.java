package com.application.sxm.revie.application;

import android.app.Application;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.BuildConfig;
import com.application.sxm.revie.R;
import com.application.sxm.revie.model.AppConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
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
        initLogger();
        initTbs();
    }

    /**
     * 初始化Logger
     */
    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(getResources().getString(R.string.app_name))
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    /**
     * X5初始化
     */
    private void initTbs() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Logger.t(AppConstants.LOG_WEB_MSG).i("X5初始化完成");
            }

            @Override
            public void onViewInitFinished(boolean b) {
                Logger.t(AppConstants.LOG_WEB_MSG).i(String.format("X5初始化%s", b ? "成功" : "失败"));
            }
        };
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }

}

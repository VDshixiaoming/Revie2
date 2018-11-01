package com.application.sxm.revie.util;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.model.AppConstants;

/**
 * WebView跳转封装
 * Created by shixiaoming on 18/11/1.
 */
public class HybridClient {


    /**
     * 普通H5跳转
     * @param url
     */
    public static void jumpToH5(@NonNull String url) {

        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.H5_URL, url);
        ARouter.getInstance()
                .build("/main/webview")
                .with(bundle)
                .navigation();
    }
}

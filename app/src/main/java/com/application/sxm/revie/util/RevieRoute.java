package com.application.sxm.revie.util;


import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.model.AppConstants;

/**
 * 页面跳转辅助类
 * Created by shixiaoming on 18/11/1.
 */
public class RevieRoute {

    public static final String ROUTE_PATH_WEB_VIEW = "/main/webview";
    public static final String ROUTE_PATH_LOGIN = "/main/login";


    /**
     * 跳转webview
     * @param url
     */
    public static void toWebView(String url) {
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.H5_URL, url);
        jumpToPage(ROUTE_PATH_WEB_VIEW, bundle);
    }

    /**
     * 登录页面
     */
    public static void toLogin(String account) {
        Bundle bundle = new Bundle();
        bundle.putString("account", account);
        jumpToPage(ROUTE_PATH_LOGIN, bundle);
    }

    /**
     * 页面跳转
     */
    public static void jumpToPage(Activity context, String path, Bundle bundle, int requestCode, NavigationCallback callback) {
        ARouter.getInstance()
                .build(path)
                .with(bundle)
                .navigation(context, requestCode, callback);
    }

    public static void jumpToPage(String path, Bundle bundle) {
        jumpToPage(null,path,bundle,-1,null);
    }

    public static void jumpToPage(String path) {
        jumpToPage(path, null);
    }

    public static void navToPage(Uri uri) {
        ARouter.getInstance().build(uri).navigation();
    }
}

package com.application.sxm.revie.util;

import android.net.Uri;
import android.support.annotation.NonNull;

/**
 * WebView跳转封装
 * Created by shixiaoming on 18/11/1.
 */
public class HybridClient {

    public static final String HTTP = "http:";
    public static final String HTTPS = "https:";
    public static final String AROUTER = "arouter:";

    /**
     * 普通H5跳转
     * native链接跳转到native页
     * @param url
     */
    public static void commonJump(@NonNull String url) {
        if (url.startsWith(HTTP) || url.startsWith(HTTPS)) {
            RevieRoute.toWebView(url);
        } else if (url.startsWith(AROUTER)) {
            Uri uri = Uri.parse(url);
            RevieRoute.navToPage(uri);
        }
    }

}

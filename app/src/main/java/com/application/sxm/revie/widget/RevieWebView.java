package com.application.sxm.revie.widget;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.application.sxm.revie.model.AppConstants;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import java.io.File;

/**
 * webview封装
 * Created by shixiaoming on 18/11/1.
 */
public class RevieWebView extends WebView{

    private WebTitleCallback titleCallback;

    public RevieWebView(Context context) {
        this(context, null);
    }

    public RevieWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RevieWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);//允许js
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);//网页布局方式
        settings.setDomStorageEnabled(true);//支持dom 存储
        settings.setAppCacheEnabled(true);//支持缓存
        settings.setDatabaseEnabled(true);//数据库
        settings.setAppCacheMaxSize(Long.MAX_VALUE);//缓存区大小
        File cacheDir = new File(context.getExternalCacheDir(), AppConstants.CACHE_DIR_H5);
        if (!cacheDir.exists()) {
            cacheDir.mkdir();
        }
        settings.setAppCachePath(cacheDir.getAbsolutePath());//设置缓存路径
        settings.setSupportMultipleWindows(false);//禁止多窗口
        settings.setJavaScriptCanOpenWindowsAutomatically(true);//js打开新页面
        settings.setAllowFileAccess(true);//文件访问
        settings.setSupportZoom(false);//禁止缩放
        settings.setDisplayZoomControls(false);//隐藏缩放按钮
        settings.setBuiltInZoomControls(false);//禁止手势缩放
        settings.setLoadWithOverviewMode(true);//缩放至屏幕大小
        settings.setUseWideViewPort(true);//屏幕自适应
        settings.setDefaultTextEncodingName("utf-8");//默认文本格式
        settings.setLoadsImagesAutomatically(true);//自动加载图片
        settings.setSavePassword(false);//禁止保存密码

        setWebViewClient(new RevieWebViewClient());
        setWebChromeClient(new RevieChromeClient());
    }
    @Override
    public void loadUrl(String s) {
        //url 格式化处理
        try {
            Uri uri = Uri.parse(s);
            if (TextUtils.isEmpty(uri.getScheme())) {
                loadData(s, "text/html; charset=UTF-8", null);
            } else {
                super.loadUrl(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
            loadData(s, "text/html; charset=UTF-8", null);
        }
    }
    /**
     * 回收
     */
    public void onDestroy() {
        loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        clearHistory();
        ((ViewGroup) getParent()).removeView(this);
        setWebViewClient(null);
        setWebChromeClient(null);
        destroy();
    }

    public class RevieChromeClient extends WebChromeClient{
        @Override
        public void onReceivedTitle(WebView webView, String s) {
            if (titleCallback != null) {
                titleCallback.onReceivedTitle(s);
            }
        }
    }

    public void setWebViewCallback(WebTitleCallback callback) {
        titleCallback = callback;
    }

    public interface WebTitleCallback {
        /**
         * 回调title
         */
        void onReceivedTitle(String title);
    }
}

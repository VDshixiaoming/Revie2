package com.application.sxm.revie.activity;

import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.application.sxm.revie.R;

import butterknife.BindView;

/**
 * Web页面
 * Created by shixiaoming on 18/10/12.
 */
@Route(path = "/main/webview")
public class WebViewActivity extends BaseActivity{

    @BindView(R.id.webview)
    WebView mWebView;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_webview_activity;
    }

    @Override
    public void initView() {
        mWebView.loadUrl("file:///android_asset/url_route_test.html");
    }
}

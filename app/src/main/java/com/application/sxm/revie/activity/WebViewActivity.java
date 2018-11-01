package com.application.sxm.revie.activity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.application.sxm.revie.R;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;

/**
 * Web页面
 * Created by shixiaoming on 18/10/12.
 */
@Route(path = "/main/webview")
public class WebViewActivity extends BaseActivity{

    @BindView(R.id.webview)
    WebView mWebView;

    @Autowired
    String mLoadUrl;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_webview_activity;
    }

    @Override
    public void initView() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mLoadUrl = getIntent().getExtras().getString("url");
        }

        mWebView.loadUrl(mLoadUrl);
    }
}

package com.application.sxm.revie.activity;


import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.R;
import com.application.sxm.revie.widget.RevieWebView;

import butterknife.BindView;

/**
 * Web页面
 * Created by shixiaoming on 18/10/12.
 */
@Route(path = "/main/webview")
public class WebViewActivity extends BaseActivity implements RevieWebView.WebTitleCallback{

    @BindView(R.id.container)
    FrameLayout mContainer;

    @Autowired(name = "h5Url")
    String mLoadUrl;

    private RevieWebView mWebView;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_webview_activity;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
        showBack();
        initWebView();
    }

    private void initWebView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.MATCH_PARENT);
        mWebView = new RevieWebView(this);
        mContainer.addView(mWebView, layoutParams);
        mWebView.setWebViewCallback(this);
        mWebView.loadUrl(mLoadUrl);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
        mWebView.resumeTimers();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
        mWebView.pauseTimers();
    }

    @Override
    public void onReceivedTitle(String title) {
        setTitle(title);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.destroy();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        /**
         * 拦截返回键
         */
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView != null && mWebView.canGoBack()) {
                mWebView.goBack();
                return true;
            }
            return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void showBack() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.revie_ic_back_white);
        }
    }

}

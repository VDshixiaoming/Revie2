package com.application.sxm.revie.widget;

import android.graphics.Bitmap;

import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/**
 * webviewclient封装
 * Created by shixiaoming on 18/11/1.
 */
public class RevieWebViewClient extends WebViewClient{

    private ResourceInterceptCallback interceptCallback;

    private boolean isLoaded = false;

    @Override
    public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
        if (!isLoaded) {
            isLoaded = true;
            webView.loadUrl(s);
        }
        super.onPageStarted(webView, s, bitmap);
    }

    @Override
    public void onPageFinished(WebView webView, String s) {
        super.onPageFinished(webView, s);
        if (interceptCallback != null) {
            interceptCallback.pageFinish(s);
        }
    }

    @Override
    public void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError sslError) {
        handler.proceed();//处理证书
    }



    /**
     * 拦截资源加载
     * @param webView
     * @param s
     * @return
     */
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView webView, String s) {
        if (interceptCallback != null) {
            try {
                return (WebResourceResponse) interceptCallback.requestResource(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return super.shouldInterceptRequest(webView, s);
    }


    public void setWebViewSonicCallback(ResourceInterceptCallback callback) {
        interceptCallback = callback;
    }

    /**
     * 资源加载回调
     */
    public interface ResourceInterceptCallback {
        void pageFinish(String url);

        Object requestResource(String url);
    }


}

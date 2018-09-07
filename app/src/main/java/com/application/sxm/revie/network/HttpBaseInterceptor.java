package com.application.sxm.revie.network;

import android.support.annotation.NonNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Http基础拦截器，添加公共参数
 * Created by shixiaoming on 18/9/7.
 */
public class HttpBaseInterceptor implements Interceptor{

    private Map<String, String> baseParams = new HashMap<>();

    public HttpBaseInterceptor(){

    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();

        Request.Builder requestBuilder = originRequest.newBuilder();
        requestBuilder.method(originRequest.method(), originRequest.body());

        //添加公共参数到请求头
        if (baseParams.size() > 0){
           for (Map.Entry<String, String> params : baseParams.entrySet()){
               requestBuilder.header(params.getKey(), params.getValue());
           }
        }

        Request newRequest = requestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * 构造器
     */
    public static class Builder{
        HttpBaseInterceptor mInterceptor;

        public Builder(){
            mInterceptor = new HttpBaseInterceptor();
        }

        public Builder addHeaderParam(@NonNull String key, @NonNull String value){
            mInterceptor.baseParams.put(key, value);
            return this;
        }

        public Builder addHeaderParams(Map<String, String> params){
            mInterceptor.baseParams.putAll(params);
            return this;
        }

        public HttpBaseInterceptor build(){
            return mInterceptor;
        }
    }
}

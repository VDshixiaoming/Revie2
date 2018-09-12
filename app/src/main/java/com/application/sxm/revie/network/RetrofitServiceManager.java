package com.application.sxm.revie.network;

import com.application.sxm.revie.model.AppConstants;
import com.application.sxm.revie.util.UserInfoUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 网络配置
 * 创建OkHttpClient，设置拦截参数
 * Created by shixiaoming on 18/9/7.
 */
public class RetrofitServiceManager {

    private static final int CONNECT_TIME_OUT = 5;//连接超时
    private static final int IO_TIME_OUT = 10;//读写超时


    private Retrofit mRetrofit;

    private RetrofitServiceManager(){

    }

    /**
     * 静态内部类单例
     */
    private static class SingletonHolder{
        private static final RetrofitServiceManager INSTANCE = new RetrofitServiceManager();
    }

    /**
     * 获取实例
     * @return
     */
    public static RetrofitServiceManager getInstance(){
        return SingletonHolder.INSTANCE;
    }

    /**
     * 获取Service
     */
    public <T> T create(Class<T> service){
        if (mRetrofit == null) {
            createOkHttpClient();
        }
        return mRetrofit.create(service);
    }

    /**
     * 创建OkHttpClient
     */
    private void createOkHttpClient(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //设置超时时间
        builder.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        builder.writeTimeout(IO_TIME_OUT, TimeUnit.SECONDS);
        builder.readTimeout(IO_TIME_OUT, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);//重试

        //设置拦截器参数
        HttpBaseInterceptor baseInterceptor = new HttpBaseInterceptor.Builder()
                .addHeaderParams(getBaseParams())
                .build();
        builder.addInterceptor(baseInterceptor);

        //创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(AppConstants.DOUBAN_BASE_URL)
                .build();
    }

    /**
     * 公共参数
     * @return
     */
    private Map<String, String> getBaseParams(){
        Map<String, String> params = new HashMap<>();
        params.put("platform", "android");
        params.put("deviceId", UserInfoUtil.getDeviceId());

        return params;
    }

}

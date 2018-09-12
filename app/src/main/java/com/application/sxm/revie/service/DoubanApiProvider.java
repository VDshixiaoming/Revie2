package com.application.sxm.revie.service;

import android.content.Context;

import com.application.sxm.revie.model.MovieListModel;
import com.application.sxm.revie.network.RetrofitServiceManager;

import io.reactivex.Observable;

/**
 * 豆瓣接口提供类
 * Created by shixiaoming on 18/9/11.
 */
public class DoubanApiProvider {

    private static DoubanApiProvider apiProvider;
    private DoubanService service;

    public DoubanApiProvider(Context context) {

        service = RetrofitServiceManager.getInstance().create(DoubanService.class);
    }

    public static DoubanApiProvider getInstance (Context context) {
        if (apiProvider == null) {
            apiProvider = new DoubanApiProvider(context);
        }
        return apiProvider;
    }

    /**
     * 获取热门电影
     * @return
     */
    public Observable<MovieListModel> getHotMovie() {
        return service.getHotMovie();
    }
}

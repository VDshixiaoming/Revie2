package com.application.sxm.revie.service;

import com.application.sxm.revie.model.MovieModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 豆瓣api
 * Created by shixiaoming on 18/9/7.
 */
public interface DoubanService {

    /**
     * 获取豆瓣Top250电影榜单ios
     */
    @GET("top250")
    Observable<MovieModel> getTopMovies(@Query("start") int start, @Query("count")int count);

}

package com.application.sxm.revie.service;

import com.application.sxm.revie.model.MovieListModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 豆瓣api
 * Created by shixiaoming on 18/9/7.
 */
public interface DoubanService {

    /**
     * 获取豆瓣Top250电影榜单
     */
    @GET("top250")
    Observable<MovieListModel> getTopMovies(@Query("start") int start, @Query("count")int count);

    /**
     * 豆瓣热映电影
     */
    @GET("v2/movie/in_theaters")
    Observable<MovieListModel> getHotMovie();
}

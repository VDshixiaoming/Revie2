package com.application.sxm.revie.model;

import java.util.List;

/**
 * 电影实体mdoel
 * Created by shixiaoming on 18/9/11.
 */
public class MovieItemBean {
    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;

    private CommonImageBean images;
    private String alt;
    private String id;
    private List<String> genres;

    private List<MovieCastsBean> casts;

    private List<MovieCastsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public CommonImageBean getImages() {
        return images;
    }

    public void setImages(CommonImageBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<MovieCastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<MovieCastsBean> casts) {
        this.casts = casts;
    }

    public List<MovieCastsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<MovieCastsBean> directors) {
        this.directors = directors;
    }
}

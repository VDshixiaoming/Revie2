package com.application.sxm.revie.model;

import java.util.List;

/**
 * 热门电影列表model
 * Created by shixiaoming on 18/9/7.
 */
public class MovieListModel {

    private int count;
    private int start;
    private int total;
    private String title;

    private List<MovieItemBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MovieItemBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieItemBean> subjects) {
        this.subjects = subjects;
    }


}

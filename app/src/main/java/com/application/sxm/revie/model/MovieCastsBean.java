package com.application.sxm.revie.model;

/**
 * 电影截图model
 * Created by shixiaoming on 18/9/11.
 */
public class MovieCastsBean {

    private String alt;
    private CommonImageBean avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public CommonImageBean getAvatars() {
        return avatars;
    }

    public void setAvatars(CommonImageBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

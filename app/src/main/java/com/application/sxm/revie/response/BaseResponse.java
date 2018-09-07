package com.application.sxm.revie.response;

/**
 * 基础response
 * Created by shixiaoming on 18/9/7.
 */
public class BaseResponse<T> {

    public int status;
    public String message;

    public T data;

    public boolean isSuccess(){
        return status == 200;
    }
}

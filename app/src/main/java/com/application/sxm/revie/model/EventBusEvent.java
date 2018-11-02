package com.application.sxm.revie.model;

import android.support.annotation.NonNull;

/**
 * eventbus事件基类
 * Created by shixiaoming on 18/11/2.
 */
public class EventBusEvent<T> {
    private int eventId;
    private T data;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public EventBusEvent(int eventId, @NonNull T data) {
        this.eventId = eventId;
        this.data = data;
    }
}

package com.application.sxm.revie.util;

import com.application.sxm.revie.model.EventBusEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * EventBus辅助类
 * Created by shixiaoming on 18/11/2.
 */
public class EventBusUtil {

    public static void sentEvent(int id, Object event) {
        EventBus.getDefault().post(new EventBusEvent(id, event));
    }

    public static void sentStickyEvent(int id, Object event) {
        EventBus.getDefault().postSticky(new EventBusEvent(id, event));
    }

    public static void registerEventBus(Object subscriber) {
        EventBus.getDefault().register(subscriber);
    }

    public static void unregisterEventBus(Object subscriber) {
        EventBus.getDefault().removeAllStickyEvents();
        EventBus.getDefault().unregister(subscriber);
    }
}

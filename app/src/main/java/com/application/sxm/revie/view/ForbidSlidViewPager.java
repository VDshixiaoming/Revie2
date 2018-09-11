package com.application.sxm.revie.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 禁止滑动ViewPager
 * Created by shixiaoming on 18/9/11.
 */
public class ForbidSlidViewPager extends ViewPager{

    public ForbidSlidViewPager(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //不处理事件
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //不拦截事件，向下透传
        return false;
    }
}

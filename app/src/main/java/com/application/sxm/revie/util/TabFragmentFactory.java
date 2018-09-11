package com.application.sxm.revie.util;

import com.application.sxm.revie.fragment.HomeFragment;
import com.application.sxm.revie.fragment.MineFragment;
import com.application.sxm.revie.fragment.TicketFragment;
import com.application.sxm.revie.fragment.VideoFragment;

/**
 * 首页Fragment工厂
 * Created by shixiaoming on 18/9/11.
 */
public class TabFragmentFactory {

    private static TabFragmentFactory mInstance;

    private HomeFragment homeFragment;
    private TicketFragment ticketFragment;
    private VideoFragment videoFragment;
    private MineFragment mineFragment;

    public static TabFragmentFactory getInstance(){
        if(mInstance == null){
            synchronized (TabFragmentFactory.class) {
                if (mInstance == null) {
                   mInstance = new TabFragmentFactory();
                }
            }
        }
        return mInstance;
    }

    public HomeFragment getHomeFragment(){
        if (homeFragment == null) {
            synchronized (TabFragmentFactory.class) {
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
            }
        }
        return homeFragment;
    }

    public TicketFragment getTicketFragment(){
        if (ticketFragment == null) {
            synchronized (TabFragmentFactory.class) {
                if (ticketFragment == null) {
                    ticketFragment = new TicketFragment();
                }
            }
        }
        return ticketFragment;
    }

    public VideoFragment getVideoFragment(){
        if (videoFragment == null) {
            synchronized (TabFragmentFactory.class) {
                if (videoFragment == null) {
                    videoFragment = new VideoFragment();
                }
            }
        }
        return videoFragment;
    }

    public MineFragment getMineFragment(){
        if (mineFragment == null) {
            synchronized (TabFragmentFactory.class) {
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                }
            }
        }
        return mineFragment;
    }
}

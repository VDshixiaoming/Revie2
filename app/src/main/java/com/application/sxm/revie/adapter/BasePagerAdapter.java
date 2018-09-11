package com.application.sxm.revie.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * 首页viewpager adapter
 * Created by shixiaoming on 18/9/11.
 */
public class BasePagerAdapter extends FragmentPagerAdapter{

    private List<?> mFragmentList;
    private List<String> mTitleList;


    public BasePagerAdapter (FragmentManager manager, List<?> mFragmentList, List<String> mTitleList) {
        super(manager);
        this.mFragmentList = mFragmentList;
        this.mTitleList = mTitleList;
    }

    public BasePagerAdapter (FragmentManager manager, List<?> mFragmentList) {
        super(manager);
        this.mFragmentList = mFragmentList;
    }
    @Override
    public Fragment getItem(int position) {
        return (Fragment) mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList == null ? 0 : mFragmentList.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitleList != null) {
            return mTitleList.get(position);
        } else {
            return "";
        }
    }

    public void addFragmentList(List<?> list){
        this.mFragmentList.clear();
        this.mFragmentList = null;
        this.mFragmentList = list;
        notifyDataSetChanged();
    }
}

package com.application.sxm.revie.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.application.sxm.revie.R;
import com.application.sxm.revie.adapter.BasePagerAdapter;
import com.application.sxm.revie.fragment.BaseFragment;
import com.application.sxm.revie.util.BottomNavigationViewHelper;
import com.application.sxm.revie.util.TabFragmentFactory;
import com.application.sxm.revie.view.ForbidSlidViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 首页
 * Created by shixiaoming on 18/9/10.
 */
public class MainTabActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ForbidSlidViewPager viewPager;
    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_video:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_ticket:
                    viewPager.setCurrentItem(2);
                    return true;
                case R.id.navigation_my:
                    viewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };


    @Override
    public int getContentViewRes() {
        return R.layout.revie_activity_main_tab;
    }

    @Override
    public void initView() {
        BottomNavigationViewHelper.disableShiftMode(navigationView);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initViewPager();
    }

    @Override
    public void initData() {

    }

    private void initViewPager(){
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(TabFragmentFactory.getInstance().getHomeFragment());
        fragments.add(TabFragmentFactory.getInstance().getVideoFragment());
        fragments.add(TabFragmentFactory.getInstance().getTicketFragment());
        fragments.add(TabFragmentFactory.getInstance().getMineFragment());

        BasePagerAdapter adapter = new BasePagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setCurrentItem(0);
    }

}

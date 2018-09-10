package com.application.sxm.revie.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import com.application.sxm.revie.R;
import com.application.sxm.revie.util.BottomNavigationViewHelper;

import butterknife.BindView;

public class MainTabActivity extends BaseActivity {

    @BindView(R.id.message)
    TextView mTextMessage;
    @BindView(R.id.navigation)
    BottomNavigationView navigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_ticket:
                    mTextMessage.setText(R.string.title_ticket);
                    return true;
                case R.id.navigation_video:
                    mTextMessage.setText(R.string.title_video);
                    return true;
                case R.id.navigation_my:
                    mTextMessage.setText(R.string.title_my);
                    return true;
            }
            return false;
        }
    };

    @Override
    public int getContentViewRes() {
        return R.layout.activity_main_tab;
    }

    @Override
    public void initView() {
        BottomNavigationViewHelper.disableShiftMode(navigationView);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void initData() {

    }

}

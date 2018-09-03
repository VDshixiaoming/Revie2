package com.application.sxm.revie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.application.sxm.revie.util.BottomNavigationViewHelper;

public class MainTabActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView navigationView;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

        navigationView = findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(navigationView);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

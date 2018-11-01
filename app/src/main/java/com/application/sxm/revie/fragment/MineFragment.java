package com.application.sxm.revie.fragment;

import android.view.View;
import android.widget.TextView;

import com.application.sxm.revie.R;
import com.application.sxm.revie.model.AppConstants;
import com.application.sxm.revie.util.HybridClient;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 我的fragment
 * Created by shixiaoming on 18/9/11.
 */
public class MineFragment extends BaseFragment{

    @BindView(R.id.title)
    TextView title;

    @BindView(R.id.url_link)
    TextView link;

    @BindView(R.id.native_link)
    TextView nativeLink;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_fragment_mine;
    }

    @Override
    public void initView() {

    }

    @OnClick({R.id.title, R.id.url_link, R.id.native_link})
    public void onViewClick(View v) {
        switch (v.getId()) {
            case R.id.title:
                HybridClient.commonJump(AppConstants.LOCAL_HTML_TEST);
                break;
            case R.id.url_link:
                HybridClient.commonJump(link.getText().toString());
                break;
            case R.id.native_link:
                HybridClient.commonJump(nativeLink.getText().toString());
                break;
        }
    }

    @Override
    public void initData() {

    }
}

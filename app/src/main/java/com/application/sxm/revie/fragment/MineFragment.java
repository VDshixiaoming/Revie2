package com.application.sxm.revie.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.R;
import com.application.sxm.revie.model.AppConstants;

import butterknife.BindView;

/**
 * 我的fragment
 * Created by shixiaoming on 18/9/11.
 */
public class MineFragment extends BaseFragment{

    @BindView(R.id.title)
    TextView title;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_fragment_mine;
    }

    @Override
    public void initView() {
        final Bundle bundle = new Bundle();
        bundle.putString("url", AppConstants.LOCAL_HTML_TEST);
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance()
                        .build("/main/webview")
                        .with(bundle)
                        .navigation();
            }
        });
    }

    @Override
    public void initData() {

    }
}

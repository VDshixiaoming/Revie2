package com.application.sxm.revie.activity;

import android.text.TextUtils;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.application.sxm.revie.R;

import butterknife.BindView;

/**
 * 登录页面
 * Created by shixiaoming on 18/10/16.
 */
@Route(path="/main/login")
public class LoginActivity extends BaseActivity{

    @BindView(R.id.account)
    EditText accountTv;

    @BindView(R.id.password)
    EditText passwordTv;

    @Autowired
    String account;

    @Override
    public int getContentViewRes() {
        return R.layout.revie_login_layout;
    }

    @Override
    public void initView() {
        ARouter.getInstance().inject(this);
        if (!TextUtils.isEmpty(account)) {
            passwordTv.requestFocus();
        }

        accountTv.setText(account);
    }

}

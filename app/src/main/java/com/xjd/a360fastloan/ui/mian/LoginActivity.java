package com.xjd.a360fastloan.ui.mian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<BasePresenter, ActivityLoginBinding> {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected boolean isTitleBar() {
        return false;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}

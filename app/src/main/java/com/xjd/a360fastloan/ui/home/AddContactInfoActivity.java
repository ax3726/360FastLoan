package com.xjd.a360fastloan.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAddContactInfoBinding;

public class AddContactInfoActivity extends BaseActivity<BasePresenter, ActivityAddContactInfoBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_contact_info;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("联系人信息");
    }
}

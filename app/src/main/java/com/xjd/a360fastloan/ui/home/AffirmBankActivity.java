package com.xjd.a360fastloan.ui.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAffirmBankBinding;

public class AffirmBankActivity extends BaseActivity<BasePresenter, ActivityAffirmBankBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_affirm_bank;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("银行卡信息");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CreditAssessActivity.class);
            }
        });
    }
}

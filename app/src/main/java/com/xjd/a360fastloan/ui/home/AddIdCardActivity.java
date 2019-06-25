package com.xjd.a360fastloan.ui.home;

import android.view.KeyEvent;
import android.view.View;

import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAddIdCardBinding;
import com.xjd.a360fastloan.widget.dialog.BackDialog;

public class AddIdCardActivity extends BaseActivity<BasePresenter, ActivityAddIdCardBinding> {


    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_id_card;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("基本信息");
        mTitleBarLayout.setLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackDialog backDialog = new BackDialog(aty, new BackDialog.BackDialogListener() {
                    @Override
                    public void onback() {
                        finish();
                    }
                });
                backDialog.show();
            }
        });
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.btnTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AddContactInfoActivity.class);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            BackDialog backDialog = new BackDialog(aty, new BackDialog.BackDialogListener() {
                @Override
                public void onback() {
                    finish();
                }
            });
            backDialog.show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

}

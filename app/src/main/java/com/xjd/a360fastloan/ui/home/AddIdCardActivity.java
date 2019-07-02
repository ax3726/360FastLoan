package com.xjd.a360fastloan.ui.home;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

import com.bumptech.glide.Glide;
import com.lm.lib_common.base.BasePresenter;
import com.lm.lib_common.utils.dialog.MyItemDialogListener;
import com.lm.lib_common.utils.dialog.StytledDialog;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivityAddIdCardBinding;
import com.xjd.a360fastloan.ui.common.PhotoActivity;
import com.xjd.a360fastloan.widget.dialog.BackDialog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddIdCardActivity extends PhotoActivity<BasePresenter, ActivityAddIdCardBinding> {

    private int mType = 0;//0 正面 1 反面

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
        mBinding.flyJust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> strings = new ArrayList<>();
                strings.add("拍照");
                strings.add("从相册选择");
                StytledDialog.showBottomItemDialog(aty, strings, "安全退出", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        mType = 0;
                        switch (position) {
                            case 0:
                                doPhoto();
                                break;
                            case 1:
                                pickphoto();
                                break;
                        }
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                });
            }
        });
        mBinding.flyBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final List<String> strings = new ArrayList<>();
                strings.add("拍照");
                strings.add("从相册选择");
                StytledDialog.showBottomItemDialog(aty, strings, "安全退出", true, true, new MyItemDialogListener() {
                    @Override
                    public void onItemClick(String text, int position) {
                        mType = 1;
                        switch (position) {
                            case 0:
                                doPhoto();
                                break;
                            case 1:
                                pickphoto();
                                break;
                        }
                    }

                    @Override
                    public void onBottomBtnClick() {
                        showToast("onItemClick");
                    }
                });
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

    @Override
    public void photoSuccess(String path, File file, int... queue) {
        if (!TextUtils.isEmpty(path)) {
//            if (mType == 0) {
//                Glide.with(aty).load(file).into(mBinding.imgJust);
//            } else {
//                Glide.with(aty).load(file).into(mBinding.imgBack);
//            }
        }
    }

    @Override
    public void photoFaild() {

    }
}

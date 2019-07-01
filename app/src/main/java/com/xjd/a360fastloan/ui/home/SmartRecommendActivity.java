package com.xjd.a360fastloan.ui.home;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.lm.lib_common.adapters.recyclerview.CommonAdapter;
import com.lm.lib_common.adapters.recyclerview.base.ViewHolder;
import com.lm.lib_common.base.BaseActivity;
import com.lm.lib_common.base.BasePresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.ActivitySmartRecommendBinding;

import java.util.ArrayList;
import java.util.List;

public class SmartRecommendActivity extends BaseActivity<BasePresenter, ActivitySmartRecommendBinding> {


    private List<String>          mDataList = new ArrayList<>();
    private CommonAdapter<String> mAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_smart_recommend;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("智能推荐");
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        mBinding.tvContent.setText("1. 速贷种类每次只可选择一件产品\n2. 推荐产品年化率10%-35%\n3. 放款失败我们将服务费以借币的形式退还到您的钱包\n4.以上产品均为第三方提供");
    }

    @Override
    protected void initData() {
        super.initData();
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mAdapter = new CommonAdapter<String>(aty, R.layout.item_recommend_layout, mDataList) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {

                TextView tv_money_old=holder.getView(R.id.tv_money_old);
                tv_money_old.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            }
        };
        mBinding.rcBody.setLayoutManager(new LinearLayoutManager(aty));
        mBinding.rcBody.setNestedScrollingEnabled(false);
        mBinding.rcBody.setAdapter(mAdapter);

    }
}

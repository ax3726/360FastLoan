package com.xjd.a360fastloan.ui.home;

import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.FragmentHomeBinding;

/**
 * @author ：LiMing
 * @date ：2019-06-17
 * @desc ：
 */
public class HomeFragment extends BaseFragment<BaseFragmentPresenter, FragmentHomeBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();

    }
}

package com.xjd.a360fastloan.ui.mine;

import com.lm.lib_common.base.BaseFragment;
import com.lm.lib_common.base.BaseFragmentPresenter;
import com.xjd.a360fastloan.R;
import com.xjd.a360fastloan.databinding.FragmentHomeBinding;
import com.xjd.a360fastloan.databinding.FragmentMineBinding;

/**
 * @author ：LiMing
 * @date ：2019-06-17
 * @desc ：
 */
public class MineFragment extends BaseFragment<BaseFragmentPresenter, FragmentMineBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected BaseFragmentPresenter createPresenter() {
        return null;
    }
}

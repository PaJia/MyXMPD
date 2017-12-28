package com.example.administrator.xiangmuone.ui.fragment.xmzb;


import android.support.v4.app.Fragment;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Xmzb_BianFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {


    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_xmzb__bian;
    }

    @Override
    public void show(String res) {

    }
}

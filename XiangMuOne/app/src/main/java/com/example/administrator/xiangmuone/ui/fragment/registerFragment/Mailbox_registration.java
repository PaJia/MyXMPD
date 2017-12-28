package com.example.administrator.xiangmuone.ui.fragment.registerFragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mailbox_registration extends BaseFragment<NetPresenter, NetModel> {


    private Button zhuce;


    @Override
    protected void initView(View view) {
        zhuce = (Button) view.findViewById(R.id.zc2);

        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "注册", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mailbox_registration;
    }
}

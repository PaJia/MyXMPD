package com.example.administrator.xiangmuone.ui.fragment.registerFragment;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Mobile_registration extends BaseFragment<NetPresenter, NetModel> implements View.OnClickListener {


    private EditText number;
    private EditText code;
    private EditText verification;
    private Button obtain;
    private EditText password;
    private Button register;


    @Override
    protected void initView(View view) {
        //手机号
        number = (EditText) view.findViewById(R.id.sjh);
        //图片验证码
        code = (EditText) view.findViewById(R.id.tpm);
        //短息验证码
        verification = (EditText) view.findViewById(R.id.dxyzm);
        //获取验证吗
        obtain = (Button) view.findViewById(R.id.button_yzm);
        //输入密码
        password = (EditText) view.findViewById(R.id.srmm);
        //注册
        register = (Button) view.findViewById(R.id.button_zc);


        obtain.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mobile_registration;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_yzm:
                Toast.makeText(getContext(), "获取验证码", Toast.LENGTH_LONG).show();
                break;

            case R.id.button_zc:
                Toast.makeText(getContext(), "注册成功", Toast.LENGTH_LONG).show();
                break;

        }
    }
}

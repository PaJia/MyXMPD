package com.example.administrator.xiangmuone.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.ui.adapter.PagerAdapter;
import com.example.administrator.xiangmuone.ui.fragment.registerFragment.Mailbox_registration;
import com.example.administrator.xiangmuone.ui.fragment.registerFragment.Mobile_registration;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fh4;
    private TabLayout tablayout;
    private ViewPager viewpa;
    private ArrayList<Fragment> lists;
    private ArrayList<String> lise;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏

        setContentView( R.layout.activity_register);
        initView();
    }


    protected void initView() {
        fh4 = (TextView) findViewById(R.id.fh4);
        tablayout = (TabLayout) findViewById(R.id.tablay);
        viewpa = (ViewPager) findViewById(R.id.viewp);
        fh4.setOnClickListener(this);


        lists = new ArrayList<Fragment>();
        lists.add(new Mobile_registration());
        lists.add(new Mailbox_registration());

        lise = new ArrayList<String>();
        lise.add("手机注册");
        lise.add("邮箱注册");


        PagerAdapter registerAdapter = new PagerAdapter(getSupportFragmentManager(), lise, lists);
        tablayout.setupWithViewPager(viewpa);
        viewpa.setAdapter(registerAdapter);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fh4: {
                finish();
            }
        }
    }
}

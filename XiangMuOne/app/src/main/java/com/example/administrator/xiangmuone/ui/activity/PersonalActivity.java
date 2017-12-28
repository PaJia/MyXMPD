package com.example.administrator.xiangmuone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.xiangmuone.R;


public class PersonalActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView fh2;
    private LinearLayout sign_in;
    private LinearLayout watching;
    private LinearLayout collection;
    private LinearLayout set_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        initView();


    }

    private void initView() {
        fh2 = (TextView) findViewById(R.id.fh2);
        fh2.setOnClickListener(this);

        sign_in = (LinearLayout) findViewById(R.id.sign_in);
        sign_in.setOnClickListener(this);

        watching = (LinearLayout) findViewById(R.id.watching);
        watching.setOnClickListener(this);

        collection = (LinearLayout) findViewById(R.id.collection);
        collection.setOnClickListener(this);

        set_up = (LinearLayout) findViewById(R.id.set_up);
        set_up.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 返回
            case R.id.fh2:
              finish();
                break;
            // 登录
            case R.id.sign_in:
                Intent intent1 = new Intent(PersonalActivity.this,Sign_inActivity.class);
                startActivity(intent1);
                break;
            // 观看历史
            case R.id.watching:

                break;
            // 我的收藏
            case R.id.collection:

                break;
            // 设置
            case R.id.set_up:

                break;

        }
    }
}

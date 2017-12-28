package com.example.administrator.xiangmuone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xiangmuone.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class Sign_inActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView fh3;
    private TextView zc;
    private LinearLayout qq_sgin;
    private LinearLayout wx_sign;
    private LinearLayout wb_sign;
    private EditText editText2;
    private EditText editText3;
    private TextView forget;
    private Button sgin;
    private UMShareAPI mShareAPI;
    private View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏

        setContentView(R.layout.activity_shi_pin);
        initView();
    }


    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {

            Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }


    };


    protected void initView() {
        view = View.inflate(this, R.layout.activity_sign_in, null);
        setContentView(view);

        fh3 = (TextView) findViewById(R.id.fh5);
        zc = (TextView) findViewById(R.id.zc);
        qq_sgin = (LinearLayout) findViewById(R.id.qq_sgin);
        wx_sign = (LinearLayout) findViewById(R.id.wx_sign);
        wb_sign = (LinearLayout) findViewById(R.id.wb_sign);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        forget = (TextView) findViewById(R.id.forget);
        sgin = (Button) findViewById(R.id.sgin);


        fh3.setOnClickListener(this);
        zc.setOnClickListener(this);
        qq_sgin.setOnClickListener(this);
        wx_sign.setOnClickListener(this);
        wb_sign.setOnClickListener(this);
        forget.setOnClickListener(this);
        sgin.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            //返回
            case R.id.fh5:

                finish();

                break;
            //注册
            case R.id.zc:
                Intent intent1 = new Intent(Sign_inActivity.this, RegisterActivity.class);
                startActivity(intent1);
                Toast.makeText(this, "注册", Toast.LENGTH_SHORT).show();


                break;
            //qq登录
            case R.id.qq_sgin:


                UMShareAPI.get(Sign_inActivity.this).getPlatformInfo(Sign_inActivity.this, SHARE_MEDIA.QQ, authListener);


                break;

            //微信登录
            case R.id.wx_sign:
                Toast.makeText(this, "微信登录", Toast.LENGTH_SHORT).show();
                break;

            //微博登录
            case R.id.wb_sign:
                Toast.makeText(this, "微博登录", Toast.LENGTH_SHORT).show();
                break;

            //忘记密码
            case R.id.forget:
                Toast.makeText(this, "忘记密码", Toast.LENGTH_SHORT).show();
                break;

            //登录
            case R.id.sgin:
                Toast.makeText(this, "登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}

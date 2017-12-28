package com.example.administrator.xiangmuone.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.administrator.xiangmuone.R;


public  class BbWebActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView fh1;
    private WebView bbwebview;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_xmbb);
        initView();

        bbwebview.loadUrl(name);

        bbwebview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });



    }

    private void initView() {
        fh1 = (TextView) findViewById(R.id.fh1);
        bbwebview = (WebView) findViewById(R.id.bbwebview);
        fh1.setOnClickListener(BbWebActivity.this);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fh1 :
                finish();
                break;
        }
    }

}

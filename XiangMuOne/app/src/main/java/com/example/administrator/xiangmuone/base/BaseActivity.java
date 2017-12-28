package com.example.administrator.xiangmuone.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.utils.App;
import com.example.administrator.xiangmuone.utils.TUtils;

public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends AppCompatActivity implements View.OnClickListener {
    public P mPresenter;
    public M mModel;
    private FrameLayout frameLayout;
    public static TextView mTitle;
    public static ImageView mImage,mImages,mImagess;
    public static ImageButton mSy;
    public static ImageButton mXmzb;
    public static ImageButton mGgsp;
    public static ImageButton mXmbb;
    public static ImageButton mZbzg;
    private long firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        mTitle = (TextView) findViewById(R.id.title);
        mImage = (ImageView) findViewById(R.id.tab_image);
        mImages = (ImageView) findViewById(R.id.hd);
        mImagess= (ImageView) findViewById(R.id.gr);
        frameLayout = (FrameLayout) findViewById(R.id.frame);
        mImage.setOnClickListener(this);
        mImages.setOnClickListener(this);
        mImagess.setOnClickListener(this);
        App.baseActivity = this;
        mPresenter = TUtils.getT(this, 0);
        mModel = TUtils.getT(this, 1);
        if (this instanceof BaseView) {
            mPresenter.setMV(mModel, this);
        }
        initView();
    }

    protected abstract void initView();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

    }

    @Override
    public void setContentView(View view) {
        frameLayout.removeAllViews();
        frameLayout.addView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                int count=getSupportFragmentManager().getBackStackEntryCount();
                if(count > 0)//这里是取出我们返回栈存在Fragment的个数
                {

                    String name=getSupportFragmentManager().getBackStackEntryAt(count-1).getName();


                    if (name.equals("shouye")|name.equals("gungun")|name.equals("bobao")|name.equals("zhibo")|name.equals("zhongguo")) {
                        getSupportFragmentManager().popBackStack(name,0);
                    }

                }
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(BaseActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onResume() {
        /**
         * 设置为竖屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

}

package com.example.administrator.xiangmuone.utils;

import android.app.Application;

import com.example.administrator.xiangmuone.base.BaseActivity;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2017/12/18.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }

    public static BaseActivity baseActivity;
    public static BaseFragment baseFragment;

    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
}

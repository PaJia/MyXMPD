package com.example.administrator.xiangmuone.ui.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.administrator.xiangmuone.R;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

public class ShiPinActivity extends AppCompatActivity {

    private NiceVideoPlayer mNiceVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏

        setContentView(R.layout.activity_shi_pin);
        init();
    }

    private void init() {
        mNiceVideoPlayer = (NiceVideoPlayer) findViewById(R.id.nice_video_player);
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        mNiceVideoPlayer.setUp("http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/14/bfe0d8eaad33462d8a6346820100f91b_h264818000nero_aac32.mp4", null);

        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle("123456789");
        mNiceVideoPlayer.setController(controller);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 在onStop时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在Activity中onBackPress要交给NiceVideoPlayer先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        /**
         * 设置为横屏
         */
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
        super.onResume();
    }


}

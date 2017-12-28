package com.example.administrator.xiangmuone.ui.fragment.xmzb;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.xmzb.Xmzb_ZbBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.PagerAdapter;
import com.google.gson.Gson;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZhiBoFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View{
    private NiceVideoPlayer mImageView;
    private TextView mTextView, mXy;
    private CheckBox checkBox;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> mlist = new ArrayList<>();
        private TabLayout tabLayout1;
    private ViewPager pager1;
    private FragmentManager fragmentManager;
//    private Button mBtn_duo, mBtn_bian;
//    private FrameLayout mframe;
    private boolean boo = true;
    private String url;
    private TxVideoPlayerController mController;

    @Override
    protected void initView(View view) {
        Bundle bundle = getArguments();
        url = bundle.getString("url");

        mController = new TxVideoPlayerController(getActivity());

        mPresenter.getModel(url);

        fragmentManager = getFragmentManager();

        tabLayout1 = (TabLayout) view.findViewById(R.id.zblive_tab);
        pager1 = (ViewPager) view.findViewById(R.id.zblive_pager);

//        mBtn_bian = (Button) view.findViewById(R.id.zb_bu_bian);
//        mBtn_duo = (Button) view.findViewById(R.id.zb_bu_duo);
//        mframe = (FrameLayout) view.findViewById(R.id.zb_frame);
//        mBtn_duo.setOnClickListener(this);
//        mBtn_bian.setOnClickListener(this);

        mImageView = (NiceVideoPlayer) view.findViewById(R.id.zb_video_player);
        mTextView = (TextView) view.findViewById(R.id.xmzb_zb_bt);
        mXy = (TextView) view.findViewById(R.id.xmzb_xy);
        checkBox = (CheckBox) view.findViewById(R.id.xmzb_zb_sx);
        checkBox.setButtonDrawable(R.drawable.live_china_detail_down);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mXy.setVisibility(View.GONE);
                    checkBox.setButtonDrawable(R.drawable.live_china_detail_down);
                } else {
                    checkBox.setButtonDrawable(R.drawable.live_china_detail_up);
                    mXy.setVisibility(View.VISIBLE);
                }
            }

        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zhi_bo;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        Xmzb_ZbBean xmzb_zbBean = gson.fromJson(res, Xmzb_ZbBean.class);
        List<Xmzb_ZbBean.LiveBean> live = xmzb_zbBean.getLive();

        mTextView.setText(live.get(0).getTitle());
        mXy.setText(live.get(0).getBrief());
//        Glide.with(getActivity()).load(live.get(0).getImage()).into(mImageView);
        Glide.with(getContext())
                .load(live.get(0).getImage())
                .crossFade()
                .into(mController.imageView());
        mImageView.setPlayerType(NiceVideoPlayer.TYPE_IJK); // or NiceVideoPlayer.TYPE_NATIVE
        mImageView.setUp("http://vod.cntv.lxdns.com/flash/mp4video60/TMS/2017/06/14/bfe0d8eaad33462d8a6346820100f91b_h264818000nero_aac32.mp4", null);
        mImageView.setController(mController);




        List<Xmzb_ZbBean.BookmarkBean.MultipleBean> multiple = xmzb_zbBean.getBookmark().getMultiple();
        List<Xmzb_ZbBean.BookmarkBean.WatchTalkBean> watchTalk = xmzb_zbBean.getBookmark().getWatchTalk();

//
//        mBtn_bian.setText(multiple.get(0).getTitle());
//        mBtn_duo.setText(watchTalk.get(0).getTitle());



        if (boo) {


            list.add(multiple.get(0).getTitle());
            list.add(watchTalk.get(0).getTitle());


            Xmzb_DuoFragment xmzb_duoFragment = new Xmzb_DuoFragment();
            Bundle bundle=new Bundle();
            String url = multiple.get(0).getUrl();
            bundle.putString("url",url);
            xmzb_duoFragment.setArguments(bundle);

            mlist.add(xmzb_duoFragment);
            mlist.add(new Xmzb_BianFragment());


            boo = false;
        }


        PagerAdapter mAdapetr = new PagerAdapter(fragmentManager, list, mlist);
        pager1.setAdapter(mAdapetr);
        tabLayout1.setupWithViewPager(pager1);

    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.zb_bu_duo:
//                FragmentBuilder.getInstance().init().add(R.id.zb_frame, Xmzb_DuoFragment.class, false);
//                break;
//            case R.id.zb_bu_bian:
//                FragmentBuilder.getInstance().init().add(R.id.zb_frame, Xmzb_BianFragment.class, false);
//                break;
//        }
//    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getModel(url);
    }
}

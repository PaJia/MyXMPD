package com.example.administrator.xiangmuone.ui.fragment.zbzg;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.zbzg.Zbzg_recyBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.adapter.zbzg.MyZbzg_TabAdapter;
import com.google.gson.Gson;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Zbzg_FuYongFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
private RecyclerView recyclerView;
    private MyZbzg_TabAdapter adapter;

    @Override
    protected void initView(View view) {

        Bundle arguments = getArguments();
        String url = arguments.getString("url");

        recyclerView= (RecyclerView) view.findViewById(R.id.zbzg_recy);

     mPresenter.getModel(url);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zbzg__fu_yong;
    }

    @Override
    public void show(String res) {
        Gson gson=new Gson();
        Zbzg_recyBean zbzg_recyBean = gson.fromJson(res, Zbzg_recyBean.class);
        List<Zbzg_recyBean.LiveBean> live = zbzg_recyBean.getLive();

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyZbzg_TabAdapter(live, getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
            @Override
            public void onViewRecycled(RecyclerView.ViewHolder holder) {
                NiceVideoPlayer niceVideoPlayer = ((MyZbzg_TabAdapter.ViewHolder) holder).imageView;
                if (niceVideoPlayer == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
                    NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                }
            }
        });

    }
    @Override
    public void onStop() {
        super.onStop();
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }
}

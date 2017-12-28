package com.example.administrator.xiangmuone.ui.fragment.xmzb;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.ggsp.GGspBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.activity.ShiPinActivity;
import com.example.administrator.xiangmuone.ui.adapter.ggsp.MyGGspRecyAdapter;
import com.google.gson.Gson;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
        private RecyclerView recyclerView;
    private String murl = "http://api.cntv.cn/video/videolistById?vsid=VSET100219009515&n=7&serviceId=panda&o=desc&of=time&p=1";
    private MyGGspRecyAdapter adapter;

    @Override
    protected void initView(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.newsrecy);

        Bundle bundle = getArguments();
        String index = bundle.getString("murl");
        mPresenter.getModel("http://www.ipanda.com/kehuduan/video/index.json");
//        mPresenter.getModel(murl);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void show(String res) {

        Gson gson = new Gson();
        GGspBean gGspBean = gson.fromJson(res, GGspBean.class);
        List<GGspBean.ListBean> list = gGspBean.getList();


        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new MyGGspRecyAdapter(list, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(new MyGGspRecyAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);
            }
        });

//        NewsBean newsBean = gson.fromJson(res, NewsBean.class);
//        List<NewsBean.VideoBean> video = newsBean.getVideo();
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.setAdapter(new MyXmzb_newsRecyAdapter(video,getActivity()));


    }
}

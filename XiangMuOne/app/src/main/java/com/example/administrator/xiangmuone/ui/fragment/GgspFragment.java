package com.example.administrator.xiangmuone.ui.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.ggsp.GGspBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.activity.ShiPinActivity;
import com.example.administrator.xiangmuone.ui.adapter.ggsp.MyGGspRecyAdapter;
import com.example.administrator.xiangmuone.utils.App;
import com.google.gson.Gson;

import java.util.List;

import me.leefeng.lfrecyclerview.LFRecyclerView;

/**
 * A simple {@link Fragment} subclass.
 */
public class GgspFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private LFRecyclerView recyclerView;
    private ImageView imageView;
    private TextView textView;
    private List<GGspBean.BigImgBean> bigImg;
    private MyGGspRecyAdapter adapter;

    @Override
    protected void initView(View view) {
        App.baseFragment = this;
        recyclerView = (LFRecyclerView) view.findViewById(R.id.ggrecy);
        mPresenter.getModel("http://www.ipanda.com/kehuduan/video/index.json");

        View viewt = LayoutInflater.from(getActivity()).inflate(R.layout.ggsp_tou, null);
        imageView = (ImageView) viewt.findViewById(R.id.gg_tou_image);
        textView = (TextView) viewt.findViewById(R.id.gg_tou_text);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShiPinActivity.class);
                startActivity(intent);
            }
        });


        recyclerView.setLoadMore(true);
        recyclerView.setRefresh(true);
        recyclerView.setHeaderView(viewt);

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        GGspBean newsBean = gson.fromJson(res, GGspBean.class);
        List<GGspBean.ListBean> video = newsBean.getList();


        bigImg = newsBean.getBigImg();
        Glide.with(getActivity()).load(bigImg.get(0).getImage()).into(imageView);
        textView.setText(bigImg.get(0).getTitle());
        adapter = new MyGGspRecyAdapter(video, getActivity());
        recyclerView.setAdapter(adapter);
        adapter.setOnClick(new MyGGspRecyAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Intent intent = new Intent(getActivity(), ShiPinActivity.class);
                startActivity(intent);
            }
        });
    }
}

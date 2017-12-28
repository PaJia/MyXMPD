package com.example.administrator.xiangmuone.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.sy.SY_GgspBean;
import com.example.administrator.xiangmuone.bean.sy.SY_JingCanBean;
import com.example.administrator.xiangmuone.bean.sy.ShouYeBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.activity.ShiPinActivity;
import com.example.administrator.xiangmuone.ui.adapter.sy.MySY_ZbRecyAdapter;
import com.example.administrator.xiangmuone.ui.adapter.sy.MySy_GGRecyAdapter;
import com.example.administrator.xiangmuone.ui.adapter.sy.MySy_JCRecyAdapter;
import com.example.administrator.xiangmuone.ui.adapter.sy.MySy_RecyAdapter;
import com.example.administrator.xiangmuone.utils.App;
import com.example.administrator.xiangmuone.utils.Callbacks;
import com.example.administrator.xiangmuone.utils.Ok;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShouYeFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private Banner banner;
    private ArrayList<String> bannImageList = new ArrayList<>();
    private ArrayList<String> bannTitleList = new ArrayList<>();
    private boolean boo = true;
    private TextView xmbb, zbxc, jcyk, ggsp, zbzg, aa_a, aa_b, bb_a, bb_b;
    private ImageView mImage;
    private RecyclerView recyclerView, jc_recy, gg_recy, zb_recy;
    private ShouYeBean shouYeBean;
    private MySY_ZbRecyAdapter mySYZbRecyAdapter;
    private MySy_GGRecyAdapter mySyGgRecyAdapter;
    private MySy_JCRecyAdapter mySyJcRecyAdapter;
    private MySy_RecyAdapter mySyRecyAdapter;


    @Override
    protected void initView(View view) {
        App.baseFragment = this;
        mPresenter.getModel("http://www.ipanda.com/kehuduan/shouye/index.json");
        banner = (Banner) view.findViewById(R.id.banner);
        xmbb = (TextView) view.findViewById(R.id.sy_xmbb);
        zbxc = (TextView) view.findViewById(R.id.sy_zbxc);
        jcyk = (TextView) view.findViewById(R.id.sy_jcyk);
        ggsp = (TextView) view.findViewById(R.id.sy_ggsp);
        zbzg = (TextView) view.findViewById(R.id.sy_zbzg);
        aa_a = (TextView) view.findViewById(R.id.aa_aa);
        aa_b = (TextView) view.findViewById(R.id.aa_bb);
        bb_a = (TextView) view.findViewById(R.id.bb_aa);
        bb_b = (TextView) view.findViewById(R.id.bb_bb);
        mImage = (ImageView) view.findViewById(R.id.sy_tp);
        recyclerView = (RecyclerView) view.findViewById(R.id.recy);
        jc_recy = (RecyclerView) view.findViewById(R.id.jcykRecy);
        gg_recy = (RecyclerView) view.findViewById(R.id.ggspRecy);
        zb_recy = (RecyclerView) view.findViewById(R.id.zbzgRecy);


    }


    private void initBann() {

        banner.setImages(bannImageList)
                .setBannerTitles(bannTitleList)
                .setDelayTime(2000)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .setImageLoader(new GlideImage())
                .setIndicatorGravity(BannerConfig.RIGHT)
                .start();

        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);
            }
        });
    }


    public class GlideImage extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_a;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();
        shouYeBean = gson.fromJson(res, ShouYeBean.class);
        List<ShouYeBean.DataBean.BigImgBean> bigImg = shouYeBean.getData().getBigImg();
        if (boo) {
            for (int i = 0; i < bigImg.size(); i++) {
                bannImageList.add(bigImg.get(i).getImage());
                bannTitleList.add(bigImg.get(i).getTitle());
            }

            boo = false;
        }
        initBann();

        initXmbb();

        initZbxc();

        initJcyk();

        initGgsp();

        initZbzg();


    }


    private void initZbzg() {
        zbzg.setText(shouYeBean.getData().getChinalive().getTitle());
        List<ShouYeBean.DataBean.ChinaliveBean.ListBeanX> list = shouYeBean.getData().getChinalive().getList();
        zb_recy.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mySYZbRecyAdapter = new MySY_ZbRecyAdapter(list, getActivity());
        zb_recy.setAdapter(mySYZbRecyAdapter);
        mySYZbRecyAdapter.setOnClick(new MySY_ZbRecyAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initGgsp() {
        ggsp.setText(shouYeBean.getData().getList().get(0).getTitle());
        String listUrl = shouYeBean.getData().getList().get(0).getListUrl();
        Ok.getTran().sendGet(listUrl, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                Gson gson = new Gson();
                SY_GgspBean sy_ggspBean = gson.fromJson(string, SY_GgspBean.class);
                List<SY_GgspBean.ListBean> list = sy_ggspBean.getList();
                gg_recy.setLayoutManager(new GridLayoutManager(getActivity(), 1));
                mySyGgRecyAdapter = new MySy_GGRecyAdapter(list, getActivity());
                gg_recy.setAdapter(mySyGgRecyAdapter);
                mySyGgRecyAdapter.setOnClick(new MySy_GGRecyAdapter.OnClickItem() {
                    @Override
                    public void setClick(View v, int position) {
                        Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });


    }

    private void initJcyk() {
        jcyk.setText(shouYeBean.getData().getCctv().getTitle());
        String listurl = shouYeBean.getData().getCctv().getListurl();
        Ok.getTran().sendGet(listurl, new Callbacks() {
            @Override
            public void callback_Method(String string) {
                Gson gson = new Gson();
                SY_JingCanBean sy_jingCanBean = gson.fromJson(string, SY_JingCanBean.class);
                List<SY_JingCanBean.ListBean> list = sy_jingCanBean.getList();
                jc_recy.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                mySyJcRecyAdapter = new MySy_JCRecyAdapter(list, getActivity());
                jc_recy.setAdapter(mySyJcRecyAdapter);
                mySyJcRecyAdapter.setOnClick(new MySy_JCRecyAdapter.OnClickItem() {
                    @Override
                    public void setClick(View v, int position) {
                        Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });


    }

    private void initZbxc() {
        List<ShouYeBean.DataBean.PandaliveBean.ListBean> list = shouYeBean.getData().getPandalive().getList();
        zbxc.setText(shouYeBean.getData().getPandalive().getTitle());
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mySyRecyAdapter = new MySy_RecyAdapter(list, getActivity());
        recyclerView.setAdapter(mySyRecyAdapter);
        mySyRecyAdapter.setOnClick(new MySy_RecyAdapter.OnClickItem() {
            @Override
            public void setClick(View v, int position) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);     }
        });

    }

    private void initXmbb() {
        xmbb.setText(shouYeBean.getData().getPandaeye().getTitle());
        Glide.with(getActivity()).load(shouYeBean.getData().getPandaeye().getPandaeyelogo()).into(mImage);
        aa_a.setText(shouYeBean.getData().getPandaeye().getItems().get(0).getBrief());
        aa_b.setText(shouYeBean.getData().getPandaeye().getItems().get(0).getTitle());
        bb_a.setText(shouYeBean.getData().getPandaeye().getItems().get(1).getBrief());
        bb_b.setText(shouYeBean.getData().getPandaeye().getItems().get(1).getTitle());

        aa_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);
            }
        });

        bb_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),ShiPinActivity.class);
                startActivity(intent);
            }
        });

    }



}

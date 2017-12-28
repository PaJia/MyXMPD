package com.example.administrator.xiangmuone.ui.fragment.zbzg;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.xiangmuone.AlllistBeanDao;
import com.example.administrator.xiangmuone.GreenDAo;
import com.example.administrator.xiangmuone.R;
import com.example.administrator.xiangmuone.TablistBeanDao;
import com.example.administrator.xiangmuone.base.BaseFragment;
import com.example.administrator.xiangmuone.bean.AlllistBean;
import com.example.administrator.xiangmuone.bean.BaseZg;
import com.example.administrator.xiangmuone.bean.TablistBean;
import com.example.administrator.xiangmuone.bean.zbzg.Zbzg_ZhuBean;
import com.example.administrator.xiangmuone.net.NetContract;
import com.example.administrator.xiangmuone.net.NetModel;
import com.example.administrator.xiangmuone.net.NetPresenter;
import com.example.administrator.xiangmuone.ui.activity.MainZgActivity;
import com.example.administrator.xiangmuone.ui.adapter.PagerAdapter;
import com.example.administrator.xiangmuone.utils.App;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ZbzgFragment extends BaseFragment<NetPresenter, NetModel> implements NetContract.View {
    private TabLayout tabLayout;
    private ViewPager pager;
    private ImageView imageView;
    private AlllistBeanDao dao;
    private TablistBeanDao daos;
    private FragmentManager fragmentManager;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<Fragment> mlist = new ArrayList<>();
    private List<TablistBean> tablist;


    @Override
    protected void initView(View view) {
        App.baseFragment = this;
        fragmentManager = getFragmentManager();

        tabLayout = (TabLayout) view.findViewById(R.id.zbzg_tab);
        pager = (ViewPager) view.findViewById(R.id.zbzg_pager);
        imageView = (ImageView) view.findViewById(R.id.zg_imge);
        dao = GreenDAo.getTan(getActivity()).getDao();
        daos = GreenDAo.getTan(getActivity()).getDaos();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainZgActivity.class);
                startActivity(intent);


            }
        });


    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_e;
    }

    @Override
    public void show(String res) {
        Gson gson = new Gson();

        tablist = daos.queryBuilder().list();
        if (tablist.size() > 0 && tablist != null) {
            list.clear();
            for (int i = 0; i < tablist.size(); i++) {
                list.add(tablist.get(i).getTitle());
                mlist.clear();
                for (int j = 0; j < list.size(); j++) {
                    Zbzg_FuYongFragment fyfragment = new Zbzg_FuYongFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", tablist.get(j).getUrl());
                    fyfragment.setArguments(bundle);
                    mlist.add(fyfragment);
                }
                PagerAdapter mAdapetr = new PagerAdapter(fragmentManager, list, mlist);
                tabLayout.setupWithViewPager(pager);
                pager.setAdapter(mAdapetr);
                mAdapetr.notifyDataSetChanged();
            }
        } else {            Zbzg_ZhuBean zbzg_zhuBean = gson.fromJson(res, Zbzg_ZhuBean.class);
            BaseZg baseZg = gson.fromJson(res, BaseZg.class);
            List<TablistBean> tablist1 = baseZg.getTablist();
            List<Zbzg_ZhuBean.TablistBean> tablistas = zbzg_zhuBean.getTablist();

            for (int i = 0; i < tablist1.size(); i++) {
                list.add(tablist1.get(i).getTitle());

                mlist.clear();
                for (int j = 0; j < list.size(); j++) {
                    Zbzg_FuYongFragment fyfragment = new Zbzg_FuYongFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("url", tablistas.get(j).getUrl());
                    fyfragment.setArguments(bundle);
                    mlist.add(fyfragment);
                }
                PagerAdapter mAdapetr = new PagerAdapter(fragmentManager, list, mlist);
                tabLayout.setupWithViewPager(pager);
                pager.setAdapter(mAdapetr);
                mAdapetr.notifyDataSetChanged();
                daos.insertInTx(tablist1);
                BaseZg baseZgs = gson.fromJson(res, BaseZg.class);
                List<AlllistBean> alllist = baseZgs.getAlllist();
                alllist.removeAll(tablist1);
                dao.insertInTx(alllist);
                mPresenter.notifyAll();

            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.getModel("http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json");

    }
}

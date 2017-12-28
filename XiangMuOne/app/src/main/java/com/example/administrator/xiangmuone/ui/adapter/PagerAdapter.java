package com.example.administrator.xiangmuone.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class PagerAdapter extends FragmentPagerAdapter{
    private ArrayList<String> list=new ArrayList<>();
    private ArrayList<Fragment> mlist=new ArrayList<>();

    public PagerAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> mlist) {
        super(fm);
        this.list = list;
        this.mlist = mlist;
    }

    @Override
    public Fragment getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}

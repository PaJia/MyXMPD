package com.example.administrator.xiangmuone.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.administrator.xiangmuone.base.BaseFragment;


public class FragmentBuilder {
    private static volatile FragmentBuilder fragmentBuilder;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragmentByTag;
    private Fragment fragment;

    public FragmentBuilder(){

    }

    public static FragmentBuilder getInstance() {
        if (fragmentBuilder == null){
            synchronized (FragmentBuilder.class){
                fragmentBuilder = new FragmentBuilder();
            }
        }
        return fragmentBuilder;
    }

    public FragmentBuilder init(){
        manager = App.baseActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
        return this;
    }

    public FragmentBuilder add(int containerId, Class<? extends BaseFragment> fragmentClass, boolean isChild){
        //用Fragment的名字设置一个tag值
        String tag = fragmentClass.getSimpleName();
        //使用tag值来判断当前Fragment是否实例化
        fragment = manager.findFragmentByTag(tag);
        //
        if (fragment == null){
            try {
                //使用单例创建Fragment对象
                fragment = fragmentClass.newInstance();
                //使用add方法添加到容器中
                transaction.add(containerId,fragment,tag);
                //调用添加回退栈方法进行栈管理
                //addToBackStack():  添加回退栈
                transaction.addToBackStack(tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (!isChild ) {
            if (App.baseFragment != null){
                transaction.hide(App.baseFragment);
            }
        }
      /*  if (!tag.equals("zhibo")) {
            Fragment fragment1 = manager.findFragmentByTag("zhibo");
            if (fragment1 != null) {
                transaction.hide(fragment1);
            }

        }*/

    //show()：显示当前Fragment
        transaction.show(fragment);
        return this;
}


    public void Builder(){
        App.baseFragment = (BaseFragment) fragment;
        transaction.commit();
    }
}

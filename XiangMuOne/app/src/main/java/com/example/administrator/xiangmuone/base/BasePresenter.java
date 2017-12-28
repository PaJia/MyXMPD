package com.example.administrator.xiangmuone.base;

/**
 * Created by Administrator on 2017/12/18.
 */
public abstract class BasePresenter<M, V> {
    public M baseModel;
    public V baseView;
    public void setMV(M m,V v){
        baseModel=m;
        baseView=v;
        this.onStart();
    }

    public abstract void onStart();
}

package com.example.administrator.xiangmuone.net;

import com.example.administrator.xiangmuone.base.BaseModel;
import com.example.administrator.xiangmuone.base.BasePresenter;
import com.example.administrator.xiangmuone.base.BaseView;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/18.
 */
public interface NetContract {

    interface View extends BaseView {
      void show(String res);
    }

    interface Model extends BaseModel {
        void getDataNet(String url, Map<String,Object> map,CallBacks callBacks);
        void getNet(String url,CallBacks callBacks);
    }

    abstract static class Presenter extends BasePresenter<Model, View> {

        @Override
        public void onStart() {

        }

        public abstract void getNetModel(String url,Map<String,Object> map);
        public abstract void getModel(String url);

    }
}
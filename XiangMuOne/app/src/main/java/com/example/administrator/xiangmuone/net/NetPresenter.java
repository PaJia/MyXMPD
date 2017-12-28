package com.example.administrator.xiangmuone.net;

import java.util.Map;

/**
 * Created by TMVPHelper on 2017/12/18
 */
public class NetPresenter extends NetContract.Presenter {


    @Override
    public void getNetModel(String url, Map<String, Object> map) {
        baseModel.getDataNet(url, map, new CallBacks() {
            @Override
            public void succ(String res) {
                baseView.show(res);
            }
        });
    }

    @Override
    public void getModel(String url) {
        baseModel.getNet(url, new CallBacks() {
            @Override
            public void succ(String res) {
                baseView.show(res);
            }
        });
    }
}
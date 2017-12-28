package com.example.administrator.xiangmuone.net;

import android.os.Handler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TMVPHelper on 2017/12/18
 */
public class NetModel implements NetContract.Model {
    private static NetModel netModel;
    private OkHttpClient client;
    private Handler handler;
    private String urls;
    private Set<String> keySet;


    public NetModel() {
        client = new OkHttpClient();
        handler = new Handler();
    }


    @Override
    public void getDataNet(String url, Map<String, Object> map, final CallBacks callBacks) {
        StringBuffer sb = new StringBuffer();
        urls = "";
        if (map != null && map.size() > 0) {
            sb.append("?");
            keySet = map.keySet();
            for (String key : keySet) {
                Object o = map.get(key);
                sb.append(key).append("=").append(o).append("&");
            }

            urls = (sb.deleteCharAt(sb.length() - 1)).toString();
        }


        Request request = new Request.Builder().url(urls).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.succ(string);
                    }
                });
            }
        });

    }

    @Override
    public void getNet(String url, final CallBacks callBacks) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBacks.succ(string);
                    }
                });
            }
        });

    }


}
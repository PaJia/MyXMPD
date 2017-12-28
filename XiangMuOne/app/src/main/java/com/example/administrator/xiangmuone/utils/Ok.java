package com.example.administrator.xiangmuone.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Ok {
    private static Ok ok;
    private OkHttpClient build;

    private  Ok() {
        build = new OkHttpClient.Builder().build();
    }
    public static synchronized Ok getTran(){
        if (ok==null){
            ok = new Ok();
        }
        return ok;
    }
    public void sendGet(String url, final Callbacks callbacks){
        Request builds = new Request.Builder().url(url).build();
        Call call = build.newCall(builds);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callbacks.callback_Method(string);
                    }
                });
            }
        });
    }
}

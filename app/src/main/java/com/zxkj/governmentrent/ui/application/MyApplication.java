package com.zxkj.governmentrent.ui.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 林炜智 on 2016/3/5.
 */
public class MyApplication extends Application {
    //  Volley网络请求
    public static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getHttpRequestQueue() {
        return requestQueue;
    }
}

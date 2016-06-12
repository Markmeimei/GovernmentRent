package com.zxkj.governmentrent.ui.application;

import android.content.Context;

import com.android.volley.RequestQueue;

/**
 * Created by 林炜智 on 2015/9/23.
 */
public class ApplicationTools {
    //  Volley网络请求
    public static RequestQueue requestQueue;
    //  全局用户信息

    public static RequestQueue getHttpRequestQueue(Context context) {
        if (context == null)
            return null;
        MyApplication app = (MyApplication) context.getApplicationContext();
        requestQueue = app.getHttpRequestQueue();
        return requestQueue;
    }
}

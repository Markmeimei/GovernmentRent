package com.zxkj.governmentrent.utils;

import android.os.Handler;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.zxkj.governmentrent.ui.application.MyApplication;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by 林炜智 on 2016/3/7.
 */
public class VolleyUtil<T> implements Serializable {
    public final static String Tag = "VolleyUtil";

    static Handler handler = new Handler();

    public interface GetCallback {
        public void onSuccess(String result, List list);

        public void onFailure(VolleyError error);
    }

    public interface PostCallback {
        public void onSuccess(String result, List list);

        public void onFailure(VolleyError error);
    }

    /**
     * Get请求解析Json
     */
    public void get(String Url, final Class clss, final String Tag, final GetCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                Log.e(Tag, response);
                String jsonString = response;
                if (jsonString.startsWith("ï»¿"))
                    jsonString = jsonString.substring(3);
                if (jsonString.startsWith("{"))
                    jsonString = "{\"data\":[" + jsonString + "]}";
                else if (jsonString.startsWith("["))
                    jsonString = "{\"data\":" + jsonString + "}";
                else
                    jsonString = response;
                final CommonJson<T> jsonList = CommonJson.fromJson(jsonString.replace("T", " "), clss);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response, jsonList.getData());
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error);
            }
        });
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }

    /**
     * Post请求解析Json
     */
    public void post(String Url, final Class clss, final String Tag, final Map<String, String> map, final PostCallback callback) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                Log.e(Tag, response);
                String jsonString = response;
                if (jsonString.startsWith("ï»¿"))
                    jsonString = jsonString.substring(3);
                else if (jsonString.startsWith("{"))
                    jsonString = "{\"data\":[" + jsonString + "]}";
                else if (jsonString.startsWith("["))
                    jsonString = "{\"data\":" + jsonString + "}";
                else
                    jsonString = response;
                final CommonJson<T> jsonList = CommonJson.fromJson(jsonString, clss);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(response, jsonList.getData());
                    }
                });
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.onFailure(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }

    public void cancel(String Tag) {
        MyApplication.getHttpRequestQueue().cancelAll(Tag);
    }

    /**
     * Get请求解析Json（为了打印Log）
     */
    public void get(String Url, final String Tag) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                Log.e(Tag, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(Tag, error.toString());
            }
        });
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }

    /**
     * Post请求解析Json（为了打印Log）
     */
    public void post(String Url, final String Tag, final Map<String, String> map) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, Url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String response) {
                Log.e(Tag, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(Tag, error.toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        stringRequest.setTag(Tag);
        MyApplication.getHttpRequestQueue().add(stringRequest);
    }
}

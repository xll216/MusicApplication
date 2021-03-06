package com.lanou.xiao.musicapplication.http.okhttp;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

public class OkHttpRequestImpl implements IHttpRequest {

    private OkHttpClient mOkHttpClient;
    private Gson mGson;
    private Handler mHandler;

    public OkHttpRequestImpl() {
        File fileDir = Environment.getDownloadCacheDirectory();
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .cache(new Cache(fileDir, 10 * 1024 * 1024)).build();
        mGson = new Gson();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public <T> void startGetRequest(String url, Class<T> tClass, OnCompletedListener<T> listener) {
        Request request = new Request.Builder().url(url).build();
        asynRequest(tClass, listener, request);
    }

    @Override
    public <T> void startGetRequest(String url, Map<String, String> header, Class<T> tClass, OnCompletedListener<T> listener) {
        Request request = new Request.Builder().url(url).headers(Headers.of(header)).build();
        asynRequest(tClass, listener, request);
    }

    @Override
    public <T> void startPostRequest(String url, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        FormBody body = getFormBody(requestBody);
        Request request = new Request.Builder().url(url).post(body).build();
        asynRequest(tClass, listener, request);
    }

    @Override
    public <T> void startPostRequest(String url, Map<String, String> header, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        FormBody body = getFormBody(requestBody);
        Request request = new Request.Builder().url(url).post(body).headers(Headers.of(header)).build();
        asynRequest(tClass, listener, request);
    }

    @Override
    public <T> void startTypeGetRequest(String url, final Type type, final OnCompletedListener<T> listener) {
        Request request = new Request.Builder().url(url).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final List<T> list = mGson.fromJson(response.body().string(), type);
                if (list != null && list.size() > 0) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onCompleted(list);
                        }
                    });
                } else {
                    listener.onFailed();
                }
            }
        });
    }

    @NonNull
    private FormBody getFormBody(@NonNull Map<String, String> requestBody) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : requestBody.keySet()) {
            builder.add(key, requestBody.get(key));
        }
        return builder.build();
    }

    private <T> void completed(final T result, final OnCompletedListener<T> listener) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onCompleted(result);
            }
        });
    }

    private <T> void error(final OnCompletedListener<T> listener) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailed();
            }
        });
    }

    private <T> void asynRequest(final Class<T> clazz, final OnCompletedListener<T> listener, Request request) {
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                error(listener);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (response.isSuccessful()) {
                    final T result = mGson.fromJson(response.body().string(), clazz);
                    completed(result, listener);
                } else {
                    error(listener);
                }
            }
        });
    }
}

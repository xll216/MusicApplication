package com.lanou.xiao.musicapplication.http.okhttp;

import java.lang.reflect.Type;
import java.util.Map;

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

public class HttpMananger {
    private IHttpRequest iHttpRequest;

    private HttpMananger() {
        iHttpRequest = new OkHttpRequestImpl();
    }

    public static HttpMananger getInstance() {
        return HttpMananger.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final HttpMananger INSTANCE = new HttpMananger();
    }

    public <T> void getRequest(String url, Class<T> tClass, OnCompletedListener<T> listener) {
        iHttpRequest.startGetRequest(url, tClass, listener);
    }

    public <T> void getRequest(String url, Map<String, String> header, Class<T> tClass, OnCompletedListener<T> listener) {
        iHttpRequest.startGetRequest(url, header, tClass, listener);
    }

    public <T> void postRequest(String url, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        iHttpRequest.startPostRequest(url, requestBody, tClass, listener);
    }

    public <T> void postRequest(String url, Map<String, String> header, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        iHttpRequest.startPostRequest(url, header, requestBody, tClass, listener);
    }

    public <T> void getRequest(String url, Type type, OnCompletedListener<T> listener) {
        iHttpRequest.startTypeGetRequest(url, type, listener);
    }
}

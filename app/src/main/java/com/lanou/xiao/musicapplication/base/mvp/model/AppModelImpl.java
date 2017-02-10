package com.lanou.xiao.musicapplication.base.mvp.model;

import com.lanou.xiao.musicapplication.http.HttpMananger;
import com.lanou.xiao.musicapplication.http.OnCompletedListener;

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
 * 真正的网络请求
 */

public class AppModelImpl implements AppModel {


    @Override
    public <T> void startGetRequest(String url, Class<T> tClass, OnCompletedListener<T> listener) {
        HttpMananger.getInstance().getRequest(url, tClass, listener);
    }

    @Override
    public <T> void startGetRequest(String url, Map<String, String> header, Class<T> tClass, OnCompletedListener<T> listener) {
        HttpMananger.getInstance().getRequest(url, header, tClass, listener);
    }

    @Override
    public <T> void startPostRequest(String url, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        HttpMananger.getInstance().postRequest(url, requestBody, tClass, listener);
    }

    @Override
    public <T> void startPostRequest(String url, Map<String, String> header, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener) {
        HttpMananger.getInstance().postRequest(url, header, requestBody, tClass, listener);
    }

    @Override
    public <T> void startTypeGetRequest(String url, Type type, OnCompletedListener<T> listener) {
        HttpMananger.getInstance().getRequest(url, type, listener);
    }
}

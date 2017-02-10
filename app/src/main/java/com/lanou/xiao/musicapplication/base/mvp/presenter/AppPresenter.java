package com.lanou.xiao.musicapplication.base.mvp.presenter;

import com.lanou.xiao.musicapplication.base.mvp.model.AppModel;
import com.lanou.xiao.musicapplication.base.mvp.model.AppModelImpl;
import com.lanou.xiao.musicapplication.base.mvp.ui.AppView;
import com.lanou.xiao.musicapplication.http.okhttp.OnCompletedListener;

import java.lang.reflect.Type;
import java.util.List;
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
 * 连接view层于model层的中间代理层
 */

public class AppPresenter {
    private AppView appView;
    private AppModel appModel;

    public AppPresenter(AppView appView) {
        this.appView = appView;
        appModel = new AppModelImpl();
    }

    /**
     * get请求
     *
     * @param url    请求地址
     * @param tClass 要解析返回之后的对象类型
     **/
    public <T> void startGetRequest(String url, Class<T> tClass) {
        appModel.startGetRequest(url, tClass, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                appView.showView();
                appView.onResponse(result);
            }

            @Override
            public void onFailed() {
                appView.onError();
            }

            @Override
            public void onCompleted(List<T> list) {
                appView.showView();
                appView.onResponse(list);
            }
        });
    }

    /**
     * get请求
     *
     * @param url    请求地址
     * @param header 请求头集合
     * @param tClass 要解析返回之后的对象类型
     **/
    public <T> void startGetRequest(String url, Map<String, String> header, Class<T> tClass) {
        appModel.startGetRequest(url, header, tClass, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                appView.showView();
                appView.onResponse(result);
            }

            @Override
            public void onFailed() {
                appView.onError();
            }

            @Override
            public void onCompleted(List<T> list) {
                appView.showView();
                appView.onResponse(list);
            }
        });
    }

    /**
     * get请求
     *
     * @param url         请求地址
     * @param requestBody post请求中的参数列表
     * @param tClass      要解析返回之后的对象类型
     **/
    public <T> void startPostRequest(String url, Map<String, String> requestBody, Class<T> tClass) {
        appModel.startPostRequest(url, requestBody, tClass, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                appView.showView();
                appView.onResponse(result);
            }

            @Override
            public void onFailed() {
                appView.onError();
            }

            @Override
            public void onCompleted(List<T> list) {
                appView.showView();
                appView.onResponse(list);
            }
        });
    }

    /**
     * get请求
     *
     * @param url         请求地址
     * @param header      请求头集合
     * @param requestBody post请求中的参数列表
     * @param tClass      要解析返回之后的对象类型
     **/
    public <T> void startPostRequest(String url, Map<String, String> header, Map<String, String> requestBody, Class<T> tClass) {
        appModel.startPostRequest(url, header, tClass, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                appView.showView();
                appView.onResponse(result);
            }

            @Override
            public void onFailed() {
                appView.onError();
            }

            @Override
            public void onCompleted(List<T> list) {
                appView.showView();
                appView.onResponse(list);
            }
        });
    }

    /**
     * get请求
     *
     * @param url  请求地址
     * @param type 要解析返回之后的集合类型
     **/
    public <T> void startTypeGetRequest(String url, Type type) {
        appModel.startTypeGetRequest(url, type, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                appView.showView();
                appView.onResponse(result);
            }

            @Override
            public void onFailed() {
                appView.onError();
            }

            @Override
            public void onCompleted(List<T> list) {
                appView.showView();
                appView.onResponse(list);
            }
        });
    }
}

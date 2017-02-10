package com.lanou.xiao.musicapplication.http;

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
 * 业务逻辑层的网络逻辑请求接口
 */

public interface IHttpRequest {
    /**
     * get请求
     *
     * @param url      请求地址
     * @param tClass   要解析返回之后的对象类型
     * @param listener 网络请求成功之后的接口回调
     **/
    <T> void startGetRequest(String url, Class<T> tClass, OnCompletedListener<T> listener);

    /**
     * get请求
     *
     * @param url      请求地址
     * @param header   请求头集合
     * @param tClass   要解析返回之后的对象类型
     * @param listener 网络请求成功之后的接口回调
     **/
    <T> void startGetRequest(String url, Map<String, String> header, Class<T> tClass, OnCompletedListener<T> listener);

    /**
     * get请求
     *
     * @param url         请求地址
     * @param requestBody post请求中的参数列表
     * @param tClass      要解析返回之后的对象类型
     * @param listener    网络请求成功之后的接口回调
     **/
    <T> void startPostRequest(String url, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener);

    /**
     * get请求
     *
     * @param url         请求地址
     * @param header      请求头集合
     * @param requestBody post请求中的参数列表
     * @param tClass      要解析返回之后的对象类型
     * @param listener    网络请求成功之后的接口回调
     **/
    <T> void startPostRequest(String url, Map<String, String> header, Map<String, String> requestBody, Class<T> tClass, OnCompletedListener<T> listener);

    /**
     * get请求
     *
     * @param url      请求地址
     * @param type     要解析返回之后的集合类型
     * @param listener 网络请求成功之后的接口回调
     **/
    <T> void startTypeGetRequest(String url, Type type, OnCompletedListener<T> listener);

}

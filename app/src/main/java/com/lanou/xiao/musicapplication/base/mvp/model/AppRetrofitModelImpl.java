package com.lanou.xiao.musicapplication.base.mvp.model;

import com.lanou.xiao.musicapplication.bean.BillCategoryBean;
import com.lanou.xiao.musicapplication.bean.GeDanBean;
import com.lanou.xiao.musicapplication.bean.GeDanInfoBean;
import com.lanou.xiao.musicapplication.bean.GetHotGeDanAndOfficialBean;
import com.lanou.xiao.musicapplication.http.RetrofitService;

import rx.Observable;
import rx.Subscriber;

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

public class AppRetrofitModelImpl implements AppRetrofitModel {
    @Override
    public void getHotGeDanAndOfficial(Subscriber<GetHotGeDanAndOfficialBean> subscriber) {
        RetrofitService.getInstance().getHotGeDanAndOfficial(subscriber);
    }

    @Override
    public void billCategory(Subscriber<BillCategoryBean> subscriber) {
        RetrofitService.getInstance().billCategory(subscriber);
    }

    @Override
    public void getGeDanList(Subscriber<GeDanBean> subscriber) {
        RetrofitService.getInstance().getGeDanList(subscriber);
    }

    @Override
    public void getGeDanInfo(int id,Subscriber<GeDanInfoBean> subscriber) {
        RetrofitService.getInstance().getGeDanInfo(id,subscriber);
    }
}

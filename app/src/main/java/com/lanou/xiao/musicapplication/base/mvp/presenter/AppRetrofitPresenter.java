package com.lanou.xiao.musicapplication.base.mvp.presenter;

import com.lanou.xiao.musicapplication.base.mvp.model.AppRetrofitModel;
import com.lanou.xiao.musicapplication.base.mvp.model.AppRetrofitModelImpl;
import com.lanou.xiao.musicapplication.base.mvp.ui.AppView;
import com.lanou.xiao.musicapplication.bean.GetHotGeDanAndOfficialBean;

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

public class AppRetrofitPresenter {
    private AppView appView;
    private AppRetrofitModel appRetrofitModel;

    public AppRetrofitPresenter(AppView appView) {
        this.appView = appView;
        appRetrofitModel = new AppRetrofitModelImpl();
    }

    void getHotGeDanAndOfficial() {
        appRetrofitModel.getHotGeDanAndOfficial(
                new Subscriber<GetHotGeDanAndOfficialBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GetHotGeDanAndOfficialBean hot) {

            }
        });
    }

}

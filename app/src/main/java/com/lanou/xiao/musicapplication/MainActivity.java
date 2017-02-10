package com.lanou.xiao.musicapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanou.xiao.musicapplication.base.BaseActivity;
import com.lanou.xiao.musicapplication.base.mvp.presenter.AppPresenter;
import com.lanou.xiao.musicapplication.base.mvp.ui.AppView;
import com.lanou.xiao.musicapplication.bean.GeDanBean;
import com.lanou.xiao.musicapplication.bean.GetHotGeDanAndOfficialBean;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceCreateMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceReceiveMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceSendMsg;
import com.lanou.xiao.musicapplication.http.Constant;
import com.lanou.xiao.musicapplication.http.RetrofitService;
import com.lanou.xiao.musicapplication.service.FloatViewService;
import com.lanou.xiao.musicapplication.service.MusicService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.ResponseBody;
import rx.Subscriber;

public class MainActivity extends BaseActivity {
    private FragmentManager fm;
    private TextView resultTv;
    private ImageView imageView;
    private AppPresenter hotGedanPresenter, geDanPresenter;
    public MusicService.MyBinder binder;

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MusicService.MyBinder) service;
            Log.d("MainActivity", "binder.getDuration():" + binder.getDuration());
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            binder = null;
        }
    };

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        resultTv = bindView(R.id.resultTv);
        imageView = bindView(R.id.imageIv);
        Log.d("MainActivity", "initView");
        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(conn);
        Intent intent = new Intent(this, MusicService.class);
        stopService(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();

        /*启动底部的播放条*/
        Intent intent = new Intent(this, FloatViewService.class);
        //启动FloatViewService
        startService(intent);
    }

    @Override
    public void initData() {
        fm = getSupportFragmentManager();
        hotGedanPresenter = new AppPresenter(new HotGeDanView());
        hotGedanPresenter.startGetRequest(Constant.URL_GETHOTGEDANANDOFFICIAL, GetHotGeDanAndOfficialBean.class);

        geDanPresenter = new AppPresenter(new GeDanView());
        geDanPresenter.startGetRequest(Constant.URL_GEDAN, GeDanBean.class);

        RetrofitService.getInstance().downloadImage(new Subscriber<ResponseBody>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseBody responseBody) {

                InputStream is = responseBody.byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                imageView.setImageBitmap(bitmap);
            }
        }, Constant.IMG_URL);


        RetrofitService.getInstance().getHotGeDanAndOfficial(new Subscriber<GetHotGeDanAndOfficialBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(GetHotGeDanAndOfficialBean hot) {
                Log.d("MainActivity", "hot.getError_code():" + hot.getError_code());
            }
        });
    }

    private class GeDanView implements AppView<GeDanBean> {

        @Override
        public void showView() {

        }

        @Override
        public void onResponse(GeDanBean geDanBean) {
            Log.d("GeDanView", geDanBean.getTotal() + "");

        }

        @Override
        public void onResponse(List<GeDanBean> geDanBeen) {

        }

        @Override
        public void onError() {

        }
    }

    private class HotGeDanView implements AppView<GetHotGeDanAndOfficialBean> {

        @Override
        public void showView() {

        }

        @Override
        public void onResponse(GetHotGeDanAndOfficialBean hotGedan) {
            Log.d("HotGeDanView", "hotGedan.getError_code():" + hotGedan.getError_code());
        }

        @Override
        public void onResponse(List<GetHotGeDanAndOfficialBean> getHotGeDanAndOfficialBeen) {

        }

        @Override
        public void onError() {

        }
    }

    public void onMyClick(View view) {
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.content, new LocalFragment());
//        ft.addToBackStack(null);
//        ft.commit();
    }

    @Override
    public void onBackPressed() {
        Log.d("MainActivity", "fm.getBackStackEntryCount():" + fm.getBackStackEntryCount());
        if (fm.getBackStackEntryCount() != 0) {
            fm.popBackStack();
        } else {
            super.onBackPressed();
            ServiceUtils.stopMusicService(this);

        }
    }

    /**
     * 服务创建成功之后的回调
     *
     * @param s 收到的创建成功之后的消息
     **/
    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onCreateMessage(ServiceCreateMsg s) {
        ServiceReceiveMsg msg = new ServiceReceiveMsg();
        msg.obj = "获取播放信息";
        EventBus.getDefault().post(msg);
    }

    /**
     * 收到服务发来的播放信息
     *
     * @param msg 服务发来的消息对象
     **/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveServiceMsg(ServiceSendMsg msg) {
        Log.d("MainActivity", msg.obj);
    }

}

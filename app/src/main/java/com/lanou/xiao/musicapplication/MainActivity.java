package com.lanou.xiao.musicapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;

import com.lanou.xiao.musicapplication.base.BaseActivity;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceCreateMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceReceiveMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceSendMsg;
import com.lanou.xiao.musicapplication.service.MusicService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends BaseActivity {
    private FragmentManager fm;
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
    public void initData() {
        fm = getSupportFragmentManager();

    }

    public void onMyClick(View view) {
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.content, new LocalFragment());
        ft.addToBackStack(null);
        ft.commit();
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

package com.lanou.xiao.musicapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lanou.xiao.musicapplication.eventbusmsg.ServiceCreateMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceReceiveMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceSendMsg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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

public class MusicService extends Service {

    public class MyBinder extends Binder{
        public long getDuration(){
            return 11;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("MusicService", "Service onCreate");
        EventBus.getDefault().register(this);
        ServiceCreateMsg msg = new ServiceCreateMsg();
        msg.obj = "Service--onCreate";
        EventBus.getDefault().post(msg);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MusicService", "Service onDestroy");
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onReceiveMessage(ServiceReceiveMsg msg) {
        Log.d("MusicService", msg.obj);
        ServiceSendMsg sendMsg = new ServiceSendMsg();
        sendMsg.obj = "播放信息向外发送";
        EventBus.getDefault().post(sendMsg);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }
}

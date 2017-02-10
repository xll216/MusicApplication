package com.lanou.xiao.musicapplication;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.lanou.xiao.musicapplication.service.MusicService;

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

public class ServiceUtils {
    /*服务的action对象*/
    public static final String SERVICE_ACTION = "com.lanou.xiao.musicapplication.MusicService";

    /**
     * 启动音乐服务
     *
     * @param context 上下文对象
     **/
    public static void startMusicService(Context context) {
        Intent intent = new Intent();
        intent.setAction(SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /**
     * 停止音乐服务
     *
     * @param context 上下文对象
     **/
    public static void stopMusicService(Context context) {
        Intent intent = new Intent();
        intent.setAction(SERVICE_ACTION);
        intent.setPackage(context.getPackageName());
        context.stopService(intent);
    }

    public static void bindMusicService(Context context,ServiceConnection conn){
        Intent intent = new Intent(context,MusicService.class);
        context.bindService(intent,conn,Context.BIND_AUTO_CREATE);
    }

    public static void unBindMusicService(Context context,ServiceConnection conn){
        context.unbindService(conn);
    }
}

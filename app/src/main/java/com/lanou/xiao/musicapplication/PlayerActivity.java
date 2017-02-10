package com.lanou.xiao.musicapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.lanou.xiao.musicapplication.base.BaseActivity;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceReceiveMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceSendMsg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class PlayerActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.activity_player;
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

    @Override
    public void initView() {
        ServiceReceiveMsg msg = new ServiceReceiveMsg();
        msg.obj = "获取播放信息";
        EventBus.getDefault().post(msg);
    }

    @Override
    public void initData() {

    }
}

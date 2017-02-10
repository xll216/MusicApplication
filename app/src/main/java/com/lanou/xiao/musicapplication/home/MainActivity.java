package com.lanou.xiao.musicapplication.home;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.lanou.xiao.musicapplication.R;
import com.lanou.xiao.musicapplication.base.BaseActivity;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceCreateMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceReceiveMsg;
import com.lanou.xiao.musicapplication.eventbusmsg.ServiceSendMsg;
import com.lanou.xiao.musicapplication.musichouse.MusicHouseFragment;
import com.lanou.xiao.musicapplication.service.MusicService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private MusicService.MyBinder binder;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private MainViewPagerAdapter adapter;

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

        initViewPager();//调用初始化

        Intent intent = new Intent(this, MusicService.class);
        bindService(intent, conn, Context.BIND_AUTO_CREATE);

    }

    /**
     * 初始化ViewPager的相关操作
     **/
    public void initViewPager() {

        viewPager = bindView(R.id.viewPager);
        tabLayout = bindView(R.id.tabLayout);

        //初始化数据
        String[] titles = getResources().getStringArray(R.array.main);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new MeFragment());
        fragments.add(new MusicHouseFragment());
        fragments.add(new DiscoverFragment());

        //建立联动
        adapter = new MainViewPagerAdapter(getSupportFragmentManager(), fragments, titles);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager, true);

        viewPager.setCurrentItem(1,true);
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

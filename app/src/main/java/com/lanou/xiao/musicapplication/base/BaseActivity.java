package com.lanou.xiao.musicapplication.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 记录所有活动的Activity
     */
    private static final List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mActivities.add(this);
        initView();
        initData();
        EventBus.getDefault().register(this);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onMessage(String s) {

    }

    /**
     * 设置布局文件
     * 此抽象方法要求所有的子类实现
     *
     * @return 返回一个布局文件
     */
    public abstract int getLayoutId();


    /**
     * 初始化数据
     ***/
    public abstract void initView();

    /**
     * 初始化数据
     ***/
    public abstract void initData();


    protected void startActivity(Class<?> clz, Bundle bundle, String key) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtra(key, bundle);
        }
        startActivity(intent);
    }

    protected void startActivity(Class<?> clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }


    protected void startActivityForResult(Class<?> clz, int requestCode) {
        Intent intent = new Intent(this, clz);
        startActivityForResult(intent, requestCode);
    }

    protected void startActivityForResult(Class<?> clz, int requestCode, Bundle bundle, String key) {

        Intent intent = new Intent(this, clz);
        if (bundle == null) {
            intent.putExtra(key, bundle);
        }
    }

    /**
     * 关闭所有Activity
     */
    protected static void finishAll() {
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new ArrayList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivities.remove(this);
        EventBus.getDefault().unregister(this);
    }

    /**
     * 完成findViewbyId的操作 自动进行强制类型转换
     * 后续就不用再挨个转了 只需要调用就行
     *
     * @param id 组件对应的id
     * @return 对应的组件对象
     **/
    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

    /**
     * 完成findViewbyId的操作 自动进行强制类型转换
     * 后续就不用再挨个转了 只需要调用就行
     *
     * @param id 组件对应的id
     * @param v  要查找的视图
     * @return 对应的组件对象
     **/
    protected <T extends View> T bindView(int id, View v) {
        return (T) v.findViewById(id);
    }
}

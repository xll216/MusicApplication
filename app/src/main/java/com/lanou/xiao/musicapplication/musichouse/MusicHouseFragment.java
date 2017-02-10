package com.lanou.xiao.musicapplication.musichouse;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.lanou.xiao.musicapplication.R;
import com.lanou.xiao.musicapplication.base.BaseFragment;
import com.lanou.xiao.musicapplication.bean.GeDanBean;
import com.lanou.xiao.musicapplication.http.okhttp.HttpMananger;
import com.lanou.xiao.musicapplication.http.okhttp.OnCompletedListener;
import com.lanou.xiao.musicapplication.http.okhttp.UrlConstant;

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

public class MusicHouseFragment extends BaseFragment implements OnCompletedListener<GeDanBean> {
    private RecyclerView recyclerView;
    private HotRecommendAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_music_house;
    }

    @Override
    public void initView(View view) {
        recyclerView = bindView(R.id.recyclerView);
        adapter = new HotRecommendAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void initData() {
        /*获取热门歌单*/
        HttpMananger.getInstance().getRequest(UrlConstant.HOT_GEDAN,
                GeDanBean.class, this);

    }


    /**
     * 网络请求成功回调
     *
     * @param result 成功返回的实体类
     **/
    @Override
    public void onCompleted(GeDanBean result) {
        adapter.setSongList(result.getHotSongBean().getSongs());
        Log.d("MusicHouseFragment", "result.getTotal():" + result.getError_code());
    }

    @Override
    public void onFailed() {

    }

    @Override
    public void onCompleted(List<GeDanBean> list) {

    }
}

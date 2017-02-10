package com.lanou.xiao.musicapplication.http.retrofit;

import com.lanou.xiao.musicapplication.bean.BillCategoryBean;
import com.lanou.xiao.musicapplication.bean.GeDanBean;
import com.lanou.xiao.musicapplication.bean.GeDanInfoBean;
import com.lanou.xiao.musicapplication.bean.GetHotGeDanAndOfficialBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

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

public interface ApiService {

    /**
     * 首页热门推荐
     **/
    @GET(Constant.BASE_API_URL)
    Observable<GetHotGeDanAndOfficialBean> getHotGeDanAndOfficial(@Query("method") String method);

    /**
     * 首页热门歌单
     **/
    @GET(Constant.BASE_API_URL)
    Observable<BillCategoryBean> billCategory(@Query("method") String method);

    /**
     * 排行榜
     **/
    @GET(Constant.BASE_API_URL)
    Observable<GeDanBean> getGeDanList(@Query("method") String method);

    /**
     * 歌单列表—热门歌单与推荐点击
     **/
    @GET(Constant.BASE_API_URL)
    Observable<GeDanInfoBean> getGeDanInfo(@Query("method") String method, @Query("listid") int id);

}

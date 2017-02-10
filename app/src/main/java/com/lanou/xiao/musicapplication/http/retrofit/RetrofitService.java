package com.lanou.xiao.musicapplication.http.retrofit;

import com.lanou.xiao.musicapplication.bean.BillCategoryBean;
import com.lanou.xiao.musicapplication.bean.GeDanBean;
import com.lanou.xiao.musicapplication.bean.GeDanInfoBean;
import com.lanou.xiao.musicapplication.bean.GetHotGeDanAndOfficialBean;

import okhttp3.ResponseBody;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

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

public class RetrofitService {
    private Retrofit retrofit, imgRetrofit;
    private ApiService apiService;
    private ImageService imageService;

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();

    public static RetrofitService getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final RetrofitService INSTANCE = new RetrofitService();
    }

    private RetrofitService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();

        imgRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.IMG_BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build();
        apiService = retrofit.create(ApiService.class);
        imageService = imgRetrofit.create(ImageService.class);
    }

    public void downloadImage(Subscriber<ResponseBody> subscriber,String url) {
        imageService.downloadImage(url)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .subscribe(subscriber);
    }

    /**
     * 首页热门推荐
     **/
    public void getHotGeDanAndOfficial(Subscriber<GetHotGeDanAndOfficialBean> subscriber) {
        Observable<GetHotGeDanAndOfficialBean> observable =
                apiService.getHotGeDanAndOfficial(Constant.GETHOTGEDANANDOFFICIAL);
        executor(observable, subscriber);
    }

    /**
     * 首页热门歌单
     **/
    public void billCategory(Subscriber<BillCategoryBean> subscriber) {
        Observable<BillCategoryBean> observable =
                apiService.billCategory(Constant.BILLCATEGORY);
        executor(observable, subscriber);
    }

    /**
     * 排行榜
     **/
    public void getGeDanList(Subscriber<GeDanBean> subscriber) {
        Observable<GeDanBean> observable = apiService.getGeDanList(Constant.GEDAN);
        executor(observable, subscriber);
    }

    /**
     * 歌单列表—热门歌单与推荐点击
     *
     * @param id 歌曲id
     **/
    public void getGeDanInfo(int id, Subscriber<GeDanInfoBean> subscriber) {
        Observable<GeDanInfoBean> observable = apiService.getGeDanInfo(Constant.GEDANINFO, id);
        executor(observable, subscriber);
    }

    /**
     * 执行网络请求，并将结果回调给Subscriber
     *
     * @param observable 被观察事件
     * @param subscriber 订阅者 结果回调对象
     **/
    private <T> void executor(Observable<T> observable, Subscriber<T> subscriber) {
        observable
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*数据回调*/
                .subscribe(subscriber);
    }
}

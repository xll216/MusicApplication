package com.lanou.xiao.musicapplication.http.retrofit;

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

public interface Constant {
    //项目基础地址
    String BASE_URL = "http://tingapi.ting.baidu.com/";
    //项目基础地址
    String BASE_API_URL = "v1/restserver/ting";

    String METHOD = "?method=";
    //首页热门推荐url
    String GETHOTGEDANANDOFFICIAL = "baidu.ting.diy.getHotGeDanAndOfficial";

    String URL_GETHOTGEDANANDOFFICIAL = BASE_URL + BASE_API_URL + METHOD + "baidu.ting.diy.getHotGeDanAndOfficial";
    //首页热门歌单url
    String GEDAN = "baidu.ting.diy.gedan";
    String URL_GEDAN = BASE_URL + BASE_API_URL + METHOD + "baidu.ting.diy.gedan";
    //排行榜url
    String BILLCATEGORY = "baidu.ting.billboard.billCategory";
    //歌单列表—热门歌单与推荐点击后传入参数listid
    String GEDANINFO = "baidu.ting.diy.gedanInfo";

    String IMG_BASE_URL = "http://musicugc.cdn.qianqian.com/ugcdiy/pic/";
    String IMG_URL = "a88d6df76ab481e909604034f3548d65.jpg";
}

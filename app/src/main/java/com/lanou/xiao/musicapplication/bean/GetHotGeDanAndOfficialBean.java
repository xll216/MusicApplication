package com.lanou.xiao.musicapplication.bean;

import com.google.gson.annotations.SerializedName;

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

public class GetHotGeDanAndOfficialBean {

    /**
     * error_code : 22000
     * content : {"title":"热门歌单","list":[{"listid":"7259","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_5f2ecb9b02e287b82e12b84a6c93bbdf.jpg","listenum":"25837","collectnum":"337","title":"东海音乐节，去海边沙滩听音乐","tag":"流行,摇滚,民谣","type":"gedan"},{"listid":"7245","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_390f743631c17a884f0508ff96463970.jpg","listenum":"19683","collectnum":"417","title":"开学季又到了，你准备好了么","tag":"华语,快乐,励志","type":"gedan"},{"listid":"7181","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ff138e5ea3d22d31537a7f6a08e52da8.jpg","listenum":"30010","collectnum":"439","title":"最是多情，好听在粤语","tag":"粤语,工作,现场","type":"gedan"},{"listid":"7246","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ed251b034c3908338d6ad268d7bba651.jpg","listenum":"21657","collectnum":"485","title":"天凉好个秋","tag":"华语,古风,流行","type":"gedan"},{"listid":"7096","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_fd232f8734ca83af4ec439f15d974e0c.jpg","listenum":"16698","collectnum":"458","title":"自然的旋律，麦田的香气","tag":"乡村,清晨,咖啡厅","type":"gedan"},{"listid":"7248","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_8046b2ef24fdf41885f342f68e862c3a.jpg","listenum":"4236","collectnum":"421","title":"精神解药，心灵毒药","tag":"后摇,孤独,器乐","type":"gedan"}]}
     */

    private int error_code;
    @SerializedName("content")
    private HotSongBean hotSong;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public HotSongBean getHotSong() {
        return hotSong;
    }

    public void setHotSong(HotSongBean hotSong) {
        this.hotSong = hotSong;
    }

    public static class HotSongBean {
        /**
         * title : 热门歌单
         * list : [{"listid":"7259","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_5f2ecb9b02e287b82e12b84a6c93bbdf.jpg","listenum":"25837","collectnum":"337","title":"东海音乐节，去海边沙滩听音乐","tag":"流行,摇滚,民谣","type":"gedan"},{"listid":"7245","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_390f743631c17a884f0508ff96463970.jpg","listenum":"19683","collectnum":"417","title":"开学季又到了，你准备好了么","tag":"华语,快乐,励志","type":"gedan"},{"listid":"7181","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ff138e5ea3d22d31537a7f6a08e52da8.jpg","listenum":"30010","collectnum":"439","title":"最是多情，好听在粤语","tag":"粤语,工作,现场","type":"gedan"},{"listid":"7246","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_ed251b034c3908338d6ad268d7bba651.jpg","listenum":"21657","collectnum":"485","title":"天凉好个秋","tag":"华语,古风,流行","type":"gedan"},{"listid":"7096","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_fd232f8734ca83af4ec439f15d974e0c.jpg","listenum":"16698","collectnum":"458","title":"自然的旋律，麦田的香气","tag":"乡村,清晨,咖啡厅","type":"gedan"},{"listid":"7248","pic":"http://business.cdn.qianqian.com/qianqian/pic/bos_client_8046b2ef24fdf41885f342f68e862c3a.jpg","listenum":"4236","collectnum":"421","title":"精神解药，心灵毒药","tag":"后摇,孤独,器乐","type":"gedan"}]
         */

        private String title;
        @SerializedName("list")
        private List<SongBean> songList;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<SongBean> getSongList() {
            return songList;
        }

        public void setSongList(List<SongBean> songList) {
            this.songList = songList;
        }

        public static class SongBean {
            /**
             * listid : 7259
             * pic : http://business.cdn.qianqian.com/qianqian/pic/bos_client_5f2ecb9b02e287b82e12b84a6c93bbdf.jpg
             * listenum : 25837
             * collectnum : 337
             * title : 东海音乐节，去海边沙滩听音乐
             * tag : 流行,摇滚,民谣
             * type : gedan
             */

            private String listid;
            private String pic;
            private String listenum;
            private String collectnum;
            private String title;
            private String tag;
            private String type;

            public String getListid() {
                return listid;
            }

            public void setListid(String listid) {
                this.listid = listid;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getListenum() {
                return listenum;
            }

            public void setListenum(String listenum) {
                this.listenum = listenum;
            }

            public String getCollectnum() {
                return collectnum;
            }

            public void setCollectnum(String collectnum) {
                this.collectnum = collectnum;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}

package com.example.administrator.xiangmuone.bean.xmzb;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21.
 */
public class NewsBean {

    /**
     * videoset : {"0":{"vsid":"VSET100219009515","relvsid":"","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""},"count":"555"}
     * video : [{"vsid":"VSET100219009515","order":"556","vid":"c1965773e71d4c899609db09655747fc","t":"《原创新闻》 20171219 新闻快讯：大熊猫\u201c琴心\u201d\u201c小核桃\u201d进入野化培训第二阶段","url":"http://tv.cntv.cn/video/VSET100219009515/c1965773e71d4c899609db09655747fc","ptime":"2017-12-19 12:55:50","img":"http://p1.img.cctvpic.com/fmspic/2017/12/19/c1965773e71d4c899609db09655747fc-74.jpg?p=2&h=120","len":"00:02:07","em":"CM01"},{"vsid":"VSET100219009515","order":"555","vid":"1288473b410f4967b465295314e8bee3","t":"《原创新闻》 20171123 熊猫快讯：大熊猫\u201c八喜\u201d\u201c映雪\u201d成功回归自然","url":"http://tv.cntv.cn/video/VSET100219009515/1288473b410f4967b465295314e8bee3","ptime":"2017-11-23 19:58:31","img":"http://p4.img.cctvpic.com/fmspic/2017/11/23/1288473b410f4967b465295314e8bee3-50.jpg?p=2&h=120","len":"00:01:45","em":"CM01"},{"vsid":"VSET100219009515","order":"554","vid":"786895ae8fdd4cb186703b94ff86a57b","t":"《原创新闻》 20171122 熊猫快讯：大熊猫\u201c八喜\u201d\u201c映雪\u201d体检合格 11月23日正式放归","url":"http://tv.cntv.cn/video/VSET100219009515/786895ae8fdd4cb186703b94ff86a57b","ptime":"2017-11-22 14:27:46","img":"http://p2.img.cctvpic.com/fmspic/2017/11/22/786895ae8fdd4cb186703b94ff86a57b-80.jpg?p=2&h=120","len":"00:02:20","em":"CM01"},{"vsid":"VSET100219009515","order":"553","vid":"1458d901823e4aa0baaff044dd397582","t":"《原创新闻》 20171121 熊猫快讯：大熊猫\u201c八喜\u201d\u201c映雪\u201d成功回捕","url":"http://tv.cntv.cn/video/VSET100219009515/1458d901823e4aa0baaff044dd397582","ptime":"2017-11-21 12:14:40","img":"http://p3.img.cctvpic.com/fmspic/2017/11/21/1458d901823e4aa0baaff044dd397582-50.jpg?p=2&h=120","len":"00:01:46","em":"CM01"},{"vsid":"VSET100219009515","order":"552","vid":"a27c2a867c3c413c9bc6f7ad63ffd0d8","t":"《原创新闻》 20171119 熊猫快讯：\u201c八喜\u201d\u201c映雪\u201d即将放归 熊猫专家权威解读","url":"http://tv.cntv.cn/video/VSET100219009515/a27c2a867c3c413c9bc6f7ad63ffd0d8","ptime":"2017-11-19 12:07:21","img":"http://p5.img.cctvpic.com/fmspic/2017/11/19/a27c2a867c3c413c9bc6f7ad63ffd0d8-129.jpg?p=2&h=120","len":"00:03:47","em":"CM01"},{"vsid":"VSET100219009515","order":"551","vid":"72dae6f7630e4dd6a0679a2b3b5d421b","t":"《原创新闻》 20171117 熊猫快讯：旅马大熊猫\u201c暖暖\u201d顺利回国","url":"http://tv.cntv.cn/video/VSET100219009515/72dae6f7630e4dd6a0679a2b3b5d421b","ptime":"2017-11-17 19:08:46","img":"http://p4.img.cctvpic.com/fmspic/2017/11/17/72dae6f7630e4dd6a0679a2b3b5d421b-50.jpg?p=2&h=120","len":"00:01:16","em":"CM01"},{"vsid":"VSET100219009515","order":"550","vid":"5dc47b0edf264a30831b1a7e5e9d8e92","t":"《原创新闻》 20170928 熊猫快讯：大熊猫\u201c彩陶\u201d\u201c湖春\u201d启程赴印度尼西亚","url":"http://tv.cntv.cn/video/VSET100219009515/5dc47b0edf264a30831b1a7e5e9d8e92","ptime":"2017-09-28 19:06:11","img":"http://p4.img.cctvpic.com/fmspic/2017/09/28/5dc47b0edf264a30831b1a7e5e9d8e92-50.jpg?p=2&h=120","len":"00:01:24","em":"CM01"}]
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"vsid":"VSET100219009515","relvsid":"","name":"熊猫频道-原创新闻（高清）","img":"http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg","enname":"其他","url":"http://tv.cntv.cn/videoset/VSET100219009515","cd":"","zy":"","bj":"","dy":"","js":"","nf":"","yz":"","fl":"","sbsj":"","sbpd":"其他","desc":"熊猫频道原创新闻高清内容。","playdesc":"","zcr":"","fcl":""}
         * count : 555
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * vsid : VSET100219009515
             * relvsid :
             * name : 熊猫频道-原创新闻（高清）
             * img : http://p1.img.cctvpic.com/photoAlbum/vms/standard/img/2016/7/4/VSETAjD49Q4i15Vr2gXZdlwh160704.jpg
             * enname : 其他
             * url : http://tv.cntv.cn/videoset/VSET100219009515
             * cd :
             * zy :
             * bj :
             * dy :
             * js :
             * nf :
             * yz :
             * fl :
             * sbsj :
             * sbpd : 其他
             * desc : 熊猫频道原创新闻高清内容。
             * playdesc :
             * zcr :
             * fcl :
             */

            private String vsid;
            private String relvsid;
            private String name;
            private String img;
            private String enname;
            private String url;
            private String cd;
            private String zy;
            private String bj;
            private String dy;
            private String js;
            private String nf;
            private String yz;
            private String fl;
            private String sbsj;
            private String sbpd;
            private String desc;
            private String playdesc;
            private String zcr;
            private String fcl;

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }
        }
    }

    public static class VideoBean {
        /**
         * vsid : VSET100219009515
         * order : 556
         * vid : c1965773e71d4c899609db09655747fc
         * t : 《原创新闻》 20171219 新闻快讯：大熊猫“琴心”“小核桃”进入野化培训第二阶段
         * url : http://tv.cntv.cn/video/VSET100219009515/c1965773e71d4c899609db09655747fc
         * ptime : 2017-12-19 12:55:50
         * img : http://p1.img.cctvpic.com/fmspic/2017/12/19/c1965773e71d4c899609db09655747fc-74.jpg?p=2&h=120
         * len : 00:02:07
         * em : CM01
         */

        private String vsid;
        private String order;
        private String vid;
        private String t;
        private String url;
        private String ptime;
        private String img;
        private String len;
        private String em;

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }
    }
}

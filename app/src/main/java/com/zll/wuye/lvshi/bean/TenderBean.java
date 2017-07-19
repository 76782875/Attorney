package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 14:09
 */
public class TenderBean {

    /**
     * timestamp : 1497593362303
     * message : 请求成功
     * body : [{"status":1,"markCnt":0,"offerStrt":111,"typeName":"合同纠纷","id":13,"address":"北京 东城区 ","offerEnd":22222,"userId":77,"isMark":0,"creatTm":1496899399000,"cntn":"没流量了","user":{"name":"刘  芳  ","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg"}},{"status":2,"markCnt":2,"offerStrt":3,"typeName":"合同纠纷","id":11,"address":"北京 东城区 ","offerEnd":5,"userId":42,"creatTm":1496898656000,"isMark":0,"cntn":"就是就是就是计算机","user":{"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}},{"status":1,"markCnt":1,"offerStrt":10,"typeName":"合同纠纷","id":7,"address":"北京 东城区 ","offerEnd":15,"userId":77,"creatTm":1496898340000,"isMark":0,"cntn":"不是就是就是","user":{"name":"刘  芳  ","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg"}},{"status":1,"markCnt":1,"offerStrt":11,"typeName":"","id":6,"address":"天津 和平区 ","offerEnd":222,"userId":42,"creatTm":1496896994000,"isMark":0,"cntn":"JJ啦","user":{"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}},{"status":1,"markCnt":2,"offerStrt":10,"typeName":"合同纠纷","id":3,"address":"北京 东城区 ","offerEnd":33469,"userId":42,"creatTm":1496815070000,"isMark":0,"cntn":"睡觉睡觉数据挖掘几万块哇咔咔哇卡哇卡你手机神经外科计算机","user":{"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}},{"status":2,"markCnt":2,"offerStrt":128,"typeName":"物权纠纷","id":2,"address":"北京 东城区 ","offerEnd":1824,"userId":42,"creatTm":1496732535000,"isMark":0,"cntn":"耍手机","user":{"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}},{"status":1,"markCnt":0,"offerStrt":12,"typeName":"侵权纠纷","id":1,"address":"北京 东城区 ","offerEnd":15,"userId":1,"creatTm":1496731413000,"isMark":0,"cntn":"哥反反复复电饭锅","user":{"name":"张三","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170606/1516/2017060644015.png"}}]
     * status : 200
     */

    private long timestamp;
    private String message;
    private int status;
    private List<BodyBean> body;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * status : 1
         * markCnt : 0
         * offerStrt : 111
         * typeName : 合同纠纷
         * id : 13
         * address : 北京 东城区
         * offerEnd : 22222
         * userId : 77
         * isMark : 0
         * creatTm : 1496899399000
         * cntn : 没流量了
         * user : {"name":"刘  芳  ","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg"}
         */

        private int status;
        private int markCnt;
        private int offerStrt;
        private String typeName;
        private int id;
        private String address;
        private int offerEnd;
        private int userId;
        private int isMark;
        private long creatTm;
        private String cntn;
        private UserBean user;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getMarkCnt() {
            return markCnt;
        }

        public void setMarkCnt(int markCnt) {
            this.markCnt = markCnt;
        }

        public int getOfferStrt() {
            return offerStrt;
        }

        public void setOfferStrt(int offerStrt) {
            this.offerStrt = offerStrt;
        }

        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getOfferEnd() {
            return offerEnd;
        }

        public void setOfferEnd(int offerEnd) {
            this.offerEnd = offerEnd;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getIsMark() {
            return isMark;
        }

        public void setIsMark(int isMark) {
            this.isMark = isMark;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getCntn() {
            return cntn;
        }

        public void setCntn(String cntn) {
            this.cntn = cntn;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * name : 刘  芳
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg
             */

            private String name;
            private String headUrl;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }
        }
    }
}

package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 11:44
 */
public class MyTenderBean {


    /**
     * timestamp : 1497843813048
     * message : 请求成功
     * body : [{"status":0,"markCnt":2,"offerStrt":111,"typeName":"合同纠纷","id":13,"address":"北京 东城区 ","offerEnd":22222,"userId":77,"creatTm":1496899399000,"cntn":"没流量了","user":{"name":"ooo","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170616/1742/2017061628026.jpg"}},{"status":0,"markCnt":2,"offerStrt":10,"id":7,"typeName":"合同纠纷","address":"北京 东城区 ","offerEnd":15,"userId":77,"creatTm":1496898340000,"cntn":"不是就是就是","user":{"name":"ooo","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170616/1742/2017061628026.jpg"}}]
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
         * status : 0
         * markCnt : 2
         * offerStrt : 111
         * typeName : 合同纠纷
         * id : 13
         * address : 北京 东城区
         * offerEnd : 22222
         * userId : 77
         * creatTm : 1496899399000
         * cntn : 没流量了
         * user : {"name":"ooo","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170616/1742/2017061628026.jpg"}
         */

        private int status;
        private int markCnt;
        private int offerStrt;
        private String typeName;
        private int id;
        private String address;
        private int offerEnd;
        private int userId;
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
             * name : ooo
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170616/1742/2017061628026.jpg
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

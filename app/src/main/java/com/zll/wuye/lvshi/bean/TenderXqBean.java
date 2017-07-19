package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 16:09
 */
public class TenderXqBean {
    /**
     * timestamp : 1497600468249
     * message : 请求成功
     * body : {"status":2,"earnest":0.01,"markCnt":2,"offerStrt":3,"typeName":"合同纠纷","id":11,"title":"手机都觉得嫁鸡随鸡","fileUrls":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060811678.jpg,http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060888650.jpg,http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060858542.jpg","address":"北京 东城区 ","offerEnd":5,"userId":42,"markUserId":77,"creatTm":1496898656000,"cntn":"就是就是就是计算机","user":{"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}}
     * status : 200
     */

    private long timestamp;
    private String message;
    private BodyBean body;
    private int status;

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

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class BodyBean {
        /**
         * status : 2
         * earnest : 0.01
         * markCnt : 2
         * offerStrt : 3
         * typeName : 合同纠纷
         * id : 11
         * title : 手机都觉得嫁鸡随鸡
         * fileUrls : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060811678.jpg,http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060888650.jpg,http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170608/1310/2017060858542.jpg
         * address : 北京 东城区
         * offerEnd : 5
         * userId : 42
         * markUserId : 77
         * creatTm : 1496898656000
         * cntn : 就是就是就是计算机
         * user : {"name":"123456","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg"}
         */

        private int status;
        private double earnest;
        private int markCnt;
        private int offerStrt;
        private String typeName;
        private int id;
        private String title;
        private String fileUrls;
        private String address;
        private int offerEnd;
        private int userId;
        private int markUserId;
        private long creatTm;
        private String cntn;
        private UserBean user;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getEarnest() {
            return earnest;
        }

        public void setEarnest(double earnest) {
            this.earnest = earnest;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFileUrls() {
            return fileUrls;
        }

        public void setFileUrls(String fileUrls) {
            this.fileUrls = fileUrls;
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

        public int getMarkUserId() {
            return markUserId;
        }

        public void setMarkUserId(int markUserId) {
            this.markUserId = markUserId;
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
             * name : 123456
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170613/1738/2017061383638.jpg
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

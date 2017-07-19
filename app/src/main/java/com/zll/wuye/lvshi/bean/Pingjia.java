package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/26 16:29
 */
public class Pingjia {


    /**
     * timestamp : 1498465216172
     * message : 请求成功
     * body : [{"id":13,"name":"22223222","userId":30,"score":2,"headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1504/2017062614120.png","cntn":"什么玩意"}]
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
         * id : 13
         * name : 22223222
         * userId : 30
         * score : 2
         * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170626/1504/2017062614120.png
         * cntn : 什么玩意
         */

        private int id;
        private String name;
        private int userId;
        private int score;
        private String headUrl;
        private String cntn;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getHeadUrl() {
            return headUrl;
        }

        public void setHeadUrl(String headUrl) {
            this.headUrl = headUrl;
        }

        public String getCntn() {
            return cntn;
        }

        public void setCntn(String cntn) {
            this.cntn = cntn;
        }
    }
}

package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/20 11:02
 */
public class MyAnswerBean {


    /*
    * *
     * body : [{"ansCnt":1,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170620/1022/2017062047103.png","id":5,"isAdopt":0,"quest":"213123213","questTm":"2017-06-19","seeCnt":4,"typeId":10001,"userId":12,"userName":"18310615141"}]
     * message : 请求成功
     * status : 200
     * timestamp : 1497927646190
     */

    private String message;
    private int status;
    private long timestamp;
    private List<BodyBean> body;

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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<BodyBean> getBody() {
        return body;
    }

    public void setBody(List<BodyBean> body) {
        this.body = body;
    }

    public static class BodyBean {
        /**
         * ansCnt : 1
         * headImg : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170620/1022/2017062047103.png
         * id : 5
         * isAdopt : 0
         * quest : 213123213
         * questTm : 2017-06-19
         * seeCnt : 4
         * typeId : 10001
         * userId : 12
         * userName : 18310615141
         */

        private int ansCnt;
        private String headImg;
        private int id;
        private int isAdopt;
        private String quest;
        private String questTm;
        private int seeCnt;
        private int typeId;
        private int userId;
        private String userName;

        public int getAnsCnt() {
            return ansCnt;
        }

        public void setAnsCnt(int ansCnt) {
            this.ansCnt = ansCnt;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public String getQuestTm() {
            return questTm;
        }

        public void setQuestTm(String questTm) {
            this.questTm = questTm;
        }

        public int getSeeCnt() {
            return seeCnt;
        }

        public void setSeeCnt(int seeCnt) {
            this.seeCnt = seeCnt;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}

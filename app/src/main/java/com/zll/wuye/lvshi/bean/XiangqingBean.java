package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 10:40
 */
public class XiangqingBean {

    /**
     * timestamp : 1497580723985
     * message : 请求成功
     * body : {"isAdopt":1,"ansCnt":3,"questTm":"2017-06-07","selfId":70,"questFiles":null,"quest":"sandlasndlknaksldn","id":14,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170615/2123/2017061583446.png","seeCnt":44,"userId":70,"userName":"18310615141","ansTm":null,"typeId":10005}
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
         * isAdopt : 1
         * ansCnt : 3
         * questTm : 2017-06-07
         * selfId : 70
         * questFiles : null
         * quest : sandlasndlknaksldn
         * id : 14
         * headImg : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170615/2123/2017061583446.png
         * seeCnt : 44
         * userId : 70
         * userName : 18310615141
         * ansTm : null
         * typeId : 10005
         */

        private int isAdopt;
        private int ansCnt;
        private String questTm;
        private int selfId;
        private Object questFiles;
        private String quest;
        private int id;
        private String headImg;
        private int seeCnt;
        private int userId;
        private String userName;
        private Object ansTm;
        private int typeId;

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
        }

        public int getAnsCnt() {
            return ansCnt;
        }

        public void setAnsCnt(int ansCnt) {
            this.ansCnt = ansCnt;
        }

        public String getQuestTm() {
            return questTm;
        }

        public void setQuestTm(String questTm) {
            this.questTm = questTm;
        }

        public int getSelfId() {
            return selfId;
        }

        public void setSelfId(int selfId) {
            this.selfId = selfId;
        }

        public Object getQuestFiles() {
            return questFiles;
        }

        public void setQuestFiles(Object questFiles) {
            this.questFiles = questFiles;
        }

        public String getQuest() {
            return quest;
        }

        public void setQuest(String quest) {
            this.quest = quest;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHeadImg() {
            return headImg;
        }

        public void setHeadImg(String headImg) {
            this.headImg = headImg;
        }

        public int getSeeCnt() {
            return seeCnt;
        }

        public void setSeeCnt(int seeCnt) {
            this.seeCnt = seeCnt;
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

        public Object getAnsTm() {
            return ansTm;
        }

        public void setAnsTm(Object ansTm) {
            this.ansTm = ansTm;
        }

        public int getTypeId() {
            return typeId;
        }

        public void setTypeId(int typeId) {
            this.typeId = typeId;
        }
    }
}

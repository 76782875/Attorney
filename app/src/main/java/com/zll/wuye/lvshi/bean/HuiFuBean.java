package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/16 10:51
 */
public class HuiFuBean {


    /**
     * timestamp : 1497581474885
     * message : 请求成功
     * body : [{"id":9,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg","isAdopt":1,"userId":77,"userName":"15101234567","ansTm":"2017-06-07","askId":14,"ans":"Dfdfjdfjdfjdkfjdjfdfdfmdmfdfd","ansFiles":null},{"id":8,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg","isAdopt":1,"userId":77,"userName":"15101234567","ansTm":"2017-06-07","askId":14,"ans":"Ljlgjdflkgjlfkjgfgf","ansFiles":null},{"id":1,"headImg":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170615/2123/2017061583446.png","isAdopt":1,"userId":70,"userName":"18310615141","ansTm":"2017-06-07","askId":14,"ans":"我伟大的负担份地方的方法","ansFiles":null}]
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
         * id : 9
         * headImg : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170614/1457/2017061486835.jpg
         * isAdopt : 1
         * userId : 77
         * userName : 15101234567
         * ansTm : 2017-06-07
         * askId : 14
         * ans : Dfdfjdfjdfjdkfjdjfdfdfmdmfdfd
         * ansFiles : null
         */

        private int id;
        private String headImg;
        private int isAdopt;
        private int userId;
        private String userName;
        private String ansTm;
        private int askId;
        private String ans;
        private Object ansFiles;

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

        public int getIsAdopt() {
            return isAdopt;
        }

        public void setIsAdopt(int isAdopt) {
            this.isAdopt = isAdopt;
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

        public String getAnsTm() {
            return ansTm;
        }

        public void setAnsTm(String ansTm) {
            this.ansTm = ansTm;
        }

        public int getAskId() {
            return askId;
        }

        public void setAskId(int askId) {
            this.askId = askId;
        }

        public String getAns() {
            return ans;
        }

        public void setAns(String ans) {
            this.ans = ans;
        }

        public Object getAnsFiles() {
            return ansFiles;
        }

        public void setAnsFiles(Object ansFiles) {
            this.ansFiles = ansFiles;
        }
    }
}

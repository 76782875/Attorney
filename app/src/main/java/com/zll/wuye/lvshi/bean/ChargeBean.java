package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/15 13:17
 */
public class ChargeBean {


    /**
     * timestamp : 1497503808668
     * message : 请求成功
     * body : {"isMeet":1,"askPrice":"50.00","meetPrice":"250.00","isAsk":1}
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
         * isMeet : 1
         * askPrice : 50.00
         * meetPrice : 250.00
         * isAsk : 1
         */

        private int isMeet;
        private String askPrice;
        private String meetPrice;
        private int isAsk;

        public int getIsMeet() {
            return isMeet;
        }

        public void setIsMeet(int isMeet) {
            this.isMeet = isMeet;
        }

        public String getAskPrice() {
            return askPrice;
        }

        public void setAskPrice(String askPrice) {
            this.askPrice = askPrice;
        }

        public String getMeetPrice() {
            return meetPrice;
        }

        public void setMeetPrice(String meetPrice) {
            this.meetPrice = meetPrice;
        }

        public int getIsAsk() {
            return isAsk;
        }

        public void setIsAsk(int isAsk) {
            this.isAsk = isAsk;
        }
    }
}

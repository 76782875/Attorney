package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/14 12:56
 */
public class PersonMessageBean {

    /**
     * timestamp : 1497416088310
     * message : 请求成功
     * body : {"amount":"0.00","status":1,"income":"0.00","withdraw":"0.00","name":"桂红锦","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png","period":20500,"lawName":"云南凌云律师事务所"}
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
         * amount : 0.00
         * status : 1
         * income : 0.00
         * withdraw : 0.00
         * name : 桂红锦
         * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png
         * period : 20500
         * lawName : 云南凌云律师事务所
         */

        private String amount;
        private int status;
        private String income;
        private String withdraw;
        private String name;
        private String headUrl;
        private int period;
        private String lawName;

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getIncome() {
            return income;
        }

        public void setIncome(String income) {
            this.income = income;
        }

        public String getWithdraw() {
            return withdraw;
        }

        public void setWithdraw(String withdraw) {
            this.withdraw = withdraw;
        }

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

        public int getPeriod() {
            return period;
        }

        public void setPeriod(int period) {
            this.period = period;
        }

        public String getLawName() {
            return lawName;
        }

        public void setLawName(String lawName) {
            this.lawName = lawName;
        }
    }
}

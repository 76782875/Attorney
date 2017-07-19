package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/15 15:21
 */
public class DetailBean {

    /**
     * timestamp : 1497511248874
     * message : 请求成功
     * body : [{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612171724","creatTm":1497259051000,"type":"mentLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612171246","creatTm":1497258783000,"type":"mentLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612154300","creatTm":1497253390000,"type":"mentLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612153512","creatTm":1497252925000,"type":"askLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612151542","creatTm":1497251759000,"type":"askLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612101821","creatTm":1497233910000,"type":"askLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170612101716","creatTm":1497233844000,"type":"askLawyer"},{"amount":0.01,"profit":0.01,"title":"预约律师","status":0,"ratio":0.3,"tradeNo":"WY20170608155045","creatTm":1496908261000,"type":"mentLawyer"},{"amount":0.01,"profit":0.01,"title":"电话咨询律师","status":0,"ratio":0.3,"tradeNo":"WY20170608154945","creatTm":1496908197000,"type":"askLawyer"},{"amount":0.01,"profit":0.01,"title":"电话咨询律师","status":0,"ratio":0.3,"tradeNo":"WY20170608124202","creatTm":1496896936000,"type":"askLawyer"}]
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
         * amount : 0.01
         * profit : 0.01
         * title : 预约律师
         * status : 0
         * ratio : 0.3
         * tradeNo : WY20170612171724
         * creatTm : 1497259051000
         * type : mentLawyer
         */

        private double amount;
        private double profit;
        private String title;
        private int status;
        private double ratio;
        private String tradeNo;
        private long creatTm;
        private String type;

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public double getProfit() {
            return profit;
        }

        public void setProfit(double profit) {
            this.profit = profit;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public double getRatio() {
            return ratio;
        }

        public void setRatio(double ratio) {
            this.ratio = ratio;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}

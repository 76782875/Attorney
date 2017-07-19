package com.zll.wuye.lvshi.bean;

import java.util.List;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/22 15:03
 */
public class PhotoBean {


    /**
     * timestamp : 1498114121781
     * message : 请求成功
     * body : [{"id":113,"orderNo":"WY20170622144628","payStatus":1,"userId":12,"attr":{"name":"小于","tel":"11111111111","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170620/1432/2017062056578.png","cntn":"123456"},"creatTm":1498113988000,"orderStatus":0,"totalPrice":0.1}]
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
         * id : 113
         * orderNo : WY20170622144628
         * payStatus : 1
         * userId : 12
         * attr : {"name":"小于","tel":"11111111111","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170620/1432/2017062056578.png","cntn":"123456"}
         * creatTm : 1498113988000
         * orderStatus : 0
         * totalPrice : 0.1
         */

        private int id;
        private String orderNo;
        private int payStatus;
        private int userId;
        private AttrBean attr;
        private long creatTm;
        private int orderStatus;
        private double totalPrice;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getPayStatus() {
            return payStatus;
        }

        public void setPayStatus(int payStatus) {
            this.payStatus = payStatus;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public AttrBean getAttr() {
            return attr;
        }

        public void setAttr(AttrBean attr) {
            this.attr = attr;
        }

        public long getCreatTm() {
            return creatTm;
        }

        public void setCreatTm(long creatTm) {
            this.creatTm = creatTm;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public double getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(double totalPrice) {
            this.totalPrice = totalPrice;
        }

        public static class AttrBean {
            /**
             * name : 小于
             * tel : 11111111111
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170620/1432/2017062056578.png
             * cntn : 123456
             */

            private String name;
            private String tel;
            private String headUrl;
            private String cntn;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
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
}

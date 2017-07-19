package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/14 13:34
 */
public class PersonMesageBean {


    /**
     * body : {"lawyer":{"address":"天津 河西区 ","cityId":120103,"cntn":"还可以","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170703/1417/2017070325180.png","lawName":"zll","lawyerNo":"12345678945625874","name":"鱼","period":-4772,"prvcId":120000,"sex":1,"typeIds":"10002,10002,10004","typeName":"劳动纠纷,劳动纠纷,侵权纠纷"},"lawyerBus":{"askCnt":0,"askPrice":"0.10","careCnt":0,"caseCnt":0,"commtCnt":0,"grade":0,"id":25,"income":"0.00","isAsk":1,"isMeet":1,"lawyerId":25,"likeCnt":0,"meetCnt":0,"meetDur":"0.0","meetPrice":"0.10","seeCnt":0}}
     * message : 请求成功
     * status : 200
     * timestamp : 1499159619712
     */

    private BodyBean body;
    private String message;
    private int status;
    private long timestamp;

    public BodyBean getBody() {
        return body;
    }

    public void setBody(BodyBean body) {
        this.body = body;
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

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public static class BodyBean {
        /**
         * lawyer : {"address":"天津 河西区 ","cityId":120103,"cntn":"还可以","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170703/1417/2017070325180.png","lawName":"zll","lawyerNo":"12345678945625874","name":"鱼","period":-4772,"prvcId":120000,"sex":1,"typeIds":"10002,10002,10004","typeName":"劳动纠纷,劳动纠纷,侵权纠纷"}
         * lawyerBus : {"askCnt":0,"askPrice":"0.10","careCnt":0,"caseCnt":0,"commtCnt":0,"grade":0,"id":25,"income":"0.00","isAsk":1,"isMeet":1,"lawyerId":25,"likeCnt":0,"meetCnt":0,"meetDur":"0.0","meetPrice":"0.10","seeCnt":0}
         */

        private LawyerBean lawyer;
        private LawyerBusBean lawyerBus;

        public LawyerBean getLawyer() {
            return lawyer;
        }

        public void setLawyer(LawyerBean lawyer) {
            this.lawyer = lawyer;
        }

        public LawyerBusBean getLawyerBus() {
            return lawyerBus;
        }

        public void setLawyerBus(LawyerBusBean lawyerBus) {
            this.lawyerBus = lawyerBus;
        }

        public static class LawyerBean {
            /**
             * address : 天津 河西区
             * cityId : 120103
             * cntn : 还可以
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170703/1417/2017070325180.png
             * lawName : zll
             * lawyerNo : 12345678945625874
             * name : 鱼
             * period : -4772
             * prvcId : 120000
             * sex : 1
             * typeIds : 10002,10002,10004
             * typeName : 劳动纠纷,劳动纠纷,侵权纠纷
             */

            private String address;
            private int cityId;
            private String cntn;
            private String headUrl;
            private String lawName;
            private String lawyerNo;
            private String name;
            private int period;
            private int prvcId;
            private int sex;
            private String typeIds;
            private String typeName;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public String getCntn() {
                return cntn;
            }

            public void setCntn(String cntn) {
                this.cntn = cntn;
            }

            public String getHeadUrl() {
                return headUrl;
            }

            public void setHeadUrl(String headUrl) {
                this.headUrl = headUrl;
            }

            public String getLawName() {
                return lawName;
            }

            public void setLawName(String lawName) {
                this.lawName = lawName;
            }

            public String getLawyerNo() {
                return lawyerNo;
            }

            public void setLawyerNo(String lawyerNo) {
                this.lawyerNo = lawyerNo;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getPeriod() {
                return period;
            }

            public void setPeriod(int period) {
                this.period = period;
            }

            public int getPrvcId() {
                return prvcId;
            }

            public void setPrvcId(int prvcId) {
                this.prvcId = prvcId;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getTypeIds() {
                return typeIds;
            }

            public void setTypeIds(String typeIds) {
                this.typeIds = typeIds;
            }

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }
        }

        public static class LawyerBusBean {
            /**
             * askCnt : 0
             * askPrice : 0.10
             * careCnt : 0
             * caseCnt : 0
             * commtCnt : 0
             * grade : 0
             * id : 25
             * income : 0.00
             * isAsk : 1
             * isMeet : 1
             * lawyerId : 25
             * likeCnt : 0
             * meetCnt : 0
             * meetDur : 0.0
             * meetPrice : 0.10
             * seeCnt : 0
             */

            private int askCnt;
            private String askPrice;
            private int careCnt;
            private int caseCnt;
            private int commtCnt;
            private int grade;
            private int id;
            private String income;
            private int isAsk;
            private int isMeet;
            private int lawyerId;
            private int likeCnt;
            private int meetCnt;
            private String meetDur;
            private String meetPrice;
            private int seeCnt;

            public int getAskCnt() {
                return askCnt;
            }

            public void setAskCnt(int askCnt) {
                this.askCnt = askCnt;
            }

            public String getAskPrice() {
                return askPrice;
            }

            public void setAskPrice(String askPrice) {
                this.askPrice = askPrice;
            }

            public int getCareCnt() {
                return careCnt;
            }

            public void setCareCnt(int careCnt) {
                this.careCnt = careCnt;
            }

            public int getCaseCnt() {
                return caseCnt;
            }

            public void setCaseCnt(int caseCnt) {
                this.caseCnt = caseCnt;
            }

            public int getCommtCnt() {
                return commtCnt;
            }

            public void setCommtCnt(int commtCnt) {
                this.commtCnt = commtCnt;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getIncome() {
                return income;
            }

            public void setIncome(String income) {
                this.income = income;
            }

            public int getIsAsk() {
                return isAsk;
            }

            public void setIsAsk(int isAsk) {
                this.isAsk = isAsk;
            }

            public int getIsMeet() {
                return isMeet;
            }

            public void setIsMeet(int isMeet) {
                this.isMeet = isMeet;
            }

            public int getLawyerId() {
                return lawyerId;
            }

            public void setLawyerId(int lawyerId) {
                this.lawyerId = lawyerId;
            }

            public int getLikeCnt() {
                return likeCnt;
            }

            public void setLikeCnt(int likeCnt) {
                this.likeCnt = likeCnt;
            }

            public int getMeetCnt() {
                return meetCnt;
            }

            public void setMeetCnt(int meetCnt) {
                this.meetCnt = meetCnt;
            }

            public String getMeetDur() {
                return meetDur;
            }

            public void setMeetDur(String meetDur) {
                this.meetDur = meetDur;
            }

            public String getMeetPrice() {
                return meetPrice;
            }

            public void setMeetPrice(String meetPrice) {
                this.meetPrice = meetPrice;
            }

            public int getSeeCnt() {
                return seeCnt;
            }

            public void setSeeCnt(int seeCnt) {
                this.seeCnt = seeCnt;
            }
        }
    }
}

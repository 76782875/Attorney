package com.zll.wuye.lvshi.bean;

/**
 * 1. 类的用途
 * 2. @author $Yuminze
 * 3. @date 2017/6/19 15:42
 */
public class MyTenderXQBean {


    /**
     * timestamp : 1498445859918
     * message : 请求成功
     * body : {"status":2,"tel":"13811848229","earnest":0.1,"markCnt":2,"offerStrt":2000,"typeName":"侵权纠纷","id":38,"fileUrls":"http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170623/1508/2017062315847.jpg","title":"物业公司被业主起诉","caseRec":{"id":8,"price":5000,"status":2,"userId":25,"isMark":0,"cntn":"搜集好证据，做好研究，属于常见侵权纠纷。","lawyer":{"typeName":"劳动纠纷,物权纠纷,侵权纠纷","address":"  ","name":"好的","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170623/1324/2017062316459.png","period":10,"lawName":"中旅联"}},"address":"北京 海淀区 ","offerEnd":9000,"userId":26,"name":"李小姐","markUserId":27,"creatTm":1498201705000,"cntn":"北京海淀某项目，业主小区摔倒诉物业。","user":{"name":"田先生","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png"}}
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
         * tel : 13811848229
         * earnest : 0.1
         * markCnt : 2
         * offerStrt : 2000.0
         * typeName : 侵权纠纷
         * id : 38
         * fileUrls : http://zllserver.oss-cn-beijing.aliyuncs.com/file/20170623/1508/2017062315847.jpg
         * title : 物业公司被业主起诉
         * caseRec : {"id":8,"price":5000,"status":2,"userId":25,"isMark":0,"cntn":"搜集好证据，做好研究，属于常见侵权纠纷。","lawyer":{"typeName":"劳动纠纷,物权纠纷,侵权纠纷","address":"  ","name":"好的","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170623/1324/2017062316459.png","period":10,"lawName":"中旅联"}}
         * address : 北京 海淀区
         * offerEnd : 9000.0
         * userId : 26
         * name : 李小姐
         * markUserId : 27
         * creatTm : 1498201705000
         * cntn : 北京海淀某项目，业主小区摔倒诉物业。
         * user : {"name":"田先生","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png"}
         */

        private int status;
        private String tel;
        private double earnest;
        private int markCnt;
        private double offerStrt;
        private String typeName;
        private int id;
        private String fileUrls;
        private String title;
        private CaseRecBean caseRec;
        private String address;
        private double offerEnd;
        private int userId;
        private String name;
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

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
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

        public double getOfferStrt() {
            return offerStrt;
        }

        public void setOfferStrt(double offerStrt) {
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

        public String getFileUrls() {
            return fileUrls;
        }

        public void setFileUrls(String fileUrls) {
            this.fileUrls = fileUrls;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public CaseRecBean getCaseRec() {
            return caseRec;
        }

        public void setCaseRec(CaseRecBean caseRec) {
            this.caseRec = caseRec;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public double getOfferEnd() {
            return offerEnd;
        }

        public void setOfferEnd(double offerEnd) {
            this.offerEnd = offerEnd;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public static class CaseRecBean {
            /**
             * id : 8
             * price : 5000.0
             * status : 2
             * userId : 25
             * isMark : 0
             * cntn : 搜集好证据，做好研究，属于常见侵权纠纷。
             * lawyer : {"typeName":"劳动纠纷,物权纠纷,侵权纠纷","address":"  ","name":"好的","headUrl":"http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170623/1324/2017062316459.png","period":10,"lawName":"中旅联"}
             */

            private int id;
            private double price;
            private int status;
            private int userId;
            private int isMark;
            private String cntn;
            private LawyerBean lawyer;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getIsMark() {
                return isMark;
            }

            public void setIsMark(int isMark) {
                this.isMark = isMark;
            }

            public String getCntn() {
                return cntn;
            }

            public void setCntn(String cntn) {
                this.cntn = cntn;
            }

            public LawyerBean getLawyer() {
                return lawyer;
            }

            public void setLawyer(LawyerBean lawyer) {
                this.lawyer = lawyer;
            }

            public static class LawyerBean {
                /**
                 * typeName : 劳动纠纷,物权纠纷,侵权纠纷
                 * address :
                 * name : 好的
                 * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/headUrl/20170623/1324/2017062316459.png
                 * period : 10
                 * lawName : 中旅联
                 */

                private String typeName;
                private String address;
                private String name;
                private String headUrl;
                private int period;
                private String lawName;

                public String getTypeName() {
                    return typeName;
                }

                public void setTypeName(String typeName) {
                    this.typeName = typeName;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
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

        public static class UserBean {
            /**
             * name : 田先生
             * headUrl : http://zllserver.oss-cn-beijing.aliyuncs.com/lawyer/user.png
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

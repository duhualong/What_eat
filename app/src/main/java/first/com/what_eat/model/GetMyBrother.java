package first.com.what_eat.model;

import java.util.List;

/**
 * 作者：adu on 2016/3/18 10:45
 * 邮箱2383335125@qq.com
 */
public class GetMyBrother  {
    private List<MyBrotherInformation> brotherlist; //我的兄弟

    public List<MyBrotherInformation> getBrotherlist() {
        return brotherlist;
    }

    public void setBrotherlist(List<MyBrotherInformation> brotherlist) {
        this.brotherlist = brotherlist;
    }

    public class MyBrotherInformation{
        private int tuid;//兄弟id
        private String nickname;//兄弟昵称
        private String head;//兄弟头像
        private String phone;//兄弟手机号
        private String rongyun_token;//兄弟融云token
        private float money;//兄弟收入
        private int inputtime;//邀请时间
        private int brothernum;//兄弟总数
        private float totalmoney;//兄弟收入

        public int getTuid() {
            return tuid;
        }

        public void setTuid(int tuid) {
            this.tuid = tuid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRongyun_token() {
            return rongyun_token;
        }

        public void setRongyun_token(String rongyun_token) {
            this.rongyun_token = rongyun_token;
        }

        public float getMoney() {
            return money;
        }

        public void setMoney(float money) {
            this.money = money;
        }

        public int getInputtime() {
            return inputtime;
        }

        public void setInputtime(int inputtime) {
            this.inputtime = inputtime;
        }

        public int getBrothernum() {
            return brothernum;
        }

        public void setBrothernum(int brothernum) {
            this.brothernum = brothernum;
        }

        public float getTotalmoney() {
            return totalmoney;
        }

        public void setTotalmoney(float totalmoney) {
            this.totalmoney = totalmoney;
        }
    }

}

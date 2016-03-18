package first.com.what_eat.model;

/**
 * 作者：adu on 2016/3/18 09:57
 * 邮箱2383335125@qq.com
 */
public class MyInvitation {
    private int tuid;//被邀请人id
    private String nickname;//被邀请人昵称
    private String head;//被邀请人头像
    private String phone;//被邀请人手机号
    private String rongyun_token;//被邀请人融云token
    private int status;//邀请状态1待回复2同意3拒绝
    private int inputtime;//邀请时间

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getInputtime() {
        return inputtime;
    }

    public void setInputtime(int inputtime) {
        this.inputtime = inputtime;
    }
}

package first.com.what_eat.model;

/**
 * 作者：adu on 2016/3/17 15:30
 * 邮箱2383335125@qq.com
 */
public class MyReward {
    private String money;//交易金额
    private int tradetype;//交易类型（1增2减）
    private  int inputtime;//交易时间
    private String content;//交易内容

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getTradetype() {
        return tradetype;
    }

    public void setTradetype(int tradetype) {
        this.tradetype = tradetype;
    }

    public int getInputtime() {
        return inputtime;
    }

    public void setInputtime(int inputtime) {
        this.inputtime = inputtime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

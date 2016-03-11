package first.com.what_eat.data;

/**
 * 作者：` on 2016/3/11 15:17
 * 邮箱2383335125@qq.com
 */
public class MyIncome {
    public int tuid;//收货人
    public String orderid;//订单号
    public int status;//交易状态
    public String money;//交易金额
    public int tradetype;//交易类型（1增，2减）
    public int inputtime;//交易时间
    public String  content;//交易内容
    public  int total;//总金额

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTuid() {
        return tuid;
    }

    public void setTuid(int tuid) {
        this.tuid = tuid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

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

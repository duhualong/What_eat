package first.com.what_eat.model;

/**
 * 作者：adu on 2016/3/18 13:39
 * 邮箱2383335125@qq.com
 * 配送中订单
 */
public class DeliveryOrder {
    private  String orderid;//订单号
    private float money;//订单金额
    private String title;//订单标题
    private  int runstatus;//接单状态(1已结单，0未结单)
    private int deliverystatus;//配送状态1:配送中 2：已完成
    private String storeid;//商户id
    private int callruntime;//预约取货时间
    private float buyerlat;//收货人纬度
    private float buyerlng;//收货人经度
    private String buyerarea;//收货人所在地区
    private String buyeraddress;//收货人详细地址
    private int sellerremark;//重要说明
    private String storearea;//商户所在地区
    private String storeaddress;//商户详细地址
    private float storelat;//商户维度
    private float storelng;//商户经度
    private float distance;//我离商户的距离（km）
    private float deliveryfee;//配送费
    private int lefttime;//时间差（分钟）政府代表提前或延迟
    private int presendtime;//预计送达时间

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRunstatus() {
        return runstatus;
    }

    public void setRunstatus(int runstatus) {
        this.runstatus = runstatus;
    }

    public int getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(int deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public int getCallruntime() {
        return callruntime;
    }

    public void setCallruntime(int callruntime) {
        this.callruntime = callruntime;
    }

    public float getBuyerlat() {
        return buyerlat;
    }

    public void setBuyerlat(float buyerlat) {
        this.buyerlat = buyerlat;
    }

    public float getBuyerlng() {
        return buyerlng;
    }

    public void setBuyerlng(float buyerlng) {
        this.buyerlng = buyerlng;
    }

    public String getBuyerarea() {
        return buyerarea;
    }

    public void setBuyerarea(String buyerarea) {
        this.buyerarea = buyerarea;
    }

    public String getBuyeraddress() {
        return buyeraddress;
    }

    public void setBuyeraddress(String buyeraddress) {
        this.buyeraddress = buyeraddress;
    }

    public int getSellerremark() {
        return sellerremark;
    }

    public void setSellerremark(int sellerremark) {
        this.sellerremark = sellerremark;
    }

    public String getStorearea() {
        return storearea;
    }

    public void setStorearea(String storearea) {
        this.storearea = storearea;
    }

    public String getStoreaddress() {
        return storeaddress;
    }

    public void setStoreaddress(String storeaddress) {
        this.storeaddress = storeaddress;
    }

    public float getStorelat() {
        return storelat;
    }

    public void setStorelat(float storelat) {
        this.storelat = storelat;
    }

    public float getStorelng() {
        return storelng;
    }

    public void setStorelng(float storelng) {
        this.storelng = storelng;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getDeliveryfee() {
        return deliveryfee;
    }

    public void setDeliveryfee(float deliveryfee) {
        this.deliveryfee = deliveryfee;
    }

    public int getLefttime() {
        return lefttime;
    }

    public void setLefttime(int lefttime) {
        this.lefttime = lefttime;
    }

    public int getPresendtime() {
        return presendtime;
    }

    public void setPresendtime(int presendtime) {
        this.presendtime = presendtime;
    }
}


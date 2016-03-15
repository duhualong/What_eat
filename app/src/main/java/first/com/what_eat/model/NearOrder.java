package first.com.what_eat.model;

/**
 * 作者：` on 2016/3/11 17:07
 * 邮箱2383335125@qq.com
 * 附近抢单页返回参数
 */
public class NearOrder  {
    private String orderid;//订单号
    private String storeid;//商户id
    private int callruntime;//预约取货时间
    private float buyerlat;//收货人维度
    private float buyerlng;//收货人经度
    private String buyerarea;//收货人所在地
    private String buyeraddress;//收货人详细地址
    private int sellerremark;//重要说明
    private String storearea;//商户所在地
    private String storeaddress;//商户详细地址
    private float storelat;//商户维度
    private float storelng;//商户经度
    private float distance;//我离商户的距离km
    private float deliverydistance;//配送距离km
    private float deliveryfee;//配送费

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
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

    public float getDeliverydistance() {
        return deliverydistance;
    }

    public void setDeliverydistance(float deliverydistance) {
        this.deliverydistance = deliverydistance;
    }

    public float getDeliveryfee() {
        return deliveryfee;
    }

    public void setDeliveryfee(float deliveryfee) {
        this.deliveryfee = deliveryfee;
    }
}

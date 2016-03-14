package first.com.what_eat.web;

import first.com.what_eat.data.MyIncome;
import first.com.what_eat.data.NearOrder;
import first.com.what_eat.data.OrderDetail;
import first.com.what_eat.data.RunnerLoading;
import first.com.what_eat.data.ServiceResponse;

/**
 * 作者：` on 2016/3/11 15:30
 * 邮箱2383335125@qq.com
 */
public interface WebService {
    //void getMakeRunner(String phone,String password,String telverify,String nickname);
    void getRunnerLoading(String username,String password,int groupId,ServiceCallback<ServiceResponse<RunnerLoading>>callback);
    //完善资料
    void updatePerfectData(int uid, String prefectField, String prefectValue, ServiceCallback<ServiceResponse<Void>> callback);
    //我的收入
    void getMyIncome(int uid,int startTime,int endTime,int page,int offset ,ServiceCallback<ServiceResponse<MyIncome>>callback);
    //附近抢单页
    void getNearOrder(int uid,String latitude,String longitude,ServiceCallback<ServiceResponse<NearOrder>>callback);
    //订单详情
    void getOrderDetail(int uid,String orderId,String latitude,String longitude,ServiceCallback<ServiceResponse<OrderDetail>>callback);


}

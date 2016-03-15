package first.com.what_eat.web;

import first.com.what_eat.model.MyIncome;
import first.com.what_eat.model.NearOrder;
import first.com.what_eat.model.OrderDetail;
import first.com.what_eat.model.RunnerLoading;
import first.com.what_eat.model.ServiceResponse;

/**
 * 作者：` on 2016/3/11 15:30
 * 邮箱2383335125@qq.com
 */
public interface WebService {
    //成为跑腿
    void getMakeRunner(String phone,String password,String captcha,String nickname,ServiceCallback<ServiceResponse<String>>callback);
    //跑腿端登录
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

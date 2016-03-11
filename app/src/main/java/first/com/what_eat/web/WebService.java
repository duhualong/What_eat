package first.com.what_eat.web;

import first.com.what_eat.data.MyIncome;
import first.com.what_eat.data.NearOrder;
import first.com.what_eat.data.ServiceResponse;

/**
 * 作者：` on 2016/3/11 15:30
 * 邮箱2383335125@qq.com
 */
public interface WebService {
    void getMyIncome(int uid,int startTime,int endTime,int page,int offset ,ServiceCallback<ServiceResponse<MyIncome>>callback);
    void getNearOrder(int uid,String latitude,String longitude,ServiceCallback<ServiceResponse<NearOrder>>callback);
}

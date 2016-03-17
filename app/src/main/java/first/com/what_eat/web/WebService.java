package first.com.what_eat.web;

import first.com.what_eat.model.MakeRunner;
import first.com.what_eat.model.MyBankMessage;
import first.com.what_eat.model.MyEarn;
import first.com.what_eat.model.MyIncome;
import first.com.what_eat.model.MyReward;
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
    void getMakeRunner(String phone, String password, String captcha, String nickname, ServiceCallback<MakeRunner> callback);

    //跑腿端登录
    void getRunnerLoading(String username, String password, int groupId, ServiceCallback<RunnerLoading> callback);

    //完善资料
    void updatePerfectData(int uid, String prefectField, String prefectValue, ServiceCallback<ServiceResponse<Void>> callback);

    //设置上班下班
    void setWorkStatus(int uid, int workStatus, ServiceCallback<ServiceResponse<Void>> callback);

    //设置现住的地址
    void setCurrentAddress(int uid, String address, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback);

    //我的收入
    void getMyIncome(int uid, int startTime, int endTime, int page, int offset, ServiceCallback<ServiceResponse<MyIncome>> callback);

    //附近抢单页
    void getNearOrder(int uid, String latitude, String longitude, ServiceCallback<ServiceResponse<NearOrder>> callback);

    //订单详情
    void getOrderDetail(int uid, String orderId, String latitude, String longitude, ServiceCallback<ServiceResponse<OrderDetail>> callback);

    //接单
    void getReceiveOrder(int uid, String orderId, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback);

    //配送中的订单
    void getDistributionOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<Void>> callback);

    //已完成订单
    void getFinishedOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<Void>> callback);

    //未接订单
    void getUnReceiveOrder(int uid, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback);
    /**
     * 我的收入(7-12)
     * @param uid 用户id
     * @param page 页码
     * @param number 每页数据数目
     * @param callback
     */
    void getMyEarn(int uid,int page,int number,ServiceCallback<ServiceResponse<MyEarn>>callback);
    /**
     * 我的奖励
     * @param uid 用户id
     * @param page 页码
     * @param number 每页数据数目
     * @param callback
     */
    void getMyReward(int uid,int page,int number,ServiceCallback<ServiceResponse<MyReward>>callback);
    /**
     * 绑定银行卡
     * uid 用户id
     * certificateType 证件类型
     * certificateNumber 证件号码
     * bankType 银行卡类型 1储蓄卡 2信用卡
     * bankNumber 开户行
     * name 持卡人姓名
     * phone 预留手机号
     * captcha 手机验证码
     */
    void getBindBank(int uid,int certificateType,String certificateNumber,int bankType,String bankNumber,String bankName,String name,String phone,String captcha,ServiceCallback<ServiceResponse<Void>>callback );
    /**
     * 解除绑定银行卡
     * @param uid 用户id
     * @param bankNumber 卡号
     * @param payPassword 提现密码
     * @param callback
     */
    void getUnbindBank(int uid,String bankNumber,String payPassword,ServiceCallback<ServiceResponse<Void>>callback );
    /**
     * 我的银行卡
     * @param uid  用户id
     * @param callback
     */
    void getMyBankMessage(int uid,ServiceCallback<ServiceResponse<MyBankMessage>>callback);

    /**
     * 设置提现密码
     * @param uid 用户id
     * @param payPassword 提现密码
     * @param callback
     */
    void setWithdrawPassword(int uid,String payPassword,ServiceCallback<ServiceResponse<Void>>callback);
    /**
     * 验证提现密码
     * @param uid 用户id
     * @param payPassword 提现密码
     * @param callback
     */
    void verifyWithdrawPassword(int uid,String payPassword,ServiceCallback<ServiceResponse<Void>>callback);

    /**
     * 修改提现密码
     * @param uid 用户id
     * @param oldPayPassword 旧密码
     * @param newPayPassword 新密码
     * @param callback
     */
    void modifyWithdrawPassword(int uid,String oldPayPassword,String newPayPassword,ServiceCallback<ServiceResponse<Void>>callback);

    /**
     * 申请提现
     * @param uid 用户id
     * @param bankNumber 提现银行卡号
     * @param money 提现金额
     * @param callback
     */
    void ApplyWithdrawal(int uid,String bankNumber,String money,ServiceCallback<ServiceResponse<Void>>callback);
}

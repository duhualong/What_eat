package first.com.what_eat.web;

import first.com.what_eat.model.DeliveryOrder;
import first.com.what_eat.model.FinishedOrder;
import first.com.what_eat.model.GetMyBrother;
import first.com.what_eat.model.MakeRunner;
import first.com.what_eat.model.MyBankMessage;
import first.com.what_eat.model.MyEarn;
import first.com.what_eat.model.MyIncome;
import first.com.what_eat.model.MyInvitation;
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
    /**
     * 成为跑腿
     * @param phone 手机号
     * @param password 密码
     * @param captcha 短信验证码
     * @param nickname 昵称
     * @param callback
     */
    void getMakeRunner(String phone, String password, String captcha, String nickname, ServiceCallback<ServiceResponse<MakeRunner>> callback);

    /**
     * 跑腿端登录
     * @param username 用户名
     * @param password 密码
     * @param groupId  4成为跑腿
     * @param callback
     */
    void getRunnerLoading(String username, String password, int groupId, ServiceCallback<ServiceResponse<RunnerLoading>> callback);

    /**
     * 完善资料
     * @param uid 用户id
     * @param prefectField 字段名称
     * @param prefectValue 值
     * @param callback
     */
    void updatePerfectData(int uid, String prefectField, String prefectValue, ServiceCallback<ServiceResponse<Void>> callback);

    /**
     * 设置上班下班
     * @param uid 用户id
     * @param workStatus 上班1 下班0
     * @param callback
     */
    void setWorkStatus(int uid, int workStatus, ServiceCallback<ServiceResponse<Void>> callback);

    /**
     * 设置现住的地址
     * @param uid 用户id
     * @param address 用户详细地址
     * @param latitude 纬度
     * @param longitude 经度
     * @param callback
     * */
    void setCurrentAddress(int uid, String address, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback);
    /**
     * 我的收入
     * @param uid 用户id
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param page 页码
     * @param offset 页码数量
     * @param callback
     */
    void getMyIncome(int uid, int startTime, int endTime, int page, int offset, ServiceCallback<ServiceResponse<MyIncome>> callback);

    /**  附近抢单页
     * @param uid 用户id
     * @param latitude 纬度
     * @param longitude 经度
     */

    void getNearOrder(int uid, String latitude, String longitude, ServiceCallback<ServiceResponse<NearOrder>> callback);

    /**订单详情
     *
     * @param uid 用户id
     * @param orderId 订单号
     * @param latitude 纬度
     * @param longitude 经度
     * @param callback
     */
    void getOrderDetail(int uid, String orderId, String latitude, String longitude, ServiceCallback<ServiceResponse<OrderDetail>> callback);

    /**
     * 接单
     * @param uid 用户id
     * @param orderId 订单号
     * @param latitude 纬度
     * @param longitude 经度
     * @param callback
     */
    void getReceiveOrder(int uid, String orderId, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback);


    /**
     *  配送中的订单
     * @param uid 用户id
     * @param latitude 纬度
     * @param longitude 经度
     * @param orderId 订单号
     * @param callback
     */
    void getDistributionOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<DeliveryOrder>> callback);


    /**
     * 已完成订单
     * @param uid 用户id
     * @param latitude 纬度
     * @param longitude 经度
     * @param orderId 订单号
     * @param callback
     */
    void getFinishedOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<FinishedOrder>> callback);



    /**
     *  未接订单
     * @param uid 用户id
     * @param latitude 纬度
     * @param longitude 经度
     * @param callback
     */
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

    /**
     * 邀请兄弟
     * @param uid 用户id
     * @param invitationCode 邀请码
     * @param callback
     */
    void inviteBrother(int uid,String invitationCode,ServiceCallback<ServiceResponse<Void>>callback);
    /**
     * 处理邀请
     * @param uid 用户id
     * @param inviteUserId 邀请用户id
     * @param status 状态2同意3拒绝
     * @param callback
     */
    void handleInvitation(int uid,int inviteUserId,int status,ServiceCallback<ServiceResponse<Void>>callback);
    /**
     * 我的邀请
     * @param uid 用户id
     * @param page 页码
     * @param pageNumber 每页数据量
     * @param callback
     */
    void getMyInvitation(int uid,int page,int pageNumber,ServiceCallback<ServiceResponse<MyInvitation>>callback );

    /**
     *获取我的兄弟
     * @param uid 用户id
     * @param collation 排序规则
     * @param keyword 搜索关键词
     * @param page 页码
     * @param pageNumber 每页数据
     * @param callback 回调
     */
    void getMyBrother(int uid,int collation,String keyword,int page,int pageNumber,ServiceCallback<ServiceResponse<GetMyBrother>>callback);
}

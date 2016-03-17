package first.com.what_eat.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import first.com.what_eat.model.MakeRunner;
import first.com.what_eat.model.MyBankMessage;
import first.com.what_eat.model.MyEarn;
import first.com.what_eat.model.MyIncome;
import first.com.what_eat.model.MyReward;
import first.com.what_eat.model.NearOrder;
import first.com.what_eat.model.OrderDetail;
import first.com.what_eat.model.RunnerLoading;
import first.com.what_eat.model.ServiceResponse;
import first.com.what_eat.global.Constant;
import first.com.what_eat.util.EncryptUtil;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * 作者：` on 2016/3/11 15:41
 * 邮箱2383335125@qq.com
 */
public class WebServiceImpl implements WebService{
    private static Gson gson;
    private HttpClient client;

    public WebServiceImpl() {
        client = new HttpClient();
        gson = new Gson();
    }

    /**
     * 成为跑腿
     * @param phone
     * @param password
     * @param captcha
     * @param nickname
     * @param callback
     */

    @Override
    public void getMakeRunner(String phone, String password, String captcha, String nickname, final ServiceCallback<MakeRunner> callback) {
        String url=Constant.PUBLIC_URL+Constant.MAKE_RUNNER_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("phone",phone);
        jsonObject.addProperty("password",password);
        jsonObject.addProperty("telverify",captcha);
        jsonObject.addProperty("nickname",nickname);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<String>>(){}.getType();
                ServiceResponse<String> serviceResponse=gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    String json= EncryptUtil.decrypt(Constant.KEY,serviceResponse.getData());
                    System.out.println("跑腿端返回数据解析结果：" + json);
                    Type returnType=new TypeToken<ServiceResponse<MakeRunner>>(){}.getType();
                   MakeRunner makeRunner=gson.fromJson(json, returnType);
                    callback.onSuccess(makeRunner);

                }else {
                    callback.onFailure("请求参数错误");
                }

            }
        });

    }

    /**
     * 跑腿端登录
     * @param username
     * @param password
     * @param groupId
     * @param callback
     */

    @Override
    public void getRunnerLoading(String username, String password, int groupId, final ServiceCallback<RunnerLoading> callback) {
        String url=Constant.PUBLIC_URL+Constant.RUNNER_LOADING_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("username",username);
        jsonObject.addProperty("password",password);
        jsonObject.addProperty("group_id",groupId);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<String>>(){}.getType();
                ServiceResponse<String> serviceResponse=gson.fromJson(result, type);

                int code=serviceResponse.getCode();
                if (code==200){
                    String json= EncryptUtil.decrypt(Constant.KEY,serviceResponse.getData());
                    System.out.println("跑腿端返回数据解析结果：" + json);
                    Type returnType = new TypeToken<RunnerLoading>(){}.getType();
                    RunnerLoading runnerLoading=gson.fromJson(json, returnType);
                    callback.onSuccess(runnerLoading);

                }else {
                    callback.onFailure("请求错误");
                }
            }
        });



    }

    /**
     * 完善信息
     * @param uid
     * @param prefectField
     * @param prefectValue
     * @param callback
     */
    @Override
    public void updatePerfectData(int uid, String prefectField, String prefectValue, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.PERFECT_DATA_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("filed",prefectField);
        jsonObject.addProperty("value",prefectValue);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void> serviceResponse=gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("请求错误");
                }

            }
        });

    }

    /**
     * 设置上班下班
     * @param uid
     * @param workStatus
     * @param callback
     */
    @Override
    public void setWorkStatus(int uid, int workStatus, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.SET_WORKSTATUS_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("workstatus",workStatus);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse=gson.fromJson(result, type);
               int code= serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);

                }else {
                    callback.onFailure("请求错误");
                }

            }
        });

    }

    /**
     * 设置现住的地址
     * @param uid
     * @param address
     * @param latitude
     * @param longitude
     * @param callback
     */
    @Override
    public void setCurrentAddress(int uid, String address, String latitude, String longitude, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.SET_CURRENT_ADDRESS_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("address",address);
        jsonObject.addProperty("lat",latitude);
        jsonObject.addProperty("lng",longitude);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("参数请求错误");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse=gson.fromJson(result,type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("请求错误");
                }

            }
        });


    }

    /**
     * 我的收入
     * @param uid
     * @param startTime
     * @param endTime
     * @param page
     * @param offset
     * @param callback
     */
    @Override
    public void getMyIncome(int uid, int startTime, int endTime, int page, int offset, final ServiceCallback<ServiceResponse<MyIncome>> callback) {
        String url= Constant.PUBLIC_URL+Constant.MY_INCOME;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("stat_time",startTime);
        jsonObject.addProperty("end_time",endTime);
        jsonObject.addProperty("p",page);
        jsonObject.addProperty("num",offset);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Type type=new TypeToken<ServiceResponse<MyIncome>>(){}.getType();
                ServiceResponse<MyIncome> serviceResponse=gson.fromJson(result,type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);

                }else {
                    callback.onFailure("请求错误");
                }
            }
        });
    }

    /**
     * 附近抢单页
     * @param uid
     * @param latitude
     * @param longitude
     * @param callback
     */
    @Override
    public void getNearOrder(int uid, String latitude, String longitude, final ServiceCallback<ServiceResponse<NearOrder>> callback) {
        String url=Constant.PUBLIC_URL+Constant.NEAR_ORDER;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("lat",latitude);
        jsonObject.addProperty("lng",longitude);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
               callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Type type=new TypeToken<ServiceResponse<NearOrder>>(){}.getType();
                ServiceResponse<NearOrder> serviceResponse=gson.fromJson(result,type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("请求错误");
                }
            }

        });

    }

    /**
     * 订单详情
     * @param uid
     * @param orderId
     * @param latitude
     * @param longitude
     * @param callback
     */
    @Override
    public void getOrderDetail(int uid, String orderId, String latitude, String longitude, final ServiceCallback<ServiceResponse<OrderDetail>> callback) {
        String url=Constant.PUBLIC_URL+Constant.ORDER_DETAIL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("orderid",orderId);
        jsonObject.addProperty("lat",latitude);
        jsonObject.addProperty("lng",longitude);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<OrderDetail>>(){}.getType();
                ServiceResponse<OrderDetail> serviceResponse=gson.fromJson(result,type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("请求错误");
                }
            }

        });


    }

    /**
     * 接单
     * @param uid
     * @param orderId
     * @param latitude
     * @param longitude
     * @param callback
     */
    @Override
    public void getReceiveOrder(int uid, String orderId, String latitude, String longitude, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.RECEIVE_ORDER;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("orderid",orderId);
        jsonObject.addProperty("lat",latitude);
        jsonObject.addProperty("lng",longitude);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse= gson.fromJson(result, type);
               int code= serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("参数错误");
                }

            }
        });
    }

    /**
     * 配送中订单
     * @param uid
     * @param latitude
     * @param longitude
     * @param orderId
     * @param callback
     */
    @Override
    public void getDistributionOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.DISTRIBUTION_ORDER;

    }

    /**
     * 已完成订单
     * @param uid
     * @param latitude
     * @param longitude
     * @param orderId
     * @param callback
     */
    @Override
    public void getFinishedOrder(int uid, String latitude, String longitude, String orderId, ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.FINISHED_ORDER;
    }

    /**
     * 未接订单
     * @param uid
     * @param latitude
     * @param longitude
     * @param callback
     */
    @Override
    public void getUnReceiveOrder(int uid, String latitude, String longitude, ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.UNRECEIVE_ORDER;
    }

    /**
     * 我的收入(7-12)
     * @param uid 用户id
     * @param page 页码
     * @param number 每页数据数目
     * @param callback
     */
    @Override
    public void getMyEarn(int uid, int page, int number, final ServiceCallback<ServiceResponse<MyEarn>> callback) {
        String url=Constant.PUBLIC_URL+Constant.MYEARN_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("p",page);
        jsonObject.addProperty("num",number);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<MyEarn>>(){}.getType();
               ServiceResponse<MyEarn>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("参数错误");
                }
            }
        });


    }

    /**
     * 我的奖励
     * @param uid 用户id
     * @param page 页码
     * @param number 每页数据数目
     * @param callback
     */
    @Override
    public void getMyReward(int uid, int page, int number, final ServiceCallback<ServiceResponse<MyReward>> callback) {
        String url=Constant.PUBLIC_URL+Constant.MYEARN_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("p",page);
        jsonObject.addProperty("num",number);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<MyReward>>(){}.getType();
                ServiceResponse<MyReward>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("参数错误");
                }
            }
        });


    }
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
    @Override
    public void getBindBank(int uid, int certificateType, String certificateNumber, int bankType, String bankNumber, String bankName, String name, String phone, String captcha, final ServiceCallback<ServiceResponse<Void>> callback) {
String url=Constant.PUBLIC_URL+Constant.BINDBANK_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("certificatetype",certificateType);
        jsonObject.addProperty("certificatenumber",certificateNumber);
        jsonObject.addProperty("banktype",bankType);
        jsonObject.addProperty("banknumber",bankNumber);
        jsonObject.addProperty("bankname",bankName);
        jsonObject.addProperty("name",name);
        jsonObject.addProperty("phone",phone);
        jsonObject.addProperty("telverify",captcha);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("绑定失败");
                }
            }
        });


    }

    /**
     * 解除绑定银行卡
     * @param uid 用户id
     * @param bankNumber 卡号
     * @param payPassword 提现密码
     * @param callback
     */
    @Override
    public void getUnbindBank(int uid, String bankNumber, String payPassword, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.UNBINDBANK_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("banknumber",bankNumber);
        jsonObject.addProperty("paypassword",payPassword);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("解除绑定失败");
                }
            }
        });

    }

    /**
     * 我的银行卡
     * @param uid  用户id
     * @param callback
     */
    @Override
    public void getMyBankMessage(int uid, final ServiceCallback<ServiceResponse<MyBankMessage>> callback) {
        String url=Constant.PUBLIC_URL+Constant.MYBANK_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        client.postWithJson(url, jsonObject.toString(), false, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("用户id错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<MyBankMessage>>(){}.getType();
                ServiceResponse<MyBankMessage> serviceResponse=gson.fromJson(result,type);
               int code= serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("请求错误");
                }

            }
        });

    }

    /**
     * 设置提现密码
     * @param uid 用户id
     * @param payPassword 提现密码
     * @param callback
     */
    @Override
    public void setWithdrawPassword(int uid, String payPassword, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.WITHDRAWPASSWORD_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
      jsonObject.addProperty("paypassword",payPassword);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("设置密码失败");
                }
            }
        });

    }

    @Override
    public void verifyWithdrawPassword(int uid, String payPassword, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.VERIFWITHDRAWPASSWORD_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("paypassword",payPassword);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse= gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("提现密码验证不通过");
                }
            }
        });
    }
/**
 * 修改提现密码
 * @param uid 用户id
 * @param oldPayPassword 旧密码
 * @param newPayPassword 新密码
 * @param callback
 * */
    @Override
    public void modifyWithdrawPassword(int uid, String oldPayPassword, String newPayPassword, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.MODIFYWITHDRAWPASSWORD_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("old_paypassword",oldPayPassword);
        jsonObject.addProperty("new_paypassword",newPayPassword);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("c参数错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void>serviceResponse=gson.fromJson(result,type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("参数错误");
                }


            }
        });

    }
    /**
     * 申请提现
     * @param uid 用户id
     * @param bankNumber 提现银行卡号
     * @param money 提现金额
     * @param callback
     */
    @Override
    public void ApplyWithdrawal(int uid, String bankNumber, String money, final ServiceCallback<ServiceResponse<Void>> callback) {
        String url=Constant.PUBLIC_URL+Constant.APPLYWITHDRAWAL_URL;
        JsonObject jsonObject=new JsonObject();
        jsonObject.addProperty("uid",uid);
        jsonObject.addProperty("banknumber",bankNumber);
        jsonObject.addProperty("money",money);
        client.postWithJson(url, jsonObject.toString(), true, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onFailure("请求错误");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Type type=new TypeToken<ServiceResponse<Void>>(){}.getType();
                ServiceResponse<Void> serviceResponse=gson.fromJson(result, type);
                int code=serviceResponse.getCode();
                if (code==200){
                    callback.onSuccess(serviceResponse);
                }else {
                    callback.onFailure("申请失败");
                }

            }
        });

    }
}

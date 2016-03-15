package first.com.what_eat.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import first.com.what_eat.model.MyIncome;
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
    public void getMakeRunner(String phone, String password, String captcha, String nickname, final ServiceCallback<ServiceResponse<String>> callback) {
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
                    callback.onSuccess(serviceResponse);
                    String json= EncryptUtil.decrypt(Constant.KEY,serviceResponse.getData());
                    System.out.println("跑腿端返回数据解析结果：" + json);
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
    public void getRunnerLoading(String username, String password, int groupId, final ServiceCallback<ServiceResponse<RunnerLoading>> callback) {
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
                Type type=new TypeToken<ServiceResponse<RunnerLoading>>(){}.getType();
                ServiceResponse<RunnerLoading> serviceResponse=gson.fromJson(result, type);
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
}

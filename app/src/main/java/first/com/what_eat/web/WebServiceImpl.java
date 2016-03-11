package first.com.what_eat.web;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import first.com.what_eat.data.MyIncome;
import first.com.what_eat.data.NearOrder;
import first.com.what_eat.data.ServiceResponse;
import first.com.what_eat.global.Constant;
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
                Type type=new TypeToken<ServiceResponse<MyIncome>>(){}.getType();
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
}

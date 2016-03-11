package first.com.what_eat.web;

import com.google.gson.Gson;

import first.com.what_eat.global.Constant;
import first.com.what_eat.util.EncryptUtil;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * 作者：` on 2016/3/11 15:56
 * 邮箱2383335125@qq.com
 */
public class HttpClient {
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static OkHttpClient client;

    private static Gson gson;

    public HttpClient() {
        gson = new Gson();
        client = new OkHttpClient();
    }

    /**
     * 发送json数据
     * @param url domain address
     * @param json data
     * @param needEncrpt if need encrypt
     * @param callback server response callback
     */
    public void postWithJson(String url, String json, boolean needEncrpt, Callback callback) {

        String sendData;

        if (needEncrpt) {
            json = EncryptUtil.encrypt(Constant.KEY, json);
            Data data = new Data(json);
            sendData = gson.toJson(data);
        } else {
            sendData = json;
        }
        RequestBody body = RequestBody.create(MEDIA_TYPE_JSON, sendData);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    /**
     * Get json data from domain
     * @param url domain url
     * @param responseCallback server response callback
     */
    public void getJsonData(String url, Callback responseCallback) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        client.newCall(request).enqueue(responseCallback);
    }


    /**
     * 加密数据封装类
     */
    static class Data {
        private String data;

        public Data(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }
    }
}

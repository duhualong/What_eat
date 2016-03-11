package first.com.what_eat.web;

/**
 * 作者：` on 2016/3/11 15:35
 * 邮箱2383335125@qq.com
 */
public interface ServiceCallback<T> {
    void onSuccess(T data);
    void onFailure(String msg);
}


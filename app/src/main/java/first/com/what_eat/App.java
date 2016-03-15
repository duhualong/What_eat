package first.com.what_eat;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import java.util.Stack;

import first.com.what_eat.web.WebService;
import first.com.what_eat.web.WebServiceImpl;

/**
 * 作者：adu on 2016/3/15 15:24
 * 邮箱2383335125@qq.com
 */
public class App extends Application {
    private static App app;
    private WebService webService;
    private SharedPreferences sharedPreferences;
    private static Stack<Activity> activityStack;

    @Override
    public void onCreate() {
        super.onCreate();
        app=this;
        webService=new WebServiceImpl();
        sharedPreferences=getSharedPreferences("load", MODE_PRIVATE);
    }
    public static App getInstance(){
        return app;

    }
    /**
     * 衔接业务逻辑层
     * @return 业务逻辑层接口
     */
    public WebService getWebService() {
        return webService;
    }
    /**
     * 本地存储prefs
     * @return 本地存储接口
     */
    public SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }
}

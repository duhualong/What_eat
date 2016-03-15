package first.com.what_eat.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import butterknife.ButterKnife;
import first.com.what_eat.App;
import first.com.what_eat.web.WebService;

/**
 * 作者：adu on 2016/3/15 15:36
 * 邮箱2383335125@qq.com
 */
public abstract class BaseActivity extends Activity {
    protected App app;
    protected WebService webService;
    protected abstract int getContentView();
    protected abstract void initView();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getContentView()!=0) {
            setContentView(getContentView());
        }
        ButterKnife.bind(this);
        setBaseFeature();
        initView();
    }

    protected  void setBaseFeature(){
        app= (App) getApplication();
        webService=app.getWebService();
    }

}

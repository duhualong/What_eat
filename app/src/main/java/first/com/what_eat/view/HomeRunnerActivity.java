package first.com.what_eat.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import butterknife.Bind;
import butterknife.ButterKnife;
import first.com.what_eat.R;

/**
 * 作者：adu on 2016/3/16 10:26
 * 邮箱2383335125@qq.com
 */
public class HomeRunnerActivity extends Activity {
    @Bind(R.id.my_income)LinearLayout myIncome;
    @Bind(R.id.switch_status)Switch switchStatus;
    public void interfaceClick(View v){
        switch (v.getId()){
            case R.id.my_income:

                break;
            case R.id.switch_status:

                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.runner_home_activity);
        ButterKnife.bind(this);
    }
}

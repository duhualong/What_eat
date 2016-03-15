package first.com.what_eat.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import first.com.what_eat.R;

/**
 * 作者：adu on 2016/3/15 14:45
 * 邮箱2383335125@qq.com
 */
public class ForgetPasswordActivity extends Activity {
    @Bind(R.id.back_left)
    ImageView backLeft;
    @OnClick(R.id.back_left)
    void back(){
        onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

    }
}

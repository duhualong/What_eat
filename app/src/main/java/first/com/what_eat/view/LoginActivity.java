package first.com.what_eat.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.OnClick;
import first.com.what_eat.R;
import first.com.what_eat.model.RunnerLoading;
import first.com.what_eat.model.ServiceResponse;
import first.com.what_eat.web.ServiceCallback;

/**
 * 作者：adu on 2016/3/15 14:27
 * 邮箱2383335125@qq.com
 */
public class LoginActivity extends BaseActivity{
    @Bind(R.id.et_account)EditText account;
    @Bind(R.id.et_password)EditText password;
    @Bind(R.id.progress_bar)
    ProgressBar progressBar;
    @OnClick({R.id.btn_login,R.id.tv_forget_pwd,R.id.tv_become_deliveryman})
    public void EntryClick(View v){
        switch (v.getId()){
            case R.id.btn_login:
                progressBar.setVisibility(View.VISIBLE);
                final String username=account.getText().toString().trim();
                final String pwd=password.getText().toString().trim();
                final int groupId=4;
                webService.getRunnerLoading(username, pwd, groupId, new ServiceCallback<ServiceResponse<RunnerLoading>>() {
                    @Override
                    public void onSuccess(ServiceResponse<RunnerLoading> data) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                                SharedPreferences.Editor editor = app.getSharedPreferences().edit();
                                editor.putString("telephone", username);
                                editor.putString("password", pwd);
                                editor.putInt("groupId", groupId);
                                editor.apply();
                                LoginActivity.this.finish();
                                startActivity(new Intent(getApplicationContext(), HomeRunnerActivity.class));

                            }
                        });
                    }

                    @Override
                    public void onFailure(final String msg) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.INVISIBLE);
                 Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                            }
                        });


                    }
                });
                break;
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this,ForgetPasswordActivity.class));
                break;
            case R.id.tv_become_deliveryman:

                break;
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        app.addActivity(LoginActivity.this);

    }


}

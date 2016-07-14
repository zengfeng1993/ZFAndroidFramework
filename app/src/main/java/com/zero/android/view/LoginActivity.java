package com.zero.android.view;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zero.android.R;
import com.zero.android.common.BaseActivity;
import com.zero.android.constact.LoginConstact;
import com.zero.android.present.LoginPresent;

/**
 * @author zf
 */
public class LoginActivity extends BaseActivity implements LoginConstact.View {
    private static int RESULT_NUM = 1001;

    private LoginPresent loginPresent;

    private EditText    etLoginUserName;
    private EditText    etLoginPassword;
    private ProgressBar pbLogin;
    private Button      btnLogin;

    @Override
    public int getLayoutInflaterView() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        etLoginUserName = (EditText) findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);
        pbLogin = (ProgressBar) findViewById(R.id.pb_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        String userName = etLoginUserName.getText().toString();
        String password = etLoginPassword.getText().toString();

        loginPresent = new LoginPresent(this);
        btnLogin.setOnClickListener(view -> loginPresent.loginTask(userName,password));
    }


    @Override
    public void showLoginError() {
        Toast.makeText(this, "your userName or password error ", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        pbLogin.setVisibility(View.VISIBLE);
    }


    @Override
    public void showLoginSuccess(String userName) {
        Toast.makeText(this, "login success  your userName : " + userName, Toast.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoading() {
        pbLogin.setVisibility(View.GONE);
    }


}

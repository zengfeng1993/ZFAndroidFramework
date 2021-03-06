package com.zero.android.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.zero.android.R;
import com.zero.android.common.utils.IntentUtils;
import com.zero.android.constact.LoginConstact;
import com.zero.android.present.LoginPresent;

/**
 * @author zf
 */
public class LoginActivity extends AppCompatActivity implements LoginConstact.View {
    private static int RESULT_NUM = 1001;

    private LoginPresent loginPresent;

    private EditText    etLoginUserName;
    private EditText    etLoginPassword;
    private Button      btnLogin;
    ConstraintLayout constraintLayout;
    public int getLayoutInflaterView() {
        return R.layout.activity_new_login;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflaterView();
        initView();
    }

    public void initView() {
        etLoginUserName = (EditText) findViewById(R.id.et_login_username);
        etLoginPassword = (EditText) findViewById(R.id.et_login_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);

        loginPresent = new LoginPresent(this);

        String userName = etLoginUserName.getText().toString();
        String password = etLoginPassword.getText().toString();
        btnLogin.setOnClickListener(view -> {
            loginPresent.loginTask(userName,password);
            IntentUtils.goListActivity(this,ListActivity.class);
        });

    }


    @Override
    public void showLoginError() {
        Snackbar.make(constraintLayout,"your userName or password error ",Snackbar.LENGTH_LONG)
                .setAction("you perform setAction()"
                ,view -> Log.i("TAG","you perform onClick method")).show();

    }

    @Override
    public void showLoading() {
        Snackbar.make(constraintLayout,"loading ",Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void showLoginSuccess(String userName) {
        Snackbar.make(constraintLayout,"login success  your userName : " + userName,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void dismissLoading() {
        Snackbar.make(constraintLayout,"dialog is dismiss" ,Snackbar.LENGTH_LONG).show();
    }


}

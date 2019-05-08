package com.elevator.elevatormonitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.elevator.elevatormonitor.Contens.AccountInfo;
import com.elevator.elevatormonitor.Retrofit.RetrofitUtils;
import com.elevator.elevatormonitor.beans.Account;
import com.elevator.elevatormonitor.beans.BaseResponse;
import com.elevator.elevatormonitor.beans.LoginBean;
import com.elevator.elevatormonitor.utils.JsonUtils;
import com.google.gson.Gson;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView title_back;
    private TextView go_back, register, find_password;
    private Button login;
    private String usrname, password;
    private EditText mUsernameEt, mPasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        login = (Button) findViewById(R.id.login);
        mUsernameEt = findViewById(R.id.et_username);
        mPasswordEt = findViewById(R.id.et_password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RetrofitUtils.login(mUsernameEt.getText().toString(), mPasswordEt.getText().toString(), new LoginBack());
            }
        });


        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private class LoginBack implements RetrofitUtils.CallBack {
        public void onSuccess(Response<BaseResponse> baseResponse) {
            LoginBean response = null;
            if (baseResponse.body() != null && baseResponse.body().getData() != null) {

                String string = baseResponse.body().getData().toString();
                response = JsonUtils.fromJson(string, LoginBean.class);
                if (response != null) {
                    //保存个人信息
                    AccountInfo.setUserInfo(response);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFail(Throwable t) {
            Toast.makeText(getApplicationContext(), "登陆失败", Toast.LENGTH_LONG).show();
        }
    }

}


package com.elevator.elevatormonitor;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class registerActivity extends AppCompatActivity {
    private TextView title_back;
    private TextView go_back;
    private Button register;
    private EditText et_username,et_password,et_password_again;
    private EditText et_phone,et_emaile;
    private String username,password,passwordagain;
    private RelativeLayout title_bar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    private void init(){
        title_back=findViewById(R.id.title_back);
        title_back.setText("注册");
        go_back=findViewById(R.id.go_back);
        title_bar=findViewById(R.id.title_bar);
        title_bar.setBackgroundColor(Color.TRANSPARENT);
        register=findViewById(R.id.btn_register);
        et_username=findViewById(R.id.et_username);
        et_password=findViewById(R.id.et_password);
        et_password_again=findViewById(R.id.et_password_again);
        et_phone=findViewById(R.id.et_phone);
        et_emaile=findViewById(R.id.et_email);
        go_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerActivity.this.finish();
            }
        });


    }
}

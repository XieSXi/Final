package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Button loginbtn;
    private Button registerbtn;
    private EditText username;
    private EditText userpwd;
    private TextView state;
    public String TAG="login";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginbtn= (Button) findViewById(R.id.loginButton);
        registerbtn= (Button) findViewById(R.id.registerButton);
        username= (EditText) findViewById(R.id.et_loginactivity_username);
        userpwd= (EditText) findViewById(R.id.et_loginactivity_password);
        state= (TextView) findViewById(R.id.state);
        Log.i(TAG,"已获取所有控件");
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "登录按钮被点击");
                String uname = username.getText().toString().trim();
                String upwd = userpwd.getText().toString().trim();
                Log.i(TAG, "用户名：" + uname + "密码：" + upwd);
                if (uname.length()>0 && upwd .length()>0) {
                    UserManager userManager = new UserManager(LoginActivity.this);
                    int result = userManager.exist(uname, upwd);
                    Log.i(TAG, "登录后验证结果：" + result);
                    if (result == 1) {
                        state.setText("登录成功！");

                        //跳转到主页面

                    } else if (result == 0) {
                        state.setText("用户名不存在！");
                    } else if (result == -1) {
                        state.setText("密码错误！");
                    }
                }
                else{
//                    Toast.makeText(this,"无效提交 请输入用户名或密码",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "无效提交 请输入用户名或密码", Toast.LENGTH_SHORT).show();

                }
            }
        });
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "注册按钮被点击");
                    Intent intent= new Intent(getApplicationContext(),Register1Activity.class);//打开另一个Activity
                    Bundle bundle = new Bundle();
                    startActivity(intent);

            }
        });
    }
}



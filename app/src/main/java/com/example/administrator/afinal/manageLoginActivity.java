package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class manageLoginActivity extends AppCompatActivity {
    private Button loginbtn;
    private EditText manaid;
    private EditText manapwd;
    private TextView state;
    public String TAG="managelogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_login);

        loginbtn= (Button) findViewById(R.id.loginButton);
        manaid= (EditText) findViewById(R.id.et_manaid);
        manapwd= (EditText) findViewById(R.id.et_manapwd);
        state= (TextView) findViewById(R.id.state);
        Log.i(TAG,"已获取所有控件");

//        UserManager userManager = new UserManager(manageLoginActivity.this);
//        String manaid1="001";String manapwd1="aaa";
//        String manaid2="002";String manapwd2="bbb";
//        String manaid3="003";String manapwd3="ccc";
//
//        userManager.add3(manaid1,manapwd1);
//        userManager.add3(manaid2,manapwd2);
//        userManager.add3(manaid3,manapwd3);
//        Log.i(TAG,"已添加至数据库");

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "登录按钮被点击");
                String mid = manaid.getText().toString().trim();
                String mpwd = manapwd.getText().toString().trim();
                Log.i(TAG, "管理员ID：" + mid+ "官方密钥：" + mpwd);
                if (mid.length()>0 && mpwd .length()>0) {
                    UserManager userManager = new UserManager(manageLoginActivity.this);
                    int result = userManager.login2(mid, mpwd);
                    Log.i(TAG, "登录后验证结果：" + result);
                    if (result == 1) {
                        state.setText("登录成功！");

                        Intent intent= new Intent(getApplicationContext(),Xmanager2Activity.class);//打开另一个Activity
                        startActivity(intent);


                    } else if (result == 0) {
                        state.setText("该管理员ID不存在！");
                    } else if (result == -1) {
                        state.setText("密码错误！");
                    }
                }
                else{
//                    Toast.makeText(this,"无效提交 请输入用户名或密码",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "无效提交 请输入管理员ID或官方密钥", Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

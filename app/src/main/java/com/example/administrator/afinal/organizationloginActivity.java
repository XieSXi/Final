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

import java.util.List;

public class organizationloginActivity extends AppCompatActivity {
    private Button loginbtn;
    private EditText orgname;
    private EditText orgpwd;
    private TextView state;
    public String TAG="managelogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizationlogin);

        loginbtn= (Button) findViewById(R.id.loginButton);
        orgname= (EditText) findViewById(R.id.et_loginactivity_username);
        orgpwd= (EditText) findViewById(R.id.et_loginactivity_password);
        state= (TextView) findViewById(R.id.state);
        Log.i(TAG,"已获取所有控件");

        //测试表
//        UserManager userManager = new UserManager(organizationloginActivity.this);
//        userManager.add1(new UserItem("41711001","王花花","","","","","","","",""));
//        userManager.add1(new UserItem("41711002","李小小","","","","","","","",""));
//        userManager.add1(new UserItem("41711003","张一一","","","","","","","",""));
//        Log.i(TAG,"已添加至数据库");
//        UserManager userManager = new UserManager(organizationloginActivity.this);
//        String orgname1="西南财经大学青年志愿者协会";String orgpwd1="123";
//        String orgname2="路见小动物保护协会";String orgpwd2="456";
//        String orgname3="益行公益社";String orgpwd3="789";
//
//        userManager.add2(orgname1,orgpwd1);
//        userManager.add2(orgname2,orgpwd2);
//        userManager.add2(orgname3,orgpwd3);
//        Log.i(TAG,"已添加至数据库");




        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "登录按钮被点击");
                String oname = orgname.getText().toString().trim();
                String opwd = orgpwd.getText().toString().trim();
                Log.i(TAG, "组织：" + oname + "密钥：" + opwd);
                if (oname.length()>0 && opwd .length()>0) {
                    UserManager userManager = new UserManager(organizationloginActivity.this);
                    int result = userManager.login1(oname, opwd);
                    Log.i(TAG, "登录后验证结果：" + result);
                    if (result == 1) {
                        state.setText("登录成功！");

//                        SharedPreferences mySharedPreferences= getSharedPreferences("orginfo",Activity.MODE_PRIVATE);
//                        SharedPreferences.Editor editor = mySharedPreferences.edit();
//                        editor.putString("orgname", oname );
//                        editor.commit();

                        //保存登录的组织名后跳转到主页面
                        Intent intent= new Intent(getApplicationContext(),MainActivity.class);//打开另一个Activity
                        Bundle bundle = new Bundle();
                        bundle.putString("orgname_key",oname);
                        intent.putExtras(bundle);
                        startActivity(intent);



                    } else if (result == 0) {
                        state.setText("该组织不存在！");
                    } else if (result == -1) {
                        state.setText("密码错误！");
                    }
                }
                else{
//                    Toast.makeText(this,"无效提交 请输入用户名或密码",Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(), "无效提交 请输入组织或密钥", Toast.LENGTH_SHORT).show();

                }
            }
        });






    }
}


package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Register2Activity extends AppCompatActivity {
    private Button finishbtn;
    private Button loginbtn;
    private EditText major;
    private EditText tel;
    private EditText email;
    private Spinner xueyuan;
    private Spinner nianji;
    private Spinner hobby;
    private TextView state3;
    public String TAG="register2";

    String stuno;String stuna;String userna;String password1;String password2;
    String xueyuan1;String nianji1;String hobby1;String major1;String tel1;String email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        stuno=bundle.getString("stuno_key");
        stuna=bundle.getString("stuna_key");
        userna=bundle.getString("userna_key");
        password1=bundle.getString("password1_key");

        finishbtn=(Button) findViewById(R.id.finish);
        loginbtn=(Button) findViewById(R.id.login);
        major=(EditText) findViewById(R.id.major);
        tel=(EditText) findViewById(R.id.tel);
        email=(EditText) findViewById(R.id.email);
        xueyuan = (Spinner) findViewById(R.id.xueyuan);
        nianji= (Spinner) findViewById(R.id.nianji);
        hobby =(Spinner) findViewById(R.id.hobby);
        state3= (TextView) findViewById(R.id.state3);

        finishbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "完成按钮被点击");
                xueyuan1=xueyuan.getSelectedItem().toString();
                nianji1= nianji.getSelectedItem().toString();
                hobby1= hobby.getSelectedItem().toString();
                major1 = major.getText().toString().trim();
                tel1 = tel.getText().toString().trim();
                email1= email.getText().toString().trim();
                Log.i(TAG, "学院：" + xueyuan1 + "年级：" + nianji1+"偏好："+hobby1);
                if (xueyuan1.length()>0 && nianji1.length()>0&& hobby1.length()>0&&major1.length()>0&&tel.length()>0&&email1.length()>0) {
                    //把数据写入数据库中
                    UserManager manager =new UserManager(getApplicationContext());
                    manager.add(new UserItem(stuno,stuna,userna,password1,nianji1,xueyuan1,major1,tel1,email1,hobby1));
                    Log.i(TAG,"该用户数据已写入数据库");
                    state3.setText("注册成功！去登录");
                }
                else{
                    Toast.makeText(getApplicationContext(), "无效提交 请完整填入信息", Toast.LENGTH_SHORT).show();
                }
            }
        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "登录按钮被点击");
                if(state3.getText()=="注册成功！去登录"){
                    Intent intent= new Intent(getApplicationContext(),LoginActivity.class);//打开另一个Activity
                    startActivity(intent);

                }
            }});


        }



}




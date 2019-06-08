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

public class Register1Activity extends AppCompatActivity {
    private Button registerbtn;
    private Button yanzhengbtn;
    private Button nextbtn;
    private EditText stunumber;
    private EditText stuname;
    private EditText username;
    private EditText userpwd1;
    private EditText userpwd2;
    private TextView state1;
    private TextView state2;
    public String TAG="register1";
    String stuno;String stuna;String userna;String password1;String password2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        registerbtn= (Button) findViewById(R.id.bt_registeractivity_register);
        yanzhengbtn=(Button) findViewById(R.id.yanzheng);
        nextbtn=(Button) findViewById(R.id.next);
        stunumber=(EditText) findViewById(R.id.stuNumber);
        stuname=(EditText) findViewById(R.id.stuName);
        username=(EditText) findViewById(R.id.et_registeractivity_username);
        userpwd1=(EditText) findViewById(R.id.et_registeractivity_password1);
        userpwd2=(EditText) findViewById(R.id.et_registeractivity_password2);
        state1= (TextView) findViewById(R.id.state1);
        state2= (TextView) findViewById(R.id.state2);

        yanzhengbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "学籍验证按钮被点击");
                stuno = stunumber.getText().toString().trim();
                stuna = stuname.getText().toString().trim();
                Log.i(TAG, "学号：" +stuno + "姓名：" + stuna);
                if (stuno.length()>0 && stuna .length()>0) {
                    UserManager userManager = new UserManager(Register1Activity.this);
                    int result=userManager.yanzheng(stuna,stuno);
                    if (result == 1) {
                        state1.setText("学籍验证成功！");
                    } else if (result == 0) {
                        state1.setText("学籍验证失败！");
                    }

                }
                else{
                    Toast.makeText(getApplicationContext(), "无效提交 请输入学号或姓名", Toast.LENGTH_SHORT).show();

                }
            }
        });

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "注册按钮被点击");
                userna= username.getText().toString().trim();
                password1 = userpwd1.getText().toString().trim();
                password2 = userpwd2.getText().toString().trim();
                Log.i(TAG, "用户名：" + userna + "密码：" + password1+"确认密码："+password2);
                if (state1.getText()=="学籍验证成功！"&&userna.length()>0 && password1 .length()>0&& password2 .length()>0) {
                    if(password1.equals(password2)){
                        state2.setText("下一步→");
                    }
                    else {
                        state2.setText("密码输入不一致 注册失败！");
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "无效提交 学籍未通过或注册必填项有空值", Toast.LENGTH_SHORT).show();
                }
            }
        });

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "下一步按钮被点击");
                if(state2.getText()=="下一步→"){
                    Intent intent= new Intent(getApplicationContext(),Register2Activity.class);//打开另一个Activity
                    Bundle bundle = new Bundle();
                    bundle.putString("stuno_key",stuno);
                    bundle.putString("stuna_key",stuna);
                    bundle.putString("userna_key",userna);
                    bundle.putString("password1_key",password1);
                    intent.putExtras(bundle);
                    startActivity(intent);

                }

            }
        });

    }
//    private void openRegister2() {
//        Intent config= new Intent(this,Register2Activity.class);//打开另一个Activity
//        /*Intent web= new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jd.com"));//打开网页
//        Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:87092173"));//拨号*/
//        config.putExtra("stuno_key",stuno);
//        config.putExtra("stuna_key",stuna);
//        config.putExtra("userna_key",userna);
//
//        Log.i(TAG,"openOne: stuno="+ stuno);
//
//        startActivity(config);
//
//    }

}


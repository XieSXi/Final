package com.example.administrator.afinal;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class RegisteroldActivity extends AppCompatActivity {
    private Button registerbtn;
    private Button yanzhengbtn;
    private Button finishbtn;
    private EditText stunumber;
    private EditText stuname;
    private EditText username;
    private EditText userpwd1;
    private EditText userpwd2;
    private EditText major;
    private EditText tel;
    private EditText email;
    private Spinner xueyuan;
    private Spinner nianji;
    private Spinner hobby;
    private TextView state1;
    private TextView state2;
    private TextView state3;
    public String TAG="register";
    String stuno;String stuna;String userna;String password1;String password2;
    String xueyuan1;String nianji1;String hobby1;String major1;String tel1;String email1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerold);
        ViewPager viewPager  =(ViewPager)findViewById(R.id.viewpager);
        RegisterPageAdapter pageAdapter =new RegisterPageAdapter(getSupportFragmentManager());
        viewPager .setAdapter(pageAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


//        registerbtn= (Button) findViewById(R.id.bt_registeractivity_register);
//        yanzhengbtn=(Button) findViewById(R.id.yanzheng);
//        finishbtn=(Button) findViewById(R.id.finish);

//        stunumber=(EditText) findViewById(R.id.stuNumber);
//        Log.i(TAG,""+stunumber.getText());
//        stuname=(EditText) findViewById(R.id.stuName);
//        username=(EditText) findViewById(R.id.et_registeractivity_username);
//        userpwd1=(EditText) findViewById(R.id.et_registeractivity_password1);
//        userpwd2=(EditText) findViewById(R.id.et_registeractivity_password2);
//        major=(EditText) findViewById(R.id.major);
//        tel=(EditText) findViewById(R.id.tel);
//        email=(EditText) findViewById(R.id.email);
//
//        xueyuan = (Spinner) findViewById(R.id.xueyuan);
//        nianji= (Spinner) findViewById(R.id.nianji);
//        hobby =(Spinner) findViewById(R.id.hobby);
//
//        state1= (TextView) findViewById(R.id.state1);
//        state2= (TextView) findViewById(R.id.state2);
//        state3= (TextView) findViewById(R.id.state3);
//
//        yanzhengbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "学籍验证按钮被点击");
//                stuno = stunumber.getText().toString().trim();
//                stuna = stuname.getText().toString().trim();
//                Log.i(TAG, "学号：" +stuno + "姓名：" + stuna);
//                if (stuno.length()>0 && stuna .length()>0) {
//                    UserManager userManager = new UserManager(RegisteroldActivity.this);
//                    int result = userManager.exist1(stuno, stuna);
//                    Log.i(TAG, "学籍验证结果：" + result);
//                    if (result == 1) {
//                        state1.setText("学籍验证成功！");
//                    } else if (result == 0) {
//                        state1.setText("学籍验证失败！");
//                    }
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "无效提交 请输入学号或姓名", Toast.LENGTH_SHORT).show();
//
//                }
//            }
//        });
//
//        registerbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "注册按钮被点击");
//                userna= username.getText().toString().trim();
//                password1 = userpwd1.getText().toString().trim();
//                password2 = userpwd2.getText().toString().trim();
//                Log.i(TAG, "用户名：" + userna + "密码：" + password1+"确认密码："+password2);
//                if (userna.length()>0 && password1 .length()>0&& password2 .length()>0) {
//                    if(password1==password2){
//                        state2.setText("下一步→");
//                    }
//                    else {
//                        state2.setText("密码输入不一致 注册失败！");
//                    }
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "无效提交 请输入用户名或密码或密码确认", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        finishbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "完成按钮被点击");
//                xueyuan1=xueyuan.getSelectedItem().toString();
//                nianji1= nianji.getSelectedItem().toString();
//                hobby1= hobby.getSelectedItem().toString();
//                major1 = major.getText().toString().trim();
//                tel1 = tel.getText().toString().trim();
//                email1= email.getText().toString().trim();
//                Log.i(TAG, "学院：" + xueyuan1 + "年级：" + nianji1+"偏好："+hobby1);
//                if (xueyuan1.length()>0 && nianji1.length()>0&& hobby1.length()>0&&major1.length()>0&&tel.length()>0&&email1.length()>0) {
//                    //把数据写入数据库中
//                    UserManager manager =new UserManager(getApplicationContext());
//                    manager.add(new UserItem(stuno,stuna,userna,password1,nianji1,xueyuan1,major1,tel1,email1));
//                    Log.i(TAG,"该用户数据已写入数据库");
//                }
//                else{
//                    Toast.makeText(getApplicationContext(), "无效提交 请完整填入信息", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });





    }
}

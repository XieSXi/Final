package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeleteActivity extends AppCompatActivity {
    String hdname;String orgname;String yue,ri,shi,fen;
    TextView people;TextView timesheng;TextView shuoming;TextView tishi;
    Button fanhui;Button queding;
    String TAG="delete";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        people=(TextView)findViewById(R.id.peopleamount);
        timesheng=(TextView)findViewById(R.id.timesheng);
        shuoming=(TextView)findViewById(R.id.shuoming);
        tishi=(TextView)findViewById(R.id.tishi);
        fanhui=(Button)findViewById(R.id.fanhui);
        queding=(Button)findViewById(R.id.queding);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        hdname=bundle.getString("hdname");
        orgname=bundle.getString("orgname");
        yue=bundle.getString("yue");
        ri=bundle.getString("ri");
        shi=bundle.getString("shi");
        fen=bundle.getString("fen");


        UserManager manager=new UserManager(this);
        int a=manager.attendscount1(hdname);
        String aa=String.valueOf(a);
        people.setText(aa);

        String regEx="[^0-9]";Pattern p = Pattern.compile(regEx);
        Matcher yue1 = p.matcher(yue);String yue2=yue1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        Matcher ri1 = p.matcher(ri);String ri2=ri1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        int yue3 = Integer.parseInt(yue2);int ri3 = Integer.parseInt(ri2);
        Calendar c = Calendar.getInstance();
        int mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期


        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),orghuodongChakanActivity.class);//打开另一个Activity
                startActivity(intent);
            }
        });
        if(yue3<mMonth){
            timesheng.setText("---");
            queding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(getApplicationContext(),orghuodongChakanActivity.class);//打开另一个Activity
                    startActivity(intent);
                }
            });
        }
        else if(yue3==mMonth){
            if(ri3<mDay){
                timesheng.setText("---");
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(getApplicationContext(),orghuodongChakanActivity.class);//打开另一个Activity
                        startActivity(intent);
                    }
                });
            }
            else if(ri3-mDay>=2){
                shuoming.setText("距报名截止还有");
                timesheng.setText(String.valueOf(ri3-mDay));
                tishi.setText("您确定要取消这次活动吗");
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        UserManager manager=new UserManager(getApplicationContext());
                        manager.quxiaohuodong1(hdname);
                        manager.quxiaohuodong2(hdname);
                        Log.i("TAG","已从acti和attend表中删除信息1");
                    }
                });
            }
            else {
                shuoming.setText("距报名截止仅有");
                timesheng.setText(String.valueOf(ri3-mDay));
                queding.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent= new Intent(getApplicationContext(),orghuodongChakanActivity.class);//打开另一个Activity
                        startActivity(intent);
                    }
                });

            }
        }
        else{
            shuoming.setText("距报名截止还有");
            timesheng.setText(String.valueOf(30-mDay+ri3+30*(yue3-mMonth-1)));
            tishi.setText("您确定要取消这次活动吗");
            queding.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    UserManager manager=new UserManager(getApplicationContext());
                    manager.quxiaohuodong1(hdname);
                    manager.quxiaohuodong2(hdname);
                    Log.i("TAG","已从acti和attend表中删除信息2");
                }
            });

        }
    }







}

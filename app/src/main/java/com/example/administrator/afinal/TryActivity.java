package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TryActivity extends AppCompatActivity {
    List<String> hdnamelist = new ArrayList<>();
    String TAG="shujucaozuo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

//        UserManager manager=new UserManager(this);

//        manager.deleteAll2();
//        Log.i(TAG,"tb_students一删除数据");
//        manager.deleteAll1();
//        Log.i(TAG,"tb_users一删除数据");
//        manager.deleteAll3();
//        Log.i(TAG,"tb_organization一删除数据");
//        manager.deleteAll6();
//        Log.i(TAG,"tb_acti一删除数据");
//        manager.deleteAll7();
//        Log.i(TAG,"tb_attend一删除数据");
//        Calendar c = Calendar.getInstance();//
//        int mMonth = c.get(Calendar.MONTH) ;// 获取当前月份
//        int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
//        int mHour = c.get(Calendar.HOUR_OF_DAY);//时
//        int mMinute = c.get(Calendar.MINUTE);//分
//        Log.i(TAG,""+mMonth+mDay+mHour+mMinute);
//
//        UserManager manager=new UserManager(this);
//        hdnamelist=manager.listhdname();
//        String a=hdnamelist.get(0);
//        Log.i(TAG,""+a);
//        Log.i(TAG,"nihaoa");



    }
}

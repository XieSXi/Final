package com.example.administrator.afinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class XiangqingActivity extends AppCompatActivity {
    String hdname;
    String username;
    String TAG="xiangqingye";
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    List<String> hdnamelist = new ArrayList<>();
    List a=new ArrayList();
    private Button baomingbtn;
    private Button quxiaobtn;
    private TextView bmstate;
    private TextView yue;
    private TextView ri;
    private TextView shi;
    private TextView fen;
    private TextView text1;private TextView text2;private TextView text3;private TextView text4;private TextView text5;
//    String yue31,ri31,shi31,fen31,mMonth1,mDay1,mHour1,mMinute1;
    int yue3,ri3,shi3,fen3,mMonth,mDay,mHour,mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        hdname=bundle.getString("hdname");
        UserManager manager=new UserManager(this);
        int result=manager.existhd(hdname);
        if (result==0){
            hdnamelist=manager.listhdname();
            int c=(int)manager.hdscount();
            Random rand = new Random();
            int suiji=rand.nextInt(c);
            hdname=hdnamelist.get(suiji);
            Toast.makeText(getApplicationContext(), "该活动不存在，已为您随机推荐活动", Toast.LENGTH_SHORT).show();
        }
        username=bundle.getString("username");
        yue3=bundle.getInt("yue3",0);
        ri3=bundle.getInt("ri3",0);
        shi3=bundle.getInt("shi3",0);
        fen3=bundle.getInt("fen3",0);
        mMonth=bundle.getInt("month",0);
        mDay=bundle.getInt("day",0);
        mHour=bundle.getInt("hour",0);
        mMinute=bundle.getInt("minute",0);
//        yue3=Integer.parseInt(yue31);
//        ri3=Integer.parseInt(ri31);
//        shi3=Integer.parseInt(shi31);
//        fen3=Integer.parseInt(fen31);
//        mMonth=Integer.parseInt(mMonth1);
//        mDay=Integer.parseInt(mDay1);
//        mHour=Integer.parseInt(mHour1);
//        mMinute=Integer.parseInt(mMinute1);
        baomingbtn= (Button) findViewById(R.id.bmbtn);
        quxiaobtn= (Button) findViewById(R.id.quxiaobtn);
        bmstate=(TextView)findViewById(R.id.bmstate);
        yue=(TextView)findViewById(R.id.month);
        ri=(TextView)findViewById(R.id.day);
        shi=(TextView)findViewById(R.id.hour);
        fen=(TextView)findViewById(R.id.minute);
        text1=(TextView)findViewById(R.id.text1);text2=(TextView)findViewById(R.id.text2);
        text3=(TextView)findViewById(R.id.text3);text4=(TextView)findViewById(R.id.text4);
        text5=(TextView)findViewById(R.id.text5);
        HdItem item=new HdItem();

        getData();
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.xiangqing_item
                , new String[]{ "org", "name", "time","content","place","requests","renshu","attention","train","pay",
                "yue","ri","shi","fen"}
                , new int[]{R.id.et_org,R.id.et_name, R.id.et_time, R.id.et_content,R.id.et_place, R.id.et_requests,R.id.et_renshu,
                R.id.et_attention, R.id.et_whethertrain,R.id.et_whetherpay,R.id.yue,R.id.ri,R.id.shi,R.id.fen});

        ListView listView=findViewById(R.id.listshow);
        listView.setAdapter(adapter);



        baomingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "报名按钮被点击");
                Log.i(TAG, "用户名：" + username + "   报名活动：" + hdname);
                UserManager userManager = new UserManager(XiangqingActivity.this);
                int a=userManager.attendscount1(hdname);;
                Log.i(TAG,"该活动当前报名人数为"+a);
                HdItem item= userManager. findorgtimeByhdname(hdname);
                String renshu=item.getHdrenshu();
                int renshu1=Integer.parseInt(renshu);
                Log.i(TAG,"该活动需求人数为"+renshu1);
                int chongfu=userManager.chongfubaoming(hdname,username);
                if(chongfu==0){
                    if(renshu1>a){
                        Toast.makeText(getApplicationContext(), "当前活动还有报名余额", Toast.LENGTH_SHORT).show();
                        userManager.add5(new AttendItem(hdname,username,null));
                        Log.i(TAG, "数据已写入attend数据库");
                        Toast.makeText(getApplicationContext(), "报名成功，可前往我的志愿活动查看", Toast.LENGTH_SHORT).show();
                    }
                    else if((renshu1<=a)){
                        Toast.makeText(getApplicationContext(), "抱歉，当前活动名额已满", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "不可重复报名哦!", Toast.LENGTH_SHORT).show();
                }


            }


        });


        quxiaobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(XiangqingActivity.this);
                Log.i(TAG, "取消报名按钮被点击");
                Log.i(TAG, "用户名：" + username + "   报名活动：" + hdname);
                UserManager userManager = new UserManager(XiangqingActivity.this);
                int chongfu=userManager.chongfubaoming(hdname,username);
                Log.i(TAG,"是否报名"+chongfu);
                int a=userManager.attendscount1(hdname);
                Log.i(TAG,"该活动当前报名人数为"+a);
                HdItem item= userManager.findorgtimeByhdname(hdname);
                String renshu=item.getHdrenshu();
                int renshu1=Integer.parseInt(renshu);
                Log.i(TAG,"该活动需求人数为"+renshu1);
                int shengyu=renshu1-a;
                String shengyu1=String.valueOf(shengyu);
                if(chongfu==0){
                    builder.setTitle("提示").setMessage("您未报名哦！")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            });
                }
                else{
                    builder.setTitle("提示").setMessage("您确定要取消报名吗？当前志愿活动余额仅剩"+shengyu1+"个")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    UserManager manager=new UserManager(XiangqingActivity.this);
                                    manager.quxiaobaoming(hdname,username);
                                    Log.i(TAG,"已从数据库中删除该attend数据");
                                    Toast.makeText(getApplicationContext(), "已取消报名", Toast.LENGTH_SHORT).show();

                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    }
                            });

                }
                builder.show();
            }
        });

//相当于做一个报名截止倒计时
        if(yue3==0&&ri3==0&&shi3==0&&fen3==0&&mMonth==0&&mDay==0&&mHour==0&&mMinute==0) {
            text1.setText("");text2.setText("");text3.setText("");text4.setText("");text5.setText("");
            yue.setText("");ri.setText("");shi.setText("");fen.setText("");
        }
        else{
            yue.setText(String.valueOf(yue3-mMonth));
            if(yue3==mMonth) {
                if(ri3==mDay){
                    ri.setText(String.valueOf(ri3-mDay));
                    if(shi3==mHour){
                        shi.setText(String.valueOf(shi3-mHour));fen.setText(String.valueOf(fen3-mMinute));
                    }
                    else if(shi3>mHour){
                        shi.setText(String.valueOf(shi3-mHour-1));fen.setText(String.valueOf(60-mMinute+fen3));
                    }
                }
                else if(ri3>mDay){
                    ri.setText(String.valueOf(ri3-mDay));
                    shi.setText(String.valueOf("-"));fen.setText(String.valueOf("-"));
                }
            }
            else if(yue3>mMonth){
                ri.setText(String.valueOf(30-mDay+ri3));
                shi.setText(String.valueOf("-"));fen.setText(String.valueOf("-"));
            }
        }
    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.showByHdname( hdname)) {
            Map<String, Object> map = new HashMap<>();
            map.put("org", item.getHdorg());
            map.put("name", item.getHdname());
            map.put("time", item.getHdtime());
            map.put("content", item.getHdcontent());
            map.put("place", item.getHdplace());
            map.put("requests", item.getHdrequests());
            map.put("renshu", item.getHdrenshu());
            map.put("attention", item.getHdattention());
            map.put("train", item.getHdtrain());
            map.put("pay", item.getHdpay());
            map.put("yue", item.getHdyue());
            map.put("ri", item.getHdri());
            map.put("shi", item.getHdshi());
            map.put("fen", item.getHdfen());
            listitem.add(map);
        }
    }


}



package com.example.administrator.afinal;

import android.app.Activity;
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

public class XiangqingActivity extends AppCompatActivity {
    String hdname;
    String username;
    String TAG="xiangqingye";
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    private Button baomingbtn;
    private Button quxiaobtn;
    private TextView bmstate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiangqing);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        hdname=bundle.getString("hdname");
        username=bundle.getString("username");
        baomingbtn= (Button) findViewById(R.id.bmbtn);
        quxiaobtn= (Button) findViewById(R.id.quxiaobtn);
        bmstate=(TextView)findViewById(R.id.bmstate);


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
                Log.i(TAG, "取消报名按钮被点击");
                Log.i(TAG, "用户名：" + username + "   报名活动：" + hdname);
                UserManager userManager = new UserManager(XiangqingActivity.this);
                int chongfu=userManager.chongfubaoming(hdname,username);
                if(chongfu==0){
                    Toast.makeText(getApplicationContext(), "您未报名哦!", Toast.LENGTH_SHORT).show();
                }
                else{
                    userManager.quxiaobaoming(hdname,username);
                    Log.i(TAG,"已从数据库中删除该attend数据");
                    Toast.makeText(getApplicationContext(), "已取消报名!", Toast.LENGTH_SHORT).show();
                }
            }


        });




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

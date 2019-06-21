package com.example.administrator.afinal;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class orghuodongChakanActivity extends ListActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String org;
    String hdname;String yue,ri,shi,fen;
    String TAG = "huodongchakan";
    Calendar c = Calendar.getInstance();
    int mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
    int mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
    String timesheng;String tian="天。";
    String tishi1="距报名截止仅有";String tishi2="距报名截止还有";
    String tishi11="所以很抱歉，您不能取消此活动";String tishi22="您确定要取消此活动吗?";String dangqian="当前报名人数已有";String ren="人。";

    SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HdItem item = new HdItem();
        org = getSharedPreferences("orginfo", Context.MODE_PRIVATE).getString("orgname", "青协");
        Log.i(TAG,"当前登录的组织为："+org);
        getData();

     adapter = new SimpleAdapter(this
                , listitem
                , R.layout.activity_orghuodong_chakan_item
                , new String[]{"id", "org", "name", "time", "content", "place", "requests", "renshu", "attention", "train", "pay",
                "yue", "ri", "shi", "fen"}
                , new int[]{R.id.et_id, R.id.et_org, R.id.et_name, R.id.et_time, R.id.et_content, R.id.et_place, R.id.et_requests, R.id.et_renshu,
                R.id.et_attention, R.id.et_whethertrain, R.id.et_whetherpay, R.id.yue, R.id.ri, R.id.shi, R.id.fen});


        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);
    }


    private void getData() {
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.showByOrg(org)) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
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
    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        Log.i(TAG,"我发布的活动被短按");
//        Intent delete= new Intent(this,DeleteActivity.class);
        HashMap<String,String> map1= (HashMap<String, String>) getListView().getItemAtPosition(position);
        hdname=map1.get("name");
        yue=map1.get("yue");
        ri=map1.get("ri");
        shi=map1.get("shi");
        fen=map1.get("fen");
//        Log.i(TAG,"haname"+hdname);
//        delete.putExtra("hdname",hdname);
//        delete.putExtra("orgname",org);
//        delete.putExtra("yue",yue);
//        delete.putExtra("ri",ri);
//        delete.putExtra("shi",shi);
//        delete.putExtra("fen",fen);
//        startActivity(delete);
        String regEx="[^0-9]";Pattern p = Pattern.compile(regEx);
        Matcher yue1 = p.matcher(yue);String yue2=yue1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        Matcher ri1 = p.matcher(ri);String ri2=ri1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        int yue3 = Integer.parseInt(yue2);int ri3 = Integer.parseInt(ri2);

        UserManager manager=new UserManager(this);
        int a=manager.attendscount1(hdname);
        String aa=String.valueOf(a);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if(yue3<mMonth){
            timesheng="---";
            builder.setTitle("提示").setMessage(tishi1+timesheng+tian+tishi11)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//确定按钮的点击事件
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//取消按钮的点击事件
                        }
                    });
        }
        else if(yue3==mMonth){
            if(ri3<mDay){
                timesheng="---";
                builder.setTitle("提示").setMessage(tishi1+timesheng+tian+tishi11)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//确定按钮的点击事件
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//取消按钮的点击事件
                            }
                        });
            }
            else if(ri3-mDay>=2){

                timesheng=String.valueOf(ri3-mDay);
                builder.setTitle("提示").setMessage(tishi2+timesheng+tian+tishi22+dangqian+aa+ren)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//确定按钮的点击事件
                                UserManager manager=new UserManager(getApplicationContext());
                                manager.quxiaohuodong1(hdname);
                                manager.quxiaohuodong2(hdname);
                                Log.i("TAG","已从acti和attend表中删除信息1");
                                listitem.remove(position);
                                adapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//取消按钮的点击事件
                            }
                        });
            }


            else {
            timesheng=String.valueOf(ri3-mDay);
            builder.setTitle("提示").setMessage(tishi1+timesheng+tian+tishi11)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//确定按钮的点击事件
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//取消按钮的点击事件
                        }
                    });

            }
    }
        else{

            timesheng=String.valueOf(30-mDay+ri3+30*(yue3-mMonth-1));
            builder.setTitle("提示").setMessage(tishi2+timesheng+tian+tishi22+dangqian+aa+ren)
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//确定按钮的点击事件
                            UserManager manager=new UserManager(getApplicationContext());
                            manager.quxiaohuodong1(hdname);
                            manager.quxiaohuodong2(hdname);
                            Log.i("TAG","已从acti和attend表中删除信息1");
                            listitem.remove(position);
                            adapter.notifyDataSetChanged();
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
//取消按钮的点击事件
                        }
                    });

    }

        builder.show();
    }








    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"我发布的活动被长按");
        Intent valunteer= new Intent(this,ValunteerActivity.class);
        HashMap<String,String> map1= (HashMap<String, String>) getListView().getItemAtPosition(position);
        hdname=map1.get("name");
        Log.i(TAG,"haname"+hdname);
        valunteer.putExtra("hdname",hdname);
        valunteer.putExtra("orgname",org);
        startActivity(valunteer);
        return true;
    }


}

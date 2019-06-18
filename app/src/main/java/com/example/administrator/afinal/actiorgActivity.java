package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actiorgActivity extends ListActivity {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String TAG="activityshow";
    String username;
    String hdname;
    int[] image_expense = new int[]{R.mipmap.gaokaozy,R.mipmap.dongwuzy,R.mipmap.ertongzy,R.mipmap.jinglaozy,R.mipmap.malasongzy,
            R.mipmap.xueleifengzy,R.mipmap.saodizy,R.mipmap.yimaizy,R.mipmap.any};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_acti);

        HdItem item=new HdItem();



        getData();
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.actishow_item
                , new String[]{ "pic","name","yue","ri","shi","fen"}
                , new int[]{R.id.zyimage,R.id.et_name,R.id.yue,R.id.ri,R.id.shi,R.id.fen});

        getListView().setAdapter(adapter);






    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.listAll1( )) {
            Map<String, Object> map = new HashMap<>();
            boolean s0 = item.getHdname().contains("高考");
            boolean s1 = item.getHdname().contains("动物");
            boolean s2 = item.getHdname().contains("儿童");
            boolean s3 = item.getHdname().contains("敬老");
            boolean s4 = item.getHdname().contains("马拉松");
            boolean s5 = item.getHdname().contains("雷锋");
            boolean s6 = item.getHdname().contains("扫");
            boolean s7 = item.getHdname().contains("义卖");
            if(item.getHdname().contains("高考")){  map.put("pic", image_expense[0]); }
            else if(item.getHdname().contains("动物")){  map.put("pic", image_expense[1]); }
            else if(item.getHdname().contains("儿童")){  map.put("pic", image_expense[2]); }
            else if(item.getHdname().contains("敬老")){  map.put("pic", image_expense[3]); }
            else if(item.getHdname().contains("马拉松")){  map.put("pic", image_expense[4]); }
            else if(item.getHdname().contains("雷锋")){  map.put("pic", image_expense[5]); }
            else if(item.getHdname().contains("扫")){  map.put("pic", image_expense[6]); }
            else if(item.getHdname().contains("义卖")){  map.put("pic", image_expense[7]); }
            else{map.put("pic", image_expense[8]);}
            map.put("name", item.getHdname());
            map.put("yue", item.getHdyue());
            map.put("ri", item.getHdri());
            map.put("shi", item.getHdshi());
            map.put("fen", item.getHdfen());

            listitem.add(map);
        }
    }







}


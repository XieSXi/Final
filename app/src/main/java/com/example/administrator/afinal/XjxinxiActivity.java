package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XjxinxiActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String org;
    String hdname;
    String TAG = "xuejixinxi";
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xjxinxi);

        StuItem item = new StuItem();
        listview=(ListView) findViewById(R.id.list);
        getData();

        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.xjxinxi_item
                , new String[]{"xuehao", "xingming"}
                , new int[]{R.id.xuehao, R.id.xingming});


        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(this);
    }

    private void getData() {
        UserManager manager = new UserManager(this);
        for (StuItem item : manager.liststu()) {
            Map<String, Object> map = new HashMap<>();
            map.put("xuehao", item.getStuno());
            map.put("xingming", item.getStuname());

            listitem.add(map);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"学籍信息被长按");
        UserManager manager=new UserManager(this);
        HashMap<String,String> map1= (HashMap<String, String>) listview.getItemAtPosition(position);
        String xuehao=map1.get("xuehao");
        manager.deletexueji(xuehao);
        Toast.makeText(getApplicationContext(), "该学生信息已删除", Toast.LENGTH_SHORT).show();
        return true;
    }
}

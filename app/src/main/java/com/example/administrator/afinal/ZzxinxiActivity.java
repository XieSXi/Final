package com.example.administrator.afinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ZzxinxiActivity extends AppCompatActivity  implements AdapterView.OnItemLongClickListener{
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String TAG = "zuzhixinxi";
    ListView listview;
    SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xjxinxi);

        listview=(ListView) findViewById(R.id.list);
        getData();

       adapter = new SimpleAdapter(this
                , listitem
                , R.layout.xjxinxi_item
                , new String[]{"orgname", "orgpwd"}
                , new int[]{R.id.xuehao, R.id.xingming});

        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(this);
    }

    private void getData() {
        UserManager manager = new UserManager(this);
        for (OrgItem item : manager.listorg()) {
            Map<String, Object> map = new HashMap<>();
            map.put("orgname", item.getOrgname());
            map.put("orgpwd", item.getOrgpwd());

            listitem.add(map);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"组织信息被长按");
        UserManager manager=new UserManager(this);
        HashMap<String,String> map1= (HashMap<String, String>) listview.getItemAtPosition(position);
        String orgname=map1.get("orgname");
        manager.deletezuzhi(orgname);
        Toast.makeText(getApplicationContext(), "该组织信息已删除", Toast.LENGTH_SHORT).show();
        listitem.remove(position);
        adapter.notifyDataSetChanged();
        return true;
    }
}

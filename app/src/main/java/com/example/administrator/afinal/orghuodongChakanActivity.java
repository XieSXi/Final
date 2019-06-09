package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orghuodongChakanActivity extends ListActivity {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String org;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HdItem item=new HdItem();
        org=getSharedPreferences("orginfo", Context.MODE_PRIVATE).getString("orgname", "青协");
        getData();

        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.activity_orghuodong_chakan_item
                , new String[]{"id","org", "name", "time","content","place","requests","renshu","attention","train","pay",
                "yue","ri","shi","fen"}
                , new int[]{R.id.et_id,R.id.et_org,R.id.et_name, R.id.et_time, R.id.et_content,R.id.et_place, R.id.et_requests,R.id.et_renshu,
                R.id.et_attention, R.id.et_whethertrain,R.id.et_whetherpay,R.id.yue,R.id.ri,R.id.shi,R.id.fen});


        getListView().setAdapter(adapter);
    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.showByOrg( org)) {
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
}

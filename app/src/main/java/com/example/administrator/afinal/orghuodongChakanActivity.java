package com.example.administrator.afinal;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orghuodongChakanActivity extends ListActivity {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HdItem item=new HdItem();

        String[] expense_category = new String[] {"发工资", "买衣服"};
        Log.i("www",""+expense_category [1]);
        String[] expense_money = new String[] {"30000.00", "1500.00"};

        for (int i = 0; i < expense_category.length; i++)
        {
            Map<String, Object> map = new HashMap<>();
            map.put("expense_category", expense_category[i]);
            map.put("expense_money", expense_money[i]);
            listitem.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.fragment_one_item
                , new String[]{"id","org", "name", "time","content","place","requests","renshu","attention","train","pay",
                "yue","ri","shi","fen"}
                , new int[]{R.id.et_id,R.id.et_name, R.id.et_time, R.id.et_content,R.id.et_place, R.id.et_requests,R.id.et_renshu,
                R.id.et_attention, R.id.et_whethertrain,R.id.et_whetherpay,R.id.yue,R.id.ri,R.id.shi,R.id.fen});


        getListView().setAdapter(adapter);
    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.listAll1()) {
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

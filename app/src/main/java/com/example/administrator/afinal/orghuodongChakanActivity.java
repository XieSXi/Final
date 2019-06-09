package com.example.administrator.afinal;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class orghuodongChakanActivity extends ListActivity {
    List<Map<String, String>> listitem = new ArrayList<>(); //存储数据的数组列表
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HdItem item=new HdItem();

        String[] expense_category = new String[] {"发工资", "买衣服"};
        Log.i("www",""+expense_category [1]);
        String[] expense_money = new String[] {"30000.00", "1500.00"};

        for (int i = 0; i < expense_category.length; i++)
        {
            Map<String, String> map = new HashMap<>();
            map.put("expense_category", expense_category[i]);
            map.put("expense_money", expense_money[i]);
            listitem.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.fragment_one_item
                , new String[]{"expense_category", "expense_money"}
                , new int[]{R.id.tv_expense_category, R.id.tv_expense_money});


        getListView().setAdapter(adapter);
    }
}

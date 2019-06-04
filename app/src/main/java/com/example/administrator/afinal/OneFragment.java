package com.example.administrator.afinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class OneFragment extends Fragment {
    List<Map<String, String>> listitem = new ArrayList<>(); //存储数据的数组列表
    public OneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_one, container, false);
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
        SimpleAdapter adapter = new SimpleAdapter(getActivity()
                         , listitem
                         , R.layout.fragment_one_item
                         , new String[]{"expense_category", "expense_money"}
                         , new int[]{R.id.tv_expense_category, R.id.tv_expense_money});

        ListView listView = (ListView) v.findViewById(R.id.lv_one);
        listView.setAdapter(adapter);
        return v;

    }

}

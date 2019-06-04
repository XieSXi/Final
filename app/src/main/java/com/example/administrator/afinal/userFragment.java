package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class userFragment extends Fragment {
    List<Map<String, Object>> listitem = new ArrayList<Map<String, Object>>();
    int[] image_expense = new int[]{R.mipmap.userpic};

    public userFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_user, container, false);

        getData();

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listitem, R.layout.fragment_user_item
                , new String[]{"pic","stuno", "stuname", "username","userpwd","nianji","xueyuan","major","tel","email","hobby"}
                , new int[]{R.id.lv_pic,R.id.lv_stuno, R.id.lv_stuname, R.id.lv_username,R.id.lv_userpwd,R.id.lv_nianji,R.id.lv_xueyuan,R.id.lv_major,
                R.id.lv_tel,R.id.lv_email,R.id.lv_hobby});
        ListView listView = (ListView) v.findViewById(R.id.lv_user);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Map<String, Object> map = (Map<String, Object>) parent.getItemAtPosition(position);
                Toast.makeText(getActivity(), map.get("username").toString(), Toast.LENGTH_LONG).show();
            }

        });
        return v;
    }

    private void getData(){
        UserManager manager = new UserManager(getActivity());
        for (UserItem item : manager.listAll()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", image_expense[0]);
            map.put("stuno", item.getStuNo());
            map.put("stuname", item.getStuName());
            map.put("username", item.getUserName());
            map.put("userpwd", item.getUserPwd());
            map.put("nianji", item.getNianJi());
            map.put("xueyuan", item.getXueYuan());
            map.put("major", item.getMajor());
            map.put("tel", item.getTel());
            map.put("email", item.getEmail());
            map.put("hobby", item.getHobby());
            listitem.add(map);
    }
    }
}

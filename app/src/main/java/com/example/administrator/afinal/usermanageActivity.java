package com.example.administrator.afinal;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class usermanageActivity  extends ListActivity {
    String data[] = {"wait..."};
    String TAG = "userdatalist";
    private List<HashMap<String,String>> listItems;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_usermanage);
        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);

        //查询所有数据
        UserManager manager = new UserManager(this);
        List<UserItem> testlist = manager.listAll();

        for (UserItem i : testlist) {
            Log.i(TAG, "onOptionsItemSelected:取出数据[id=" + i.getId() + "]number=" + i.getStuNo() + " name=" + i.getStuName());
        }
        List<String> list = new ArrayList<String>();
        for (UserItem item : manager.listAll()) {
            list.add("学号：" + item.getStuNo() + "|" + "姓名：" + item.getStuName() + "|" + "用户名：" + item.getUserName() + "|" + "密码：*|" +
                    "年级：" + item.getNianJi() + "|" + "学院：" + item.getXueYuan() + "|" + "专业：" + item.getMajor() + "|" + "手机号：" + item.getTel() + "|" +
                    "邮箱：" + item.getEmail() + "|");
            Log.i("run", "用户名" + item.getUserName());
        }
        ListAdapter adapter1 = new ArrayAdapter<String>(usermanageActivity.this, android.R.layout.simple_list_item_1, list);
        setListAdapter(adapter1);


    }
}

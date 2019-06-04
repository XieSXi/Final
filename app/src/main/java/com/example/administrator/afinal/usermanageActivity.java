package com.example.administrator.afinal;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

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

        //测试数据库
        UserItem item1 = new UserItem("aaa", "123", "1", "1", "1", "1", "1", "1", "1","1");
        UserManager manager = new UserManager(this);
        manager.add(item1);
        manager.add(new UserItem("aaa", "123", "1", "1", "1", "1", "1", "1", "2","敬老"));

        Log.i(TAG, "写入数据完毕");

        //查询所有数据
        List<UserItem> testlist = manager.listAll();

        for (UserItem i : testlist) {
            Log.i(TAG, "onOptionsItemSelected:取出数据[id=" + i.getId() + "]number=" + i.getStuNo() + " name=" + i.getStuName());
        }
//        List<String> list = new ArrayList<String>();
//        UserManager manager = new UserManager(this);
//        for (UserItem item : manager.listAll()) {
//            list.add("学号：" + item.getStuNo() + "|" + "姓名：" + item.getStuName() + "|" + "用户名：" + item.getUserName() + "|" + "密码：*|" +
//                    "年级：" + item.getNianJi() + "|" + "学院：" + item.getXueYuan() + "|" + "专业：" + item.getMajor() + "|" + "手机号：" + item.getTel() + "|" +
//                    "邮箱：" + item.getEmail() + "|");
//            Log.i("run", "用户名" + item.getUserName());
//        }
//        ListAdapter adapter1 = new ArrayAdapter<String>(usermanageActivity.this, android.R.layout.simple_list_item_1, list);
//        setListAdapter(adapter1);


    }
}

package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class actiActivity extends ListActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
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

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        username=bundle.getString("user_key");
        Log.i(TAG,"当前登录的用户为"+username);


        getData();
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.actishow_item
                , new String[]{ "pic","name","yue","ri","shi","fen"}
                , new int[]{R.id.zyimage,R.id.et_name,R.id.yue,R.id.ri,R.id.shi,R.id.fen});

        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);





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
            if(s0){  map.put("pic", image_expense[0]); }
            if(s1){  map.put("pic", image_expense[1]); }
            if(s2){  map.put("pic", image_expense[2]); }
            if(s3){  map.put("pic", image_expense[3]); }
            if(s4){  map.put("pic", image_expense[4]); }
            if(s5){  map.put("pic", image_expense[5]); }
            if(s6){  map.put("pic", image_expense[6]); }
            if(s7){  map.put("pic", image_expense[7]); }
            else{map.put("pic", image_expense[8]);}
            map.put("name", item.getHdname());
            map.put("yue", item.getHdyue());
            map.put("ri", item.getHdri());
            map.put("shi", item.getHdshi());
            map.put("fen", item.getHdfen());

            listitem.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"OnItemClick: partent=" +parent);
        Log.i(TAG,"OnItemClick: view=" +view);
        Log.i(TAG,"OnItemClick: position=" +position);
        Log.i(TAG,"OnItemClick: id=" +id);
        HashMap<String,String> map1= (HashMap<String, String>) getListView().getItemAtPosition(position);
        hdname=map1.get("name");
        Log.i(TAG,"OnItemClick: hdname=" +hdname);

        //打开活动详情页面，传入参数
        Intent xiangqing= new Intent(this,XiangqingActivity.class);
        xiangqing.putExtra("username",username);
        xiangqing.putExtra("hdname",hdname);
        startActivity(xiangqing);
    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        UserManager userManager = new UserManager(actiActivity.this);
        userManager.add5(new AttendItem(hdname,username));
        Log.i(TAG, "数据已写入attend数据库");
        Toast.makeText(getApplicationContext(), "报名成功，可前往我的志愿活动查看", Toast.LENGTH_SHORT).show();
        return true;//长按操作时屏蔽短按操作  之前放在第一排居然会报错！
    }
}


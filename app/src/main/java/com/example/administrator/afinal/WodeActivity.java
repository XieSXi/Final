package com.example.administrator.afinal;

import android.app.ListActivity;
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

public class WodeActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String TAG="activityshow";
    String username;
    String hdname;
    String judge;
    ListView listview;
    int[] image_expense = new int[]{R.mipmap.gaokaozy,R.mipmap.dongwuzy,R.mipmap.ertongzy,R.mipmap.jinglaozy,R.mipmap.malasongzy,
            R.mipmap.xueleifengzy,R.mipmap.saodizy,R.mipmap.yimaizy,R.mipmap.any};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wode);

        HdItem item=new HdItem();

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        username=bundle.getString("user_key");
        Log.i(TAG,"当前登录的用户为"+username);

        listview=(ListView) findViewById(R.id.wdzy);

        getData();
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.wdzyitem
                , new String[]{ "hdname","judge"}
                , new int[]{R.id.ming,R.id.yourjudge});

        listview.setAdapter(adapter);
        listview.setOnItemLongClickListener(this);





    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (AttendItem item : manager.showByUsername1(username)) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("hdname", item.getHdname());
            map.put("username", item.getUsername());
            map.put("judge", item.getJudge());
            listitem.add(map);




        }
    }




    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        UserManager userManager = new UserManager(WodeActivity.this);
        HashMap<String,String> map1= (HashMap<String, String>) listview.getItemAtPosition(position);
        hdname=map1.get("hdname");
        judge=map1.get("judge");
        Log.i(TAG,"OnItemLongClick" +username+hdname+judge);
        if(judge==null){
            judge="未评价";
        }



        if(judge.equals("优秀")||judge.equals("良好")){
            Intent intent= new Intent(getApplicationContext(),ZhengshuActivity.class);//打开另一个Activity
            Bundle bundle1 = new Bundle();
            bundle1.putString("username",username);
            bundle1.putString("hdname",hdname);
            bundle1.putString("judge",judge);
            intent.putExtras(bundle1);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "将为您生成此次活动的志愿证书", Toast.LENGTH_SHORT).show();
        }
        else if(judge.equals("缺席")){
            Toast.makeText(getApplicationContext(), "很抱歉，您未完成此次志愿活动", Toast.LENGTH_SHORT).show();
        }
        else if(judge.equals("未评价")){
            Log.i(TAG,"judge为空");
            Toast.makeText(getApplicationContext(), "很抱歉，组织管理员还未对此次志愿活动进行评价", Toast.LENGTH_SHORT).show();
        }


        return true;//长按操作时屏蔽短按操作  之前放在第一排居然会报错！
    }




}



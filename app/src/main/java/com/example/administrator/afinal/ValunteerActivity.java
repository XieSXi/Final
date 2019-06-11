package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValunteerActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener  {
//    Button btn;
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String hdname;String org;String username;
    TextView mingchen;
    GridView gridView;
    String valunteername;
    String TAG="valunteerlist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valunteer);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        hdname=bundle.getString("hdname");
        org=bundle.getString("orgname");
        mingchen=(TextView) findViewById(R.id.huodongming);
        mingchen.setText(hdname);

        getData();

        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.valunteer_item
                , new String[]{"username"}
                , new int[]{R.id.valunteeruname});

        gridView=(GridView) findViewById(R.id.gridlist);
        gridView.setAdapter(adapter);
        gridView.setOnItemLongClickListener(this);


//        btn=(Button)findViewById(R.id.button);
//
//       btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("trytry","拨号被点击");
//                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:15057102670"));
//               startActivity(intent);
//            }
//
//
//        });



    }

    private void getData(){
        UserManager manager = new UserManager(this);
        for (AttendItem item : manager.showByHdname1(hdname)) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", item.getId());
            map.put("hdname", item.getHdname());
            map.put("username", item.getUsername());
            listitem.add(map);




        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"志愿者被长按");
        Log.i(TAG,"OnItemClick: partent=" +parent);
        Log.i(TAG,"OnItemClick: view=" +view);
        Log.i(TAG,"OnItemClick: position=" +position);
        Log.i(TAG,"OnItemClick: id=" +id);
        Intent valunteer= new Intent(this,ValunteerJudgeActivity.class);
        HashMap<String,String> map1= (HashMap<String, String>)gridView.getItemAtPosition(position);
        username=map1.get("username");
        Log.i(TAG,"username:   "+username);
        valunteer.putExtra("username",username);
        valunteer.putExtra("hdname",hdname);
        startActivity(valunteer);
        return true;
    }



}

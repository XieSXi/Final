package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValunteerActivity extends AppCompatActivity {
//    Button btn;
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String hdname;String org;
    TextView mingchen;
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

        GridView gridView=(GridView) findViewById(R.id.gridlist);
        gridView.setAdapter(adapter);


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



}

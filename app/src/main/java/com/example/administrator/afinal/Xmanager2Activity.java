package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Xmanager2Activity extends AppCompatActivity {

    String TAG="xitongmanager";
    Button xuejixinxi;
    Button zuzhixinxi;
    Button zuzhiluru;
    Button xuejiluru;
    Button shujumanage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xmanager2);
        xuejixinxi=(Button)findViewById(R.id.xinjixinxi);
        xuejixinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "学籍信息按钮被点击");
                Intent intent= new Intent(getApplicationContext(),XjxinxiActivity.class);//打开另一个Activity
                startActivity(intent);

            }
        });
        zuzhixinxi=(Button)findViewById(R.id.zuzhixinxi);
        zuzhixinxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "组织信息按钮被点击");
                Intent intent= new Intent(getApplicationContext(),ZzxinxiActivity.class);//打开另一个Activity
                startActivity(intent);

            }
        });

        zuzhiluru=(Button)findViewById(R.id.zuzhiluru);
        zuzhiluru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "组织录入按钮被点击");
                Intent intent= new Intent(getApplicationContext(),XjluruActivity.class);//打开另一个Activity
                startActivity(intent);
            }
        });

        xuejiluru=(Button)findViewById(R.id.xuejiluru);
        xuejiluru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "学籍录入按钮被点击");
                Intent intent= new Intent(getApplicationContext(),XjluruActivity.class);//打开另一个Activity
                startActivity(intent);
            }
        });

        shujumanage=(Button)findViewById(R.id.shujumanage);
        shujumanage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "数据管理按钮被点击");
                Intent intent= new Intent(getApplicationContext(),DatamanageActivity.class);//打开另一个Activity
                startActivity(intent);
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tuichu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_tlogin){
            Intent config= new Intent(this,LoginActivity.class);//打开另一个Activity
            startActivity(config);
        }
        return super.onOptionsItemSelected(item);
    }


}

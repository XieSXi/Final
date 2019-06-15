package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class UserwelcomeActivity extends AppCompatActivity {
    Button liulanbtn;
    Button zhinengbtn;
    Button wodebtn;
    Button morebtn;
    String username;
    String TAG="userwelcome";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userwelcome);

        liulanbtn=(Button)findViewById(R.id.liulan);
        zhinengbtn=(Button)findViewById(R.id.zhinengtuijian);
        wodebtn=(Button)findViewById(R.id.wodezy);
        morebtn=(Button)findViewById(R.id.sousuo);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        username=bundle.getString("user_key");
        Log.i(TAG,"当前登录的用户为"+username);


        liulanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "活动浏览按钮被点击");
                Intent intent= new Intent(getApplicationContext(),actiActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                bundle1.putString("user_key",username);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        zhinengbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "智能推荐按钮被点击");
                Intent intent= new Intent(getApplicationContext(),TuijianActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                bundle1.putString("user_key",username);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        wodebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "我的志愿按钮被点击");
                Intent intent= new Intent(getApplicationContext(),WodeActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                bundle1.putString("user_key",username);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
        morebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "更多了解按钮被点击");
                Intent intent= new Intent(getApplicationContext(),MoreActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                bundle1.putString("user_key",username);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });
    }
}

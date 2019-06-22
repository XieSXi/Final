package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SuoActivity extends AppCompatActivity {

    String username;String content;
    EditText sousuo;Button tijiao;
    String TAG="sousuo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suo);

        SharedPreferences mySharedPreferences= getSharedPreferences("userinfo",Activity.MODE_PRIVATE);
        username=mySharedPreferences.getString("username","");
        sousuo=(EditText)findViewById(R.id.sousuokuang);
        tijiao=(Button)findViewById(R.id.tijiao);
        content=sousuo.getText().toString().trim();
        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),XiangqingActivity.class);//打开另一个Activity
                Bundle bundle = new Bundle();
                bundle.putString("username",username);
                bundle.putString("hdname",content);
                Log.i(TAG,""+username+content);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

    }
}

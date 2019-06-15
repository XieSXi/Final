package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TryActivity extends AppCompatActivity {

    String TAG="shujucaozuo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try);

        UserManager manager=new UserManager(this);

//        manager.deleteAll2();
//        Log.i(TAG,"tb_students一删除数据");
//        manager.deleteAll1();
//        Log.i(TAG,"tb_users一删除数据");
//        manager.deleteAll3();
//        Log.i(TAG,"tb_organization一删除数据");
//        manager.deleteAll6();
//        Log.i(TAG,"tb_acti一删除数据");
        manager.deleteAll7();
        Log.i(TAG,"tb_attend一删除数据");

    }
}

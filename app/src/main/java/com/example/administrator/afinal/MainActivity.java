package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String organization1;
    String TAG="main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        organization1=bundle.getString("orgname_key",null);
        Log.i(TAG,""+organization1);

        Bundle bundle1 = new Bundle();
        bundle1.putString("org",organization1);
        issueHuodongFragment myfrg=new issueHuodongFragment();
        myfrg.setArguments(bundle1);

    }
}

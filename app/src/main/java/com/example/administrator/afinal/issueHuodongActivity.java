package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class issueHuodongActivity extends AppCompatActivity {
    String orgname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_huodong);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        orgname=bundle.getString("orgname_key");




    }
}

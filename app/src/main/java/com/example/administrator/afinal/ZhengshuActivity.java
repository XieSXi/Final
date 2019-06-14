package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ZhengshuActivity extends AppCompatActivity {

    String username;String vname;
    String hdname;String vtime;
    String judge;String org;
    String TAG="zhengshu";
    UserItem userItem;HdItem hdItem;AttendItem attendItem;
    TextView vname1;TextView vtime1;TextView vjudge1;TextView vorg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhengshu);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        username=bundle.getString("username");
        hdname=bundle.getString("hdname");
        judge=bundle.getString("judge");
        Log.i(TAG,"该证书的username,hdname,judge分别是"+username+hdname+judge);
        UserManager manager=new UserManager(this);
        userItem=manager.findByUsename(username);
        vname=userItem.getStuName();
        hdItem=manager.findorgtimeByhdname(hdname);
        org=hdItem.getHdorg();
        vtime=hdItem.getHdtime();
//        attendItem=manager.findjudgeBy(username,hdname);
//        judge=attendItem.getJudge();
        vname1=(TextView)findViewById(R.id.vname);
        vtime1=(TextView)findViewById(R.id.vtime);
        vjudge1=(TextView)findViewById(R.id.vjudge);
        vorg1=(TextView)findViewById(R.id.vorg);
        vname1.setText(vname);
        vtime1.setText(vtime);
        vjudge1.setText(judge);
        vorg1.setText(org);




    }
}

package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DatamanageActivity extends AppCompatActivity {

    TextView userscount;
    TextView orgscount;
    TextView hdscount;
    TextView attendscount;
    String TAG="datamanage";
    Long a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datamanage);
        UserManager manager=new UserManager(this);

        userscount=(TextView)findViewById(R.id.userscount);
        a=manager.userscount();
        String aa=String.valueOf(a);
        userscount.setText(aa);

        orgscount=(TextView)findViewById(R.id.orgscount);
        b=manager.orgscount();
        Log.i(TAG,"组织数为"+b);
        String bb=String.valueOf(b);
        orgscount.setText(bb);

        hdscount=(TextView)findViewById(R.id.hdscount);
        c=manager.hdscount();
        Log.i(TAG,"活动数为"+c);
        String cc=String.valueOf(c);
        hdscount.setText(cc);

        attendscount=(TextView)findViewById(R.id.attendscount);
        d=manager.attendscount();
        Log.i(TAG,"参加数为"+d);
        String dd=String.valueOf(d);
        attendscount.setText(dd);


    }
}

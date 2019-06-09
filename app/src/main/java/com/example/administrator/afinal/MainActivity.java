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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView org;
    private  Button enter;
    String organization1;
    String TAG="main";
    ;
   ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        org=(TextView)findViewById(R.id.orgname);
        enter=(Button)findViewById(R.id.enterbutton);

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        organization1=bundle.getString("orgname_key",null);
        Log.i(TAG,""+organization1);
        org.setText(organization1);


//        Bundle bundle1 = new Bundle();
//        bundle1.putString("org",organization1);
//        issueHuodongFragment myfrg=new issueHuodongFragment();
//        myfrg.setArguments(bundle1);


        SharedPreferences mySharedPreferences= getSharedPreferences("orginfo",Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = mySharedPreferences.edit();
        editor.putString("orgname", organization1 );
        editor.commit();

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "进入按钮被点击");
                SharedPreferences mySharedPreferences= getSharedPreferences("orginfo",Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("orgname", organization1 );
                editor.commit();
                Intent intent= new Intent(getApplicationContext(),OrganizationActivity.class);//打开另一个Activity
                startActivity(intent);

            }
        });

    }
}

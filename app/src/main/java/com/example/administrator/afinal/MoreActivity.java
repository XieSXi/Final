package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MoreActivity extends AppCompatActivity {

    Button weabtn;Button sousuo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);

        weabtn=(Button)findViewById(R.id.weatherbtn);
        sousuo=(Button)findViewById(R.id.sousuobtn);
        weabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),WeatherActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                startActivity(intent);

            }
        });
        sousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),SuoActivity.class);//打开另一个Activity
                Bundle bundle1 = new Bundle();
                startActivity(intent);

            }
        });
    }
}

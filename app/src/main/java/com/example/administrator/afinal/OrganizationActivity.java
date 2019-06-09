package com.example.administrator.afinal;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class OrganizationActivity extends AppCompatActivity {
    String TAG="org";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization);

        ViewPager viewPager  =(ViewPager)findViewById(R.id.orgviewpager);
        ManagePageAdapter pageAdapter =new ManagePageAdapter(getSupportFragmentManager());
        viewPager .setAdapter(pageAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.orgsliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


//        final Bundle bundle=getIntent().getExtras();    //接收Extras
//        organization1=bundle.getString("orgname_key",null);
//        Log.i(TAG,""+organization1);





//        Bundle args = new Bundle();
//        args.putString("org",organization1);
//        issueHuodongFragment myfrg=new issueHuodongFragment();
//        myfrg.setArguments(args);

        ;





    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.otherorg,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_huodong){
            Intent config= new Intent(this,orghuodongChakanActivity.class);//打开另一个Activity
            startActivity(config);
        }
        else if(item.getItemId()==R.id.menu_volunteer){

            Intent list= new Intent(this,MainActivity.class);//打开另一个Activity
            startActivity(list);





        }
        return super.onOptionsItemSelected(item);
    }
}

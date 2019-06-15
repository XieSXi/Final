package com.example.administrator.afinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class XjluruActivity extends AppCompatActivity {

    private Button xjbtn;
    private Button zzbtn;
    private EditText lurusuono;
    private  EditText lurusuona;
    private  EditText luruorgname;
    private EditText luruorgpwd;
    private String TAG="luru";
    private String stuno,stuna,orgna,orgpw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xjluru);
        xjbtn=(Button)findViewById(R.id.xlurubtn);
        zzbtn=(Button)findViewById(R.id.zlurubtn);
        lurusuono=(EditText)findViewById(R.id.lurustuno);
        lurusuona=(EditText)findViewById(R.id.lurustuna);
        luruorgname=(EditText)findViewById(R.id.luruorgname);
        luruorgpwd=(EditText)findViewById(R.id.luruorgpwd);

//        stuno=lurusuono.getText().toString().trim();
//        stuna=lurusuona.getText().toString().trim();
//
//        orgna=luruorgname.getText().toString().trim();
//        orgpw=luruorgpwd.getText().toString().trim();             !!!!注意！很容易出错，之前一直把这几行代码放在这里的，但这里是程序开始就运行了的，那个时候还没有输入呢，自然是空的



        xjbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stuno=lurusuono.getText().toString().trim();
                stuna=lurusuona.getText().toString().trim();
                Log.i(TAG, "学籍录入按钮被点击"+stuno+stuna);
                if(stuno.length()!=0&&stuna.length()!=0){
                    UserManager manager=new UserManager(getApplicationContext());
                    manager.luruxj(new StuItem(stuno,stuna));
                    Log.i(TAG, "学籍录入已写入数据库");
                    Toast.makeText(getApplicationContext(), "学籍已录入", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "录入不得为空", Toast.LENGTH_SHORT).show();
                }

            }
        });
        zzbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orgna=luruorgname.getText().toString().trim();
                orgpw=luruorgpwd.getText().toString().trim();
                Log.i(TAG, "组织录入按钮被点击"+orgna+orgpw);
                if(orgna.length()!=0&&orgpw.length()!=0) {
                    UserManager manager = new UserManager(getApplicationContext());
                    manager.luruzz(new OrgItem(orgna, orgpw));
                    Log.i(TAG, "组织录入已写入数据库");
                    Toast.makeText(getApplicationContext(), "组织已录入", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "录入不得为空", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
}

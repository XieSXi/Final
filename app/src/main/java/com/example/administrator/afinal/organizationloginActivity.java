package com.example.administrator.afinal;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class organizationloginActivity extends AppCompatActivity {
    private Button loginbtn;
    private EditText orgname;
    private EditText orgpwd;
    private TextView state;
    public String TAG="managelogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_managelogin);

        loginbtn= (Button) findViewById(R.id.loginButton);
        orgname= (EditText) findViewById(R.id.et_loginactivity_username);
        orgpwd= (EditText) findViewById(R.id.et_loginactivity_password);
        state= (TextView) findViewById(R.id.state);
        Log.i(TAG,"已获取所有控件");



    }
}


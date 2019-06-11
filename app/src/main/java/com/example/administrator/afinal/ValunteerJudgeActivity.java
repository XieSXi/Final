package com.example.administrator.afinal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ValunteerJudgeActivity extends AppCompatActivity {

    private Button judgebtn;
    private Button callbtn;
    private TextView vuserna;
    private TextView vstuna;
    private TextView vstuno;
    private TextView vnianji;
    private TextView vxueyuan;
    private TextView vzhuanye;
    private TextView vtel;
    private TextView vemail;
    private Spinner vjudge;


    public String TAG = "valunteerjudge";
    String vuserna1;
    String vstuna1;
    String vstuno1;
    String vnianji1;
    String vxueyuan1;
    String vzhuanye1;
    String vtel1;
    String vemail1;
    String vjudge1;

    String username,hdname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valunteer_judge);

        final Bundle bundle = getIntent().getExtras();    //接收Extras
        username = bundle.getString("username");
        hdname = bundle.getString("hdname");
        UserManager manager = new UserManager(this);
        UserItem item = manager.showByUsername(username);


        judgebtn = (Button) findViewById(R.id.judgeok);
        callbtn = (Button) findViewById(R.id.call);
        vuserna = (TextView) findViewById(R.id.vusername);
        vstuno = (TextView) findViewById(R.id.vstuno);
        vstuna = (TextView) findViewById(R.id.vstuname);
        vnianji = (TextView) findViewById(R.id.vnianji);
        vxueyuan = (TextView) findViewById(R.id.vxueyuan);
        vzhuanye = (TextView) findViewById(R.id.vzhuanye);
        vtel = (TextView) findViewById(R.id.vtel);
        vemail = (TextView) findViewById(R.id.vemail);
        vjudge = (Spinner) findViewById(R.id.vjudge);

        vuserna.setText(username);
        vstuno.setText(item.getStuNo());
        vstuna.setText(item.getStuName());
        vnianji.setText(item.getNianJi());
        vxueyuan.setText(item.getXueYuan());
        vzhuanye.setText(item.getMajor());
        vtel.setText(item.getTel());
        vemail.setText(item.getEmail());

        vtel1=item.getTel();
        vjudge1 = vjudge.getSelectedItem().toString();


        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("trytry", "拨号被点击");
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+vtel1));
                startActivity(intent);
            }
        });



        judgebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               UserManager usermanager=new UserManager(getApplication());
               usermanager.updateAttend(hdname,username,vjudge1);
               Log.i(TAG,"评价已提交");
               Toast.makeText(getApplicationContext(), "评价已提交", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

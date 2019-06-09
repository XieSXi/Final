package com.example.administrator.afinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class issueHuodongFragment extends Fragment {
    List<Map<String, String>> listitem = new ArrayList<>(); //存储数据的数组列表
    private Button issuebtn;
    private EditText hdname;
    private EditText hdtime;
    private EditText hdcontent;
    private EditText hdplace;
    private EditText hdrequests;
    private EditText hdrenshu;
    private EditText hdattention;
    private EditText hdtrain;
    private EditText hdpay;

    private Spinner hdyue;
    private Spinner hdri;
    private Spinner hdshi;
    private Spinner hdfen;

    private TextView state;
    public String TAG="issuehuodong";
    String hdorg1,hdname1,hdtime1,hdcontent1,hdplace1,hdrequests1,hdrenshu1,hdattention1,hdtrain1,hdpay1,hdyue1,hdri1,hdshi1,hdfen1;


    public issueHuodongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_issue_huodong, container, false);
        issuebtn =(Button)v.findViewById(R.id.issueButton);
        hdname=(EditText) v.findViewById(R.id.et_huodongname);
        hdcontent=(EditText) v.findViewById(R.id.et_huodongcontent);
        hdtime=(EditText) v.findViewById(R.id.et_huodongtime);
        hdplace=(EditText) v.findViewById(R.id.et_huodongplace);
        hdattention=(EditText) v.findViewById(R.id.et_attention);
        hdrequests=(EditText) v.findViewById(R.id.et_baomingrequests);
        hdrenshu=(EditText) v.findViewById(R.id.et_renshurequests);
        hdtrain=(EditText) v.findViewById(R.id.et_whethertrain);
        hdpay=(EditText) v.findViewById(R.id.et_whetherpay);

        hdyue=(Spinner) v.findViewById(R.id.time1yue);
        hdri=(Spinner) v.findViewById(R.id.time1ri);
        hdfen= (Spinner) v.findViewById(R.id.time1fen);
        hdshi=(Spinner) v.findViewById(R.id.time1shi);
        state=(TextView)v.findViewById(R.id.state);

        hdorg1=getArguments().getString("org");
//        hdorg1="青协";


        issuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "发布按钮被点击");

                hdname1=hdname.getText().toString().trim();
                hdtime1=hdtime.getText().toString().trim();
                hdcontent1=hdcontent.getText().toString().trim();
                hdplace1=hdplace.getText().toString().trim();
                hdrequests1=hdrequests.getText().toString().trim();
                hdrenshu1=hdrenshu.getText().toString().trim();
                hdattention1=hdattention.getText().toString().trim();
                hdtrain1=hdtrain.getText().toString().trim();
                hdpay1=hdpay.getText().toString().trim();
                hdyue1=hdyue.getSelectedItem().toString();
                hdri1=hdri.getSelectedItem().toString();
                hdshi1=hdshi.getSelectedItem().toString();
                hdfen1=hdfen.getSelectedItem().toString();

                Log.i(TAG, "活动名称：" + hdname1+ "活动组织：" + hdorg1);

                if (hdname1.length()>0 && hdtime1.length()>0&& hdcontent1.length()>0&&hdplace1.length()>0&&hdrequests1.length()>0
                        &&hdrenshu1.length()>0&&hdattention1.length()>0&&hdtrain1.length()>0&&hdpay1.length()>0
                        &&hdyue1.length()>0&&hdri1.length()>0&&hdshi1.length()>0&&hdfen1.length()>0&&hdorg1.length()>0) {
                    //把数据写入数据库中
                    UserManager manager =new UserManager(getActivity());
                    manager.add4(new HdItem(hdorg1,hdname1,hdtime1,hdcontent1,hdplace1,hdrequests1,hdrenshu1,hdattention1,hdtrain1,hdpay1,hdyue1,hdri1,hdshi1,hdfen1));
                    Log.i(TAG,"该活动数据已写入数据库");
                    state.setText("志愿活动发布成功！你的活动ID为"+manager.findidByhdname(hdname1).getId());
                }
                else{
                    state.setText("每一项均为必填项");
                }
            }
        });






        return v;
    }

}

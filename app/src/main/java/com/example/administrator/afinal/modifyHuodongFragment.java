package com.example.administrator.afinal;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class modifyHuodongFragment extends Fragment {

    private Button modbtn;
    private EditText hdid;
    private EditText modcontent;
    private String org;

    private Spinner modselect;

    private TextView modstate;
    public String TAG="modifyhuodong";
    String hdid1,modcontent1, modselect1;


    public modifyHuodongFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_modify_huodong ,container, false);
        modbtn =(Button)v.findViewById(R.id.modifyButton);
        hdid=(EditText) v.findViewById(R.id.et_id);
        modcontent=(EditText) v.findViewById(R.id.et_modifycontent);

        modselect=(Spinner) v.findViewById(R.id.select);
        modstate=(TextView)v.findViewById(R.id.state);

        org=getActivity().getSharedPreferences("orginfo", Context.MODE_PRIVATE).getString("orgname", "青协");


        modbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "提交按钮被点击");

                hdid1 = hdid.getText().toString().trim();
                modcontent1 = modcontent.getText().toString().trim();
                modselect1 = modselect.getSelectedItem().toString();

                Log.i(TAG, org+"正在做修改   需要修改的活动ID：" + hdid1 + "修改项：" + modselect1);
                UserManager manager = new UserManager(getActivity());
                HdItem item1 = manager.findById(hdid1);
                if (hdid1.length() > 0 && modcontent1.length() > 0 && modselect1.length() > 0) {
                    //更新数据
                    int result = manager.yanzhengID(hdid1,org);
                    if (result == 0) {
                        modstate.setText("找不到这个活动ID！");
                    }
                    else if(result==-1){
                        modstate.setText("此活动与您无关！无权修改");
                    }
                    else if (result == 1) {
                        if (modselect1.equals("活动名称")) {
                            item1.setHdname(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("活动时间")) {
                            item1.setHdtime(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("活动内容")) {
                            item1.setHdcontent(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("活动地点")) {
                            item1.setHdplace(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("报名要求")) {
                            item1.setHdrequests(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("人数要求")) {
                            item1.setHdrenshu(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("是否培训")) {
                            item1.setHdtrain(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }
                        if (modselect1.equals("是否有偿")) {
                            item1.setHdpay(modcontent1);
                            manager.updateHd(item1);
                            Log.i(TAG, "该活动修改已写入数据库");
                            modstate.setText("活动信息修改成功!");
                        }

                    }
                } else {
                    modstate.setText("请填写每一项后再提交");
                }
            }

            });







        return v;


    }


    }



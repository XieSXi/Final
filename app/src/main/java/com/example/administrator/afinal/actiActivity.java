package com.example.administrator.afinal;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class actiActivity extends ListActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
    List<Map<String, Object>> listitem = new ArrayList<>(); //存储数据的数组列表
    String TAG="activityshow";
    String username;
    String hdname;
    String yue,ri,shi,fen;
    int[] image_expense = new int[]{R.mipmap.gaokaozy,R.mipmap.dongwuzy,R.mipmap.ertongzy,R.mipmap.jinglaozy,R.mipmap.malasongzy,
            R.mipmap.xueleifengzy,R.mipmap.saodizy,R.mipmap.yimaizy,R.mipmap.any};
    int aa=0,bb=0,cc=0,dd=0;
    int yue3,ri3,shi3,fen3,mMonth,mDay,mHour,mMinute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_acti);

        HdItem item=new HdItem();

        final Bundle bundle=getIntent().getExtras();    //接收Extras
        username=bundle.getString("user_key");
        Log.i(TAG,"当前登录的用户为"+username);


        getData();
        SimpleAdapter adapter = new SimpleAdapter(this
                , listitem
                , R.layout.actishow_item
                , new String[]{ "pic","name","yue","ri","shi","fen"}
                , new int[]{R.id.zyimage,R.id.et_name,R.id.yue,R.id.ri,R.id.shi,R.id.fen});

        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);





    }


    private void getData(){
        UserManager manager = new UserManager(this);
        for (HdItem item : manager.listAll1( )) {
            Map<String, Object> map = new HashMap<>();
            boolean s0 = item.getHdname().contains("高考");
            boolean s1 = item.getHdname().contains("动物");
            boolean s2 = item.getHdname().contains("儿童");
            boolean s3 = item.getHdname().contains("敬老");
            boolean s4 = item.getHdname().contains("马拉松");
            boolean s5 = item.getHdname().contains("雷锋");
            boolean s6 = item.getHdname().contains("扫");
            boolean s7 = item.getHdname().contains("义卖");
            if(item.getHdname().contains("高考")){  map.put("pic", image_expense[0]); }
            else if(item.getHdname().contains("动物")){  map.put("pic", image_expense[1]); }
            else if(item.getHdname().contains("儿童")){  map.put("pic", image_expense[2]); }
            else if(item.getHdname().contains("敬老")){  map.put("pic", image_expense[3]); }
            else if(item.getHdname().contains("马拉松")){  map.put("pic", image_expense[4]); }
            else if(item.getHdname().contains("雷锋")){  map.put("pic", image_expense[5]); }
            else if(item.getHdname().contains("扫")){  map.put("pic", image_expense[6]); }
            else if(item.getHdname().contains("义卖")){  map.put("pic", image_expense[7]); }
            else{map.put("pic", image_expense[8]);}
            map.put("name", item.getHdname());
            map.put("yue", item.getHdyue());
            map.put("ri", item.getHdri());
            map.put("shi", item.getHdshi());
            map.put("fen", item.getHdfen());

            listitem.add(map);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"OnItemClick: partent=" +parent);
        Log.i(TAG,"OnItemClick: view=" +view);
        Log.i(TAG,"OnItemClick: position=" +position);
        Log.i(TAG,"OnItemClick: id=" +id);
        HashMap<String,String> map1= (HashMap<String, String>) getListView().getItemAtPosition(position);
        hdname=map1.get("name");
        yue=map1.get("yue");ri=map1.get("ri");shi=map1.get("shi");fen=map1.get("fen");
        Log.i(TAG,"从map中取到的月日时分"+yue+ri+shi+fen);

//验证报名时间是否截止
        String regEx="[^0-9]";Pattern p = Pattern.compile(regEx);
        Matcher yue1 = p.matcher(yue);String yue2=yue1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        Matcher ri1 = p.matcher(ri);String ri2=ri1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        Matcher shi1 = p.matcher(shi);String shi2=shi1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        Matcher fen1 = p.matcher(fen);String fen2=fen1.replaceAll("").trim();//通过正则表达式获得了字符串中的数字
        yue3 = Integer.parseInt(yue2);ri3 = Integer.parseInt(ri2);
        shi3 = Integer.parseInt(shi2);fen3 = Integer.parseInt(fen2);
        Calendar c = Calendar.getInstance();
        mMonth = c.get(Calendar.MONTH) + 1;// 获取当前月份
        mDay = c.get(Calendar.DAY_OF_MONTH);// 获取当日期
        mHour = c.get(Calendar.HOUR_OF_DAY);//时
        mMinute = c.get(Calendar.MINUTE);//分
        Log.i(TAG,""+mMonth+mDay+mHour+mMinute);
        Log.i(TAG,"OnItemClick: hdname=" +hdname+"月："+yue3+";日："+ri3+";时："+shi3+";分："+fen3);
        if(yue3<mMonth){
            Toast.makeText(getApplicationContext(), "该志愿活动报名时间已截止!", Toast.LENGTH_SHORT).show();
        }
        else if(yue3==mMonth){
            if(ri3<mDay){
                Toast.makeText(getApplicationContext(), "该志愿活动报名时间已截止!", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"我在这1");
            }
            else if(ri3==mDay){
                if(shi3<mHour){
                    Toast.makeText(getApplicationContext(), "该志愿活动报名时间已截止!", Toast.LENGTH_SHORT).show();
                    Log.i(TAG,"我在这6");
                }
                else if(shi3==mHour){
                    if(fen3<mMinute){
                        Toast.makeText(getApplicationContext(), "该志愿活动报名时间已截止!", Toast.LENGTH_SHORT).show();
                        Log.i(TAG,"我在这7");
                    }
                    else {
                        openxiangqing();aa=1;Log.i(TAG,"我在这2");
                    }

                }
                else{
                    openxiangqing();bb=1;Log.i(TAG,"我在这3");
                }

            }
            else{
                openxiangqing();cc=1;Log.i(TAG,"我在这4");
            }
        }
        else{
            openxiangqing();dd=1;Log.i(TAG,"我在这5");
        }

    }


    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        UserManager userManager = new UserManager(actiActivity.this);
        HashMap<String,String> map1= (HashMap<String, String>) getListView().getItemAtPosition(position);
        hdname=map1.get("name");
        Log.i(TAG,"OnItemClick: hdname=" +hdname);
        int a=userManager.attendscount1(hdname);;
        Log.i(TAG,"该活动当前报名人数为"+a);
        HdItem item= userManager. findorgtimeByhdname(hdname);
        String renshu=item.getHdrenshu();
        int renshu1=Integer.parseInt(renshu);
        Log.i(TAG,"该活动需求人数为"+renshu1);
        int chongfu=userManager.chongfubaoming(hdname,username);

        if(aa==1||bb==1||cc==1||dd==1){
        if(chongfu==0){
            if(renshu1>a){
                Toast.makeText(getApplicationContext(), "当前活动还有报名余额", Toast.LENGTH_SHORT).show();
                userManager.add5(new AttendItem(hdname,username,null));
                Log.i(TAG, "数据已写入attend数据库");
                Toast.makeText(getApplicationContext(), "报名成功，可前往我的志愿活动查看", Toast.LENGTH_SHORT).show();
            }
            else if((renshu1<=a)){
            Toast.makeText(getApplicationContext(), "抱歉，当前活动名额已满", Toast.LENGTH_SHORT).show();
        }
        }
        else{
            Toast.makeText(getApplicationContext(), "不可重复报名哦!", Toast.LENGTH_SHORT).show();
        }
    }




        return true;//长按操作时屏蔽短按操作  之前放在第一排居然会报错！
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.tuimain,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.menu_main){
            Intent config= new Intent(this,UserwelcomeActivity.class);//打开另一个Activity
            startActivity(config);
        }
        else if(item.getItemId()==R.id.menu_tuichu){
            Intent list= new Intent(this,LoginActivity.class);//打开另一个Activity
            startActivity(list);


        }
        return super.onOptionsItemSelected(item);
    }

    public void openxiangqing() {
        //打开活动详情页面，传入参数
        Intent xiangqing= new Intent(this,XiangqingActivity.class);
        xiangqing.putExtra("username",username);
        xiangqing.putExtra("hdname",hdname);
        xiangqing.putExtra("yue3",yue3);xiangqing.putExtra("ri3",ri3);
        xiangqing.putExtra("shi3",shi3);xiangqing.putExtra("fen3",fen3);
        xiangqing.putExtra("month",mMonth);xiangqing.putExtra("day",mDay);
        xiangqing.putExtra("hour",mHour);xiangqing.putExtra("minute",mMinute);
        startActivity(xiangqing);
    }



}



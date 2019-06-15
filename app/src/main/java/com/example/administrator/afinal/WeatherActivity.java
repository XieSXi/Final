package com.example.administrator.afinal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.List;

import static android.content.ContentValues.TAG;

public class WeatherActivity extends AppCompatActivity implements Runnable {
    Handler handler;
    String TAG = "weather";
    String date1, date2, date3;
    String weather1, weather2, weather3;
    String wd11, wd12, wd13;
    String wd21, wd22, wd23;
    TextView ttoday;TextView tdate2;TextView tdate3;
    TextView tweather1;TextView tweather2;TextView tweather3;
    TextView twdx1;TextView twdx2;TextView twdx3;
    TextView twdd1;TextView twdd2;TextView twdd3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ttoday=(TextView) findViewById(R.id.today);tdate2=(TextView) findViewById(R.id.date2);tdate3=(TextView) findViewById(R.id.date3);
        tweather1=(TextView) findViewById(R.id.weather1); tweather2=(TextView) findViewById(R.id.weather2);
        tweather3=(TextView) findViewById(R.id.weather3);
//        twdx1=(TextView) findViewById(R.id.wdx1);
        twdx2=(TextView) findViewById(R.id.wdx2);twdx3=(TextView) findViewById(R.id.wdx3);
        twdd1=(TextView) findViewById(R.id.wdd1);twdd2=(TextView) findViewById(R.id.wdd2);twdd3=(TextView) findViewById(R.id.wdd3);

        Toast.makeText(getApplicationContext(), "正在从中国天气网获取数据", Toast.LENGTH_SHORT).show();
        Thread t = new Thread(this);
        t.start();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 7) {
                    Bundle bdl = (Bundle) msg.obj;
                    date1 = bdl.getString("riqi[" + 11 + "]");
                    date2 = bdl.getString("riqi[" + 12 + "]");
                    date3 = bdl.getString("riqi[" + 13 + "]");
                    weather1 = bdl.getString("tianqi[" + 11 + "]");
                    weather2 = bdl.getString("tianqi[" + 12 + "]");
                    weather3 = bdl.getString("tianqi[" + 13 + "]");
                    wd11 = bdl.getString("wdxiao[" + 11 + "]");
                    wd12 = bdl.getString("wdxiao[" + 12 + "]");
                    wd13 = bdl.getString("wdxiao[" + 13 + "]");
                    wd21 = bdl.getString("wdda[" + 11 + "]");
                    wd22 = bdl.getString("wdda[" + 12 + "]");
                    wd23 = bdl.getString("wdda[" + 13 + "]");
//                    for(int b=1;b<6;b+=1){
//                        int c=b+10;
//                        date[b]=bdl.getString("riqi["+c+"]");
//                        weather[b]=bdl.getString("tianqi["+c+"]");
//                        wd1[b]=bdl.getString("wdxiao["+c+"]");
//                        wd2[b]=bdl.getString("wdda["+c+"]");
                    Log.i(TAG,"今天"+date1+weather1+wd11+wd21);
                    ttoday.setText(date1);tdate2.setText(date2);tdate3.setText(date3);
                    tweather1.setText(weather1);tweather2.setText(weather2);tweather3.setText(weather3);
//                    twdx1.setText(wd11);
                    twdx2.setText(wd12);twdx3.setText(wd13);
                    twdd1.setText(wd21);twdd2.setText(wd22);twdd3.setText(wd23);
                    Toast.makeText(getApplicationContext(), "获取天气数据完成", Toast.LENGTH_SHORT).show();



                }
                super.handleMessage(msg);

            }

        };



    }



    @Override
    public void run() {

        Document doc = null;
        try {
            Thread.sleep(2000);
            doc = Jsoup.connect("http://www.weather.com.cn/weather/101270101.shtml").get();
            Log.i(TAG,"run: "+doc.title());
            Elements lis = doc.getElementsByTag("li");
//            int i=1;
//            for(Element li:lis){
//                Log.i(TAG,"run:li["+i+"]="+li);
//                i++;
//            }
            Bundle bundle=new Bundle();
            for(int a=11;a<14;a+=1){
                Element li12=lis.get(a);
//                Log.i(TAG,"第一条天气数据"+li12);
                Elements h1s=li12.getElementsByTag("h1");
                String riqi=h1s.text();
//            Log.i(TAG,"日期"+riqi);
                Elements ps=li12.getElementsByTag("p");
//            Log.i(TAG,"p标签"+ps);
                String tianqi=ps.get(0).text();
                Elements wenduxiao=ps.get(1).getElementsByTag("span");
                String wdxiao=wenduxiao.text();
                Elements wenduda=ps.get(1).getElementsByTag("i");
                String wdda=wenduda.text();
                Log.i(TAG,""+riqi+tianqi+wdxiao+wdda);

                bundle.putString("riqi["+a+"]",riqi);
                bundle.putString("tianqi["+a+"]",tianqi);
                bundle.putString("wdxiao["+a+"]",wdxiao);
                bundle.putString("wdda["+a+"]",wdda);

//                Log.i(TAG,"try"+  bundle.getString("riqi[11]",riqi));
            }

            Message msg = handler.obtainMessage(7);
            msg.obj = bundle;
            handler.sendMessage(msg);
    }
    catch (InterruptedException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }}

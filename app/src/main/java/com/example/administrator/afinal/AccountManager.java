package com.example.administrator.afinal;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
public class AccountManager {
    private DBHelper dbHelper;
    private String TBNAME;

    public AccountManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(AccountItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname", item.getCurName());
        values.put("currate", item.getCurRate());
        db.insert(TBNAME, null, values);
        db.close();
    }


    public void addAll(List<AccountItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (AccountItem item : list) {
            ContentValues values = new ContentValues();
            values.put("curname", item.getCurName());
            values.put("currate", item.getCurRate());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }



    public List<AccountItem> listAll(){
        List<AccountItem> rateList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();   //dbHelper = new DBHelper(context); dbHelper是DBHelper类的一个实例，通过这个实例获得数据库访问获得一个只读数据库;
        Cursor cursor = db.query(TBNAME, null, null, null, null, null, null);
        //db.query查询数据 表name后面都是null，是查询所有数据；返回的是一个光标，
        if(cursor!=null){    //是将数据装载到列表里的过程
            rateList = new ArrayList<AccountItem>(); //List<RateItem> rateList = null,空对象是不能有任何方法的，所以对rateList进行实例化
            while(cursor.moveToNext()){ //当获得游标之后，它是停留在标题行；是否可以移到下一行，如果下一行有数据就会移到下一行
                AccountItem item = new AccountItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));//cursor.getColumnIndex("ID")：光标获取ID这一列的索引
                item.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
                item.setCurRate(cursor.getString(cursor.getColumnIndex("CURRATE")));
                rateList.add(item);
                //把行数据转化成了对象，转化完之后把当前对象放到列表里面来
            }
            cursor.close();
        }
        db.close();
        return rateList;
    }
    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }


}

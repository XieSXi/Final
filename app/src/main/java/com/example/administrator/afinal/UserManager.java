package com.example.administrator.afinal;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
public class UserManager {
    private DBHelper dbHelper;
    private String TBNAME1;

    public UserManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME1 = DBHelper.TB_NAME1;
    }

    public void add(UserItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stuno", item.getStuNo());
        values.put("stuname", item.getStuName());
        values.put("username", item.getUserName());
        values.put("userpwd", item.getUserPwd());
        values.put("nianji", item.getNianJi());
        values.put("xueyuan", item.getXueYuan());
        values.put("major", item.getMajor());
        values.put("tel", item.getTel());
        values.put("email", item.getEmail());
        db.insert(TBNAME1, null, values);
        db.close();
    }


    public void addAll(List<UserItem> list){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (UserItem item : list) {
            ContentValues values = new ContentValues();
            values.put("username", item.getUserName());
            values.put("userpwd", item.getUserPwd());
            db.insert(TBNAME1, null, values);
        }
        db.close();
    }



    public List<UserItem> listAll(){
        List<UserItem> rateList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();   //dbHelper = new DBHelper(context); dbHelper是DBHelper类的一个实例，通过这个实例获得数据库访问获得一个只读数据库;
        Cursor cursor = db.query(TBNAME1, null, null, null, null, null, null);
        //db.query查询数据 表name后面都是null，是查询所有数据；返回的是一个光标，
        if(cursor!=null){    //是将数据装载到列表里的过程
            rateList = new ArrayList<UserItem>(); //List<RateItem> rateList = null,空对象是不能有任何方法的，所以对rateList进行实例化
            while(cursor.moveToNext()){ //当获得游标之后，它是停留在标题行；是否可以移到下一行，如果下一行有数据就会移到下一行
                UserItem item = new UserItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));//cursor.getColumnIndex("ID")：光标获取ID这一列的索引
                item.setStuNo(cursor.getString(cursor.getColumnIndex("STUNO")));
                item.setStuName(cursor.getString(cursor.getColumnIndex("STUNAME")));
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
        db.delete(TBNAME1,null,null);
        db.close();
    }

    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME1, "ID=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(UserItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", item.getUserName());
        values.put("userrate", item.getUserPwd());
        db.update(TBNAME1, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
    }

    public UserItem findById(int id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME1, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        UserItem userItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            userItem = new UserItem();
            userItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            userItem.setUserName(cursor.getString(cursor.getColumnIndex("USERNAME")));
            userItem.setUserPwd(cursor.getString(cursor.getColumnIndex("USERPWD")));
            cursor.close();
        }
        db.close();
        return userItem;
    }

    public UserItem findByUsename(String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME1, null, "USERNAME=?", new String[]{String.valueOf(username)}, null, null, null);
        UserItem userItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            userItem = new UserItem();
            userItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            userItem.setUserName(cursor.getString(cursor.getColumnIndex("USERNAME")));
            userItem.setUserPwd(cursor.getString(cursor.getColumnIndex("USERPWD")));
            userItem.setStuName(cursor.getString(cursor.getColumnIndex("STUNAME")));
            userItem.setStuNo(cursor.getString(cursor.getColumnIndex("STUNO")));
            userItem.setNianJi(cursor.getString(cursor.getColumnIndex("NIANJI")));
            userItem.setXueYuan(cursor.getString(cursor.getColumnIndex("XUEYUAN")));
            userItem.setMajor(cursor.getString(cursor.getColumnIndex("MAJOR")));
            userItem.setTel(cursor.getString(cursor.getColumnIndex("TEL")));
            userItem.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
            userItem.setHobby(cursor.getString(cursor.getColumnIndex("HOBBY")));
            cursor.close();
        }
        db.close();
        return userItem;
    }


    public int exist(String uname,String upwd){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME1, null, "USERNAME=?", new String[]{String.valueOf(uname)}, null, null, null);
        Cursor cursor1 = db.query(TBNAME1, null, "USERNAME=?"+" and "+"USERPWD=?",new String[]{uname,upwd}, null, null, null);
        int result =2;
        if(cursor!=null && cursor1!=null){
            result=1;
            cursor.close();
        }
        else if(cursor==null){
            result=0;
            cursor.close();
        }
        else if(cursor!=null&&cursor1==null){
            result=-1;
            cursor.close();
        }

        db.close();
        return result;
    }

    public int exist1(String stuno,String stuna){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME1, null, "STUNAME=?"+" and "+"STUNO=?",new String[]{stuno,stuna}, null, null, null);
        int result =2;
        if(cursor!=null){
            result=1;
            cursor.close();
        }
        else if(cursor==null){
            result=0;
            cursor.close();
        }
        db.close();
        return result;
    }

}




package com.example.administrator.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 4;
    private static final String DB_NAME = "activityManage.db";
    public static final String TB_NAME0 = "tb_user";
    public static final String TB_NAME1 = "tb_users";
    public static final String TB_NAME2 = "tb_students";
    public static final String TB_NAME3 = "tb_organization";
    public String TAG="database";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL("DROP TABLE "+TB_NAME0);
//        Log.i(TAG,"表已删除");
//        db.execSQL("CREATE TABLE "+TB_NAME1+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,STUNO TEXT,STUNAME TEXT,USERNAME TEXT,USERPWD TEXT,NIANJI TEXT,XUEYUAN TEXT,MAJOR TEXT,TEL TEXT,EMAIL TEXT,HOBBY TEXT)");
//        Log.i(TAG,"用户表tb_users已创建");
//        db.execSQL("CREATE TABLE "+TB_NAME2+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,STUNO TEXT,STUNAME TEXT)");
//        Log.i(TAG,"用户表tb_students已创建");

        db.execSQL("CREATE TABLE "+TB_NAME3+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ORGNAME TEXT,ORGPWD TEXT)");
        Log.i(TAG,"用户表tb_organization已创建");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //再次创建表
        onCreate(db);

    }
}


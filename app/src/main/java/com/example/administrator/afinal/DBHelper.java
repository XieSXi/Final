package com.example.administrator.afinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DB_NAME = "activityManage.db";
    public static final String TB_NAME1 = "tb_user";
    public static final String TB_NAME2 = "tb_organization";
    public String TAG="db";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public DBHelper(Context context) {
        super(context,DB_NAME,null,VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TB_NAME1+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,STUNO TEXT,STUNAME TEXT,USERNAME TEXT,USERPWD TEXT,NIANJI TEXT,XUEYUAN TEXT,ZHUANYE TEXT,TEL TEXT,EMAIL,TEXT,HOBBY TEXT)");
        Log.i(TAG,"用户表tb_user已创建");
        db.execSQL("CREATE TABLE "+TB_NAME2+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,ORGNAME TEXT,ORGRPWD TEXT)");
        Log.i(TAG,"用户表tb_organization已创建");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}


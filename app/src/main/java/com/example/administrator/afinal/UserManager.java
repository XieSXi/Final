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
    private String TBNAME2;
    private String TBNAME3;
    private String TBNAME4;
    private String TBNAME5;
    private String TBNAME6;
    private String TBNAME7;


    public UserManager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME1 = dbHelper.TB_NAME1;
        TBNAME2= dbHelper.TB_NAME2;
        TBNAME3= dbHelper.TB_NAME3;
        TBNAME4= dbHelper.TB_NAME4;
        TBNAME5= dbHelper.TB_NAME5;
        TBNAME6= dbHelper.TB_NAME6;
        TBNAME7= dbHelper.TB_NAME7;

    }

    public String a(){
        return TBNAME1;
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
        values.put("hobby", item.getHobby());
        db.insert(TBNAME1, null, values);
        db.close();
    }

    public void add1(UserItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("stuno", item.getStuNo());
        values.put("stuname", item.getStuName());
        db.insert(TBNAME2, null, values);
        db.close();
    }


    public void add2(String orgname,String orgpwd) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ORGNAME", orgname);
        values.put("ORGPWD", orgpwd);
        db.insert(TBNAME3, null, values);
        db.close();
    }


    public void add3(String manaid,String managpwd) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("MANANAME", manaid);
        values.put("MANAPWD", managpwd);
        db.insert(TBNAME4, null, values);
        db.close();
    }


//    public void add4(String hdname1,String hdtime1,String hdcontent1,String hdplace1,String hdrequests1,String hdrenshu1,
//                     String hdattention1,String hdtrain1,String hdpay1,String hdyue1,String hdri1,String hdshi1,String hdfen1) {
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("HDNAME",hdname1);
//        values.put("HDTIME",hdtime1);
//        values.put("HDCONTENT",hdcontent1);
//        values.put("HDPLACE",hdplace1);
//        values.put("HDREQUESTS",hdrequests1);
//        values.put("HDRENSHU ",hdrenshu1);
//        values.put("ATTENTION",hdattention1);
//        values.put("TRAIN",hdtrain1);
//        values.put("PAY",hdpay1);
//        values.put("HDYUE",hdyue1);
//        values.put("HDRI",hdri1);
//        values.put("HDSHI",hdshi1);
//        values.put("HDFEN",hdfen1);
//
//        db.insert(TBNAME5, null, values);
//        db.close();
//
//    }




    public void add4(HdItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HDORG",item.getHdorg());
        values.put("HDNAME",item.getHdname());
        values.put("HDTIME",item.getHdtime());
        values.put("HDCONTENT",item.getHdcontent());
        values.put("HDPLACE",item.getHdplace());
        values.put("HDREQUESTS",item.getHdrequests());
        values.put("HDRENSHU ",item.getHdrenshu());
        values.put("ATTENTION",item.getHdattention());
        values.put("TRAIN",item.getHdtrain());
        values.put("PAY",item.getHdpay());
        values.put("HDYUE",item.getHdyue());
        values.put("HDRI",item.getHdri());
        values.put("HDSHI",item.getHdshi());
        values.put("HDFEN",item.getHdfen());

        db.insert(TBNAME6, null, values);
        db.close();

    }


    public void add5(AttendItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HDNAME", item.getHdname());
        values.put("USERNAME", item.getUsername());
        db.insert(TBNAME7, null, values);
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
                item.setUserName(cursor.getString(cursor.getColumnIndex("USERNAME")));
                item.setUserPwd(cursor.getString(cursor.getColumnIndex("USERPWD")));
                item.setNianJi(cursor.getString(cursor.getColumnIndex("NIANJI")));
                item.setXueYuan(cursor.getString(cursor.getColumnIndex("XUEYUAN")));
                item.setMajor(cursor.getString(cursor.getColumnIndex("MAJOR")));
                item.setTel(cursor.getString(cursor.getColumnIndex("TEL")));
                item.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));
                item.setHobby(cursor.getString(cursor.getColumnIndex("HOBBY")));

                rateList.add(item);
                //把行数据转化成了对象，转化完之后把当前对象放到列表里面来
            }
            cursor.close();
        }
        db.close();
        return rateList;
    }





    public List<HdItem> listAll1(){
        List<HdItem> hdList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();   //dbHelper = new DBHelper(context); dbHelper是DBHelper类的一个实例，通过这个实例获得数据库访问获得一个只读数据库;
        Cursor cursor = db.query(TBNAME6, null, null, null, null, null, null);
        //db.query查询数据 表name后面都是null，是查询所有数据；返回的是一个光标，
        if(cursor!=null){    //是将数据装载到列表里的过程
            hdList = new ArrayList<HdItem>(); //List<RateItem> rateList = null,空对象是不能有任何方法的，所以对rateList进行实例化
            while(cursor.moveToNext()){ //当获得游标之后，它是停留在标题行；是否可以移到下一行，如果下一行有数据就会移到下一行
                HdItem item = new HdItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));//cursor.getColumnIndex("ID")：光标获取ID这一列的索引
                item.setHdorg(cursor.getString(cursor.getColumnIndex("HDORG")));
                item.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
                item.setHdtime(cursor.getString(cursor.getColumnIndex("HDTIME")));
                item.setHdcontent(cursor.getString(cursor.getColumnIndex("HDCONTENT")));
                item.setHdplace(cursor.getString(cursor.getColumnIndex("HDPLACE")));
                item.setHdrequests(cursor.getString(cursor.getColumnIndex("HDREQUESTS")));
                item.setHdrenshu(cursor.getString(cursor.getColumnIndex("HDRENSHU")));
                item.setHdattention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                item.setHdtrain(cursor.getString(cursor.getColumnIndex("TRAIN")));
                item.setHdpay(cursor.getString(cursor.getColumnIndex("PAY")));
                item.setHdyue(cursor.getString(cursor.getColumnIndex("HDYUE")));
                item.setHdri(cursor.getString(cursor.getColumnIndex("HDRI")));
                item.setHdshi(cursor.getString(cursor.getColumnIndex("HDSHI")));
                item.setHdfen(cursor.getString(cursor.getColumnIndex("HDFEN")));

                hdList.add(item);
                //把行数据转化成了对象，转化完之后把当前对象放到列表里面来
            }
            cursor.close();
        }
        db.close();
        return hdList;
    }








    public void deleteAll1(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME1,null,null);
        db.close();
    }
    public void deleteAll2(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME2,null,null);
        db.close();
    }
    public void deleteAll3(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME3,null,null);
        db.close();
    }
    public void deleteAll6(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME6,null,null);
        db.close();
    }
    public void deleteAll7(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME7,null,null);
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

    public HdItem findById(String id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "ID=?", new String[]{String.valueOf(id)}, null, null, null);
        HdItem hdItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            hdItem = new HdItem();
            hdItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            hdItem.setHdorg(cursor.getString(cursor.getColumnIndex("HDORG")));
            hdItem.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
            hdItem.setHdtime(cursor.getString(cursor.getColumnIndex("HDTIME")));
            hdItem.setHdcontent(cursor.getString(cursor.getColumnIndex("HDCONTENT")));
            hdItem.setHdplace(cursor.getString(cursor.getColumnIndex("HDPLACE")));
            hdItem.setHdrequests(cursor.getString(cursor.getColumnIndex("HDREQUESTS")));
            hdItem.setHdrenshu(cursor.getString(cursor.getColumnIndex("HDRENSHU")));
            hdItem.setHdattention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
            hdItem.setHdtrain(cursor.getString(cursor.getColumnIndex("TRAIN")));
            hdItem.setHdpay(cursor.getString(cursor.getColumnIndex("PAY")));
            hdItem.setHdyue(cursor.getString(cursor.getColumnIndex("HDYUE")));
            hdItem.setHdri(cursor.getString(cursor.getColumnIndex("HDRI")));
            hdItem.setHdshi(cursor.getString(cursor.getColumnIndex("HDSHI")));
            hdItem.setHdfen(cursor.getString(cursor.getColumnIndex("HDFEN")));


            cursor.close();
        }
        db.close();
        return hdItem;
    }




    public List<HdItem> showByOrg(String org){
        List<HdItem> hdList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "HDORG=?", new String[]{String.valueOf(org)}, null, null, null);
        if(cursor!=null){
            hdList=new ArrayList<HdItem>();
            while(cursor.moveToNext()) {
                HdItem hdItem = new HdItem();
                hdItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                hdItem.setHdorg(cursor.getString(cursor.getColumnIndex("HDORG")));
                hdItem.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
                hdItem.setHdtime(cursor.getString(cursor.getColumnIndex("HDTIME")));
                hdItem.setHdcontent(cursor.getString(cursor.getColumnIndex("HDCONTENT")));
                hdItem.setHdplace(cursor.getString(cursor.getColumnIndex("HDPLACE")));
                hdItem.setHdrequests(cursor.getString(cursor.getColumnIndex("HDREQUESTS")));
                hdItem.setHdrenshu(cursor.getString(cursor.getColumnIndex("HDRENSHU")));
                hdItem.setHdattention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                hdItem.setHdtrain(cursor.getString(cursor.getColumnIndex("TRAIN")));
                hdItem.setHdpay(cursor.getString(cursor.getColumnIndex("PAY")));
                hdItem.setHdyue(cursor.getString(cursor.getColumnIndex("HDYUE")));
                hdItem.setHdri(cursor.getString(cursor.getColumnIndex("HDRI")));
                hdItem.setHdshi(cursor.getString(cursor.getColumnIndex("HDSHI")));
                hdItem.setHdfen(cursor.getString(cursor.getColumnIndex("HDFEN")));

                hdList.add(hdItem);
            }

            cursor.close();
        }
        db.close();
        return hdList;
    }



    public List<HdItem> showByHdname(String hdname){
        List<HdItem> hdList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "HDNAME=?", new String[]{String.valueOf(hdname)}, null, null, null);
        if(cursor!=null){
            hdList=new ArrayList<HdItem>();
            while(cursor.moveToNext()) {
                HdItem hdItem = new HdItem();
                hdItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                hdItem.setHdorg(cursor.getString(cursor.getColumnIndex("HDORG")));
                hdItem.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
                hdItem.setHdtime(cursor.getString(cursor.getColumnIndex("HDTIME")));
                hdItem.setHdcontent(cursor.getString(cursor.getColumnIndex("HDCONTENT")));
                hdItem.setHdplace(cursor.getString(cursor.getColumnIndex("HDPLACE")));
                hdItem.setHdrequests(cursor.getString(cursor.getColumnIndex("HDREQUESTS")));
                hdItem.setHdrenshu(cursor.getString(cursor.getColumnIndex("HDRENSHU")));
                hdItem.setHdattention(cursor.getString(cursor.getColumnIndex("ATTENTION")));
                hdItem.setHdtrain(cursor.getString(cursor.getColumnIndex("TRAIN")));
                hdItem.setHdpay(cursor.getString(cursor.getColumnIndex("PAY")));
                hdItem.setHdyue(cursor.getString(cursor.getColumnIndex("HDYUE")));
                hdItem.setHdri(cursor.getString(cursor.getColumnIndex("HDRI")));
                hdItem.setHdshi(cursor.getString(cursor.getColumnIndex("HDSHI")));
                hdItem.setHdfen(cursor.getString(cursor.getColumnIndex("HDFEN")));

                hdList.add(hdItem);
            }

            cursor.close();
        }
        db.close();
        return hdList;
    }






    public UserItem showByUsername(String username){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        UserItem item = new UserItem();
        Cursor cursor = db.query(TBNAME1, null, "USERNAME=?", new String[]{String.valueOf(username)}, null, null, null);
        if(cursor!=null){
            while(cursor.moveToNext()) {

                item.setStuNo(cursor.getString(cursor.getColumnIndex("STUNO")));
                item.setStuName(cursor.getString(cursor.getColumnIndex("STUNAME")));
                item.setUserName(cursor.getString(cursor.getColumnIndex("USERNAME")));
                item.setNianJi(cursor.getString(cursor.getColumnIndex("NIANJI")));
                item.setXueYuan(cursor.getString(cursor.getColumnIndex("XUEYUAN")));
                item.setMajor(cursor.getString(cursor.getColumnIndex("MAJOR")));
                item.setTel(cursor.getString(cursor.getColumnIndex("TEL")));
                item.setEmail(cursor.getString(cursor.getColumnIndex("EMAIL")));

            }

            cursor.close();
        }
        db.close();
        return item;
    }






    public List<AttendItem> showByHdname1(String hdname){
        List<AttendItem> attendList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME7, null, "HDNAME=?", new String[]{String.valueOf(hdname)}, null, null, null);
        if(cursor!=null){
            attendList=new ArrayList<AttendItem>();
            while(cursor.moveToNext()) {
                AttendItem attendItem = new AttendItem();
                attendItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                attendItem.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
                attendItem.setUsername(cursor.getString(cursor.getColumnIndex("USERNAME")));
                attendList.add(attendItem);
            }

            cursor.close();
        }
        db.close();
        return attendList;
    }



    public List<AttendItem> showByUsername1(String username){
        List<AttendItem> attendList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME7, null, "USERNAME=?", new String[]{String.valueOf(username)}, null, null, null);
        if(cursor!=null){
            attendList=new ArrayList<AttendItem>();
            while(cursor.moveToNext()) {
                AttendItem attendItem = new AttendItem();
                attendItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                attendItem.setHdname(cursor.getString(cursor.getColumnIndex("HDNAME")));
                attendItem.setUsername(cursor.getString(cursor.getColumnIndex("USERNAME")));
                attendItem.setJudge(cursor.getString(cursor.getColumnIndex("JUDGE")));
                attendList.add(attendItem);
            }

            cursor.close();
        }
        db.close();
        return attendList;
    }




    public HdItem findidByhdname(String huodongname){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "HDNAME=?", new String[]{String.valueOf(huodongname)}, null, null, null);
        HdItem hdItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            hdItem = new HdItem();
            hdItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            cursor.close();
        }
        db.close();
        return hdItem ;
    }

    public HdItem findorgtimeByhdname(String huodongname){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "HDNAME=?", new String[]{String.valueOf(huodongname)}, null, null, null);
        HdItem hdItem = null;
        if(cursor!=null && cursor.moveToFirst()){
            hdItem = new HdItem();
            hdItem.setHdorg(cursor.getString(cursor.getColumnIndex("HDORG")));
            hdItem.setHdtime(cursor.getString(cursor.getColumnIndex("HDTIME")));
            hdItem.setHdrenshu(cursor.getString(cursor.getColumnIndex("HDRENSHU")));
            cursor.close();
        }
        db.close();
        return hdItem ;
    }



    public AttendItem findjudgeBy(String username,String hdname){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME6, null, "USERNAME=?"+" and "+"HDNAME=?",new String[]{username,hdname}, null, null, null);
        AttendItem attendItem= null;
        if(cursor!=null && cursor.moveToFirst()){
            attendItem = new AttendItem();
            attendItem.setJudge(cursor.getString(cursor.getColumnIndex("JUDGE")));
            cursor.close();
        }
        db.close();
        return attendItem ;
    }




    public void updateHd(HdItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HDORG", item.getHdorg());
        values.put("HDNAME", item.getHdname());
        values.put("HDTIME", item.getHdtime());
        values.put("HDCONTENT",item.getHdcontent());
        values.put("HDPLACE",item.getHdplace());
        values.put("HDREQUESTS",item.getHdrequests());
        values.put("HDRENSHU ",item.getHdrenshu());
        values.put("ATTENTION",item.getHdattention());
        values.put("TRAIN",item.getHdtrain());
        values.put("PAY",item.getHdpay());
        values.put("HDYUE",item.getHdyue());
        values.put("HDRI",item.getHdri());
        values.put("HDSHI",item.getHdshi());
        values.put("HDFEN",item.getHdfen());

        db.update(TBNAME6, values, "ID=?", new String[]{String.valueOf(item.getId())});
        db.close();
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


    public int login (String uname,String upwd) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "select * from tb_users where USERNAME=? ";
        String sql2 = "select * from tb_users where USERNAME=? and USERPWD=?";
        Cursor cursor1 = db.rawQuery(sql1, new String[] {uname});
        Cursor cursor2 = db.rawQuery(sql2, new String[] {uname, upwd});
        if (cursor1.moveToFirst()) {
            if(cursor2.moveToFirst()){
                result=1;
            }
            else{
                result=-1;
            }
            cursor1.close();
            cursor2.close();
        }
        else{
            result=0;
        }
        db.close();
        return result;
    }



    public int login1 (String oname,String opwd) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "select * from tb_organization where ORGNAME=? ";
        String sql2 = "select * from tb_organization where ORGNAME=? and ORGPWD=?";
        Cursor cursor1 = db.rawQuery(sql1, new String[] {oname});
        Cursor cursor2 = db.rawQuery(sql2, new String[] {oname,opwd});
        if (cursor1.moveToFirst()) {
            if(cursor2.moveToFirst()){
                result=1;
            }
            else{
                result=-1;
            }
            cursor1.close();
            cursor2.close();
        }
        else{
            result=0;
        }
        db.close();
        return result;
    }




    public int login2 (String mid,String mpwd) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "select * from tb_manager where MANANAME=? ";
        String sql2 = "select * from tb_manager where MANANAME=? and MANAPWD=?";
        Cursor cursor1 = db.rawQuery(sql1, new String[] {mid});
        Cursor cursor2 = db.rawQuery(sql2, new String[] {mid,mpwd});
        if (cursor1.moveToFirst()) {
            if(cursor2.moveToFirst()){
                result=1;
            }
            else{
                result=-1;
            }
            cursor1.close();
            cursor2.close();
        }
        else{
            result=0;
        }
        db.close();
        return result;
    }





//    public int exist1(String stuno,String stuna){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        Cursor cursor = db.query(TBNAME1, null, "STUNAME=?"+" and "+"STUNO=?",new String[]{stuno,stuna}, null, null, null);
//        int result =2;
//        if(cursor!=null){
//            result=1;
//            cursor.close();
//        }
//        else if(cursor==null){
//            result=0;
//            cursor.close();
//        }
//        db.close();
//        return result;
//    }


    public int yanzheng (String stuna,String stuno) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from tb_students where STUNAME=? and STUNO=?";
        Cursor cursor = db.rawQuery(sql, new String[] {stuna, stuno});
        if (cursor.moveToFirst()) {
            result=1;
            cursor.close();
        }
        else{
            result=0;
            cursor.close();
        }
        db.close();
        return result;
    }

    public int yanzhengID (String id,String org) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql1 = "select * from tb_acti where ID=?";
        String sql2 = "select * from tb_acti where ID=? and HDORG=?";
        Cursor cursor1 = db.rawQuery(sql1, new String[] {id});
        Cursor cursor2 = db.rawQuery(sql2, new String[] {id,org});
        if (cursor1.moveToFirst()) {
            if(cursor2.moveToFirst()){
            result=1;
        }
            else {
            result = -1;
        }
        cursor1.close();
        cursor2.close();
        }
        else{
        result = 0;
    }
        db.close();
        return result;
    }




    public void updateAttend(String hdname,String username,String judge){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("HDNAME", hdname);
        values.put("USERNAME", username);
        values.put("JUDGE", judge);

        db.update(TBNAME7, values, "HDNAME=?"+" and "+"USERNAME=?",new String[]{hdname,username});
        db.close();
    }


    public List<StuItem> liststu(){
        List<StuItem> stuList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();   //dbHelper = new DBHelper(context); dbHelper是DBHelper类的一个实例，通过这个实例获得数据库访问获得一个只读数据库;
        Cursor cursor = db.query(TBNAME2, null, null, null, null, null, null);
        //db.query查询数据 表name后面都是null，是查询所有数据；返回的是一个光标，
        if(cursor!=null){    //是将数据装载到列表里的过程
            stuList = new ArrayList<StuItem>(); //List<RateItem> rateList = null,空对象是不能有任何方法的，所以对rateList进行实例化
            while(cursor.moveToNext()){ //当获得游标之后，它是停留在标题行；是否可以移到下一行，如果下一行有数据就会移到下一行
                StuItem item = new StuItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));//cursor.getColumnIndex("ID")：光标获取ID这一列的索引
                item.setStuno(cursor.getString(cursor.getColumnIndex("STUNO")));
                item.setStuname(cursor.getString(cursor.getColumnIndex("STUNAME")));
                stuList.add(item);
                //把行数据转化成了对象，转化完之后把当前对象放到列表里面来
            }
            cursor.close();
        }
        db.close();
        return stuList;
    }




    public void deletexueji(String stuno){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME2, "STUNO=?", new String[]{String.valueOf(stuno)});
        db.close();
    }



    public List<OrgItem> listorg(){
        List<OrgItem> orgList = null;   //很多行数据，每一行数据表示为一个RateItem对象
        SQLiteDatabase db = dbHelper.getReadableDatabase();   //dbHelper = new DBHelper(context); dbHelper是DBHelper类的一个实例，通过这个实例获得数据库访问获得一个只读数据库;
        Cursor cursor = db.query(TBNAME3, null, null, null, null, null, null);
        //db.query查询数据 表name后面都是null，是查询所有数据；返回的是一个光标，
        if(cursor!=null){    //是将数据装载到列表里的过程
            orgList = new ArrayList<OrgItem>(); //List<RateItem> rateList = null,空对象是不能有任何方法的，所以对rateList进行实例化
            while(cursor.moveToNext()){ //当获得游标之后，它是停留在标题行；是否可以移到下一行，如果下一行有数据就会移到下一行
                OrgItem item = new OrgItem();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));//cursor.getColumnIndex("ID")：光标获取ID这一列的索引
                item.setOrgname(cursor.getString(cursor.getColumnIndex("ORGNAME")));
                item.setOrgpwd(cursor.getString(cursor.getColumnIndex("ORGPWD")));
                orgList.add(item);
                //把行数据转化成了对象，转化完之后把当前对象放到列表里面来
            }
            cursor.close();
        }
        db.close();
        return orgList;
    }




    public void deletezuzhi(String orgname){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME3, "ORGNAME=?", new String[]{String.valueOf(orgname)});
        db.close();
    }

    public void luruxj(StuItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("STUNO", item.getStuno());
        values.put("STUNAME", item.getStuname());
        db.insert(TBNAME2, null, values);
        db.close();
    }


    public void luruzz(OrgItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ORGNAME", item.getOrgname());
        values.put("ORGPWD", item.getOrgpwd());
        db.insert(TBNAME3, null, values);
        db.close();
    }



    /**

     * 查询数据库中的总条数.

     */

    public long userscount( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select count(*) from tb_users ";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public long orgscount( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select count(*) from tb_organization ";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public long hdscount( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select count(*) from tb_acti ";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public long attendscount( ){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select count(*) from tb_attend ";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        long count = cursor.getLong(0);
        cursor.close();
        return count;
    }

    public int attendscount1( String hdname){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select count(*) from tb_attend where HDNAME=?";
        Cursor cursor = db.rawQuery(sql,new String[]{hdname});
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        cursor.close();
        return count;
    }



    public int chongfubaoming (String hdname,String username) {
        int result =2;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "select * from tb_attend where HDNAME=? and USERNAME=? ";
        Cursor cursor = db.rawQuery(sql, new String[] {hdname,username});
        if (cursor.moveToFirst()) {
            result=1;
            cursor.close();
        }
        else{
            result=0;
            cursor.close();
        }
        db.close();
        return result;
    }

    public void quxiaobaoming(String hdname,String username){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME7,"HDNAME=?"+" and "+"USERNAME=?", new String[]{hdname,username});
        db.close();
    }

//
//    public void quxiaohuodong1(String hdname){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete(TBNAME7,"HDNAME=?", new String[]{hdname});
//        db.close();
//    }
//    public void quxiaohuodong2(String hdname){
//        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        db.delete(TBNAME6,"HDNAME=?", new String[]{hdname});
//        db.close();
//    }

}

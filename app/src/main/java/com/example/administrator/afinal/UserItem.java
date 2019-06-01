package com.example.administrator.afinal;

public class UserItem {
    private int id;
    private String stuNo;
    private String stuName;
    private String userName;
    private String userPwd;
    private String nianJi;
    private String xueYuan;
    private String major;
    private String tel;
    private String email;


    public UserItem() {
        this.stuNo = "";
        this.stuName = "";
        this.userName = "";
        this.userPwd = "";
        this.nianJi = "";
        this.xueYuan ="";
        this.major ="";
        this.tel = "";
        this.email ="";
    }

    public UserItem(String stuNo, String stuName, String userName, String userPwd,String nianJi, String xueYuan,String major, String tel, String email) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.userName = userName;
        this.userPwd = userPwd;
        this.nianJi = nianJi;
        this.xueYuan = xueYuan;
        this.major =major;
        this.tel = tel;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getNianJi() {
        return nianJi;
    }

    public void setNianJi(String nianJi) {
        this.nianJi = nianJi;
    }

    public String getXueYuan() {

        return xueYuan;
    }

    public void setXueYuan(String xueYuan) {
        this.xueYuan = xueYuan;
    }
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

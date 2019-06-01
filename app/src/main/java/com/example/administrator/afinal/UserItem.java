package com.example.administrator.afinal;

public class UserItem {
    private int id;
    private String userName;
    private String userPwd;

    public UserItem() {
        this.userName = "";
        this.userPwd = "";
    }

    public UserItem(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
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
}

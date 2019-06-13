package com.example.administrator.afinal;

public class AttendItem {
    private int id;
    private String hdname;
    private String username;
    private String judge;

    public AttendItem() {
        this.hdname ="";
        this.username = "";
        this.judge = "" ;
    }

    public AttendItem(String hdname, String username,String judge) {
        this.hdname = hdname;
        this.username = username;
        this.judge =judge;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHdname() {
        return hdname;
    }

    public void setHdname(String hdname) {
        this.hdname = hdname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge;
    }
}

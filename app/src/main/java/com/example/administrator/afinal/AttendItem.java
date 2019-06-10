package com.example.administrator.afinal;

public class AttendItem {
    private int id;
    private String hdname;
    private String username;

    public AttendItem() {
        this.hdname ="";
        this.username = "";
    }

    public AttendItem(String hdname, String username) {
        this.hdname = hdname;
        this.username = username;
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
}

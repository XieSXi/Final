package com.example.administrator.afinal;

public class StuItem {
    private int id;
    private String stuno;
    private String stuname;

    public StuItem() {
        this.stuno = "";
        this.stuname = "";
    }
    public StuItem(String stuno, String stuname) {
        this.stuno = stuno;
        this.stuname = stuname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuno() {
        return stuno;
    }

    public void setStuno(String stuno) {
        this.stuno = stuno;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }
}

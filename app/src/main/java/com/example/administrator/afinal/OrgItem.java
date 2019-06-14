package com.example.administrator.afinal;

public class OrgItem {
    private int id;
    private String orgname;
    private String orgpwd;

    public OrgItem(String orgname, String orgpwd) {
        this.orgname = orgname;
        this.orgpwd = orgpwd;
    }
    public OrgItem() {
        this.orgname = "";
        this.orgpwd = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getOrgpwd() {
        return orgpwd;
    }

    public void setOrgpwd(String orgpwd) {
        this.orgpwd = orgpwd;
    }
}

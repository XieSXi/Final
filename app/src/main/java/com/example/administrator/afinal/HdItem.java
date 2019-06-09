package com.example.administrator.afinal;

public class HdItem {
    private int id;
    private String hdorg;
    private String hdname;
    private String hdtime;
    private String hdcontent;
    private String hdplace;
    private String hdrequests;
    private String hdrenshu;
    private String hdattention;
    private String hdtrain;
    private String hdpay;
    private String hdyue;
    private String hdri;
    private String hdshi;
    private String hdfen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getHdorg() {
        return hdorg;
    }

    public void setHdorg( String hdorg) {
        this.hdorg = hdorg;
    }

    public String getHdname() {
        return hdname;
    }

    public void setHdname(String hdname) {
        this.hdname = hdname;
    }

    public String getHdtime() {
        return hdtime;
    }

    public void setHdtime(String hdtime) {
        this.hdtime = hdtime;
    }

    public String getHdcontent() {
        return hdcontent;
    }

    public void setHdcontent(String hdcontent) {
        this.hdcontent = hdcontent;
    }

    public String getHdplace() {
        return hdplace;
    }

    public void setHdplace(String hdplace) {
        this.hdplace = hdplace;
    }

    public String getHdrequests() {
        return hdrequests;
    }

    public void setHdrequests(String hdrequests) {
        this.hdrequests = hdrequests;
    }

    public String getHdrenshu() {
        return hdrenshu;
    }

    public void setHdrenshu(String hdrenshu) {
        this.hdrenshu = hdrenshu;
    }

    public String getHdattention() {
        return hdattention;
    }

    public void setHdattention(String hdattention) {
        this.hdattention = hdattention;
    }

    public String getHdtrain() {
        return hdtrain;
    }

    public void setHdtrain(String hdtrain) {
        this.hdtrain = hdtrain;
    }

    public String getHdpay() {
        return hdpay;
    }

    public void setHdpay(String hdpay) {
        this.hdpay = hdpay;
    }

    public String getHdyue() {
        return hdyue;
    }

    public void setHdyue(String hdyue) {
        this.hdyue = hdyue;
    }

    public String getHdri() {
        return hdri;
    }

    public void setHdri(String hdri) {
        this.hdri = hdri;
    }

    public String getHdshi() {
        return hdshi;
    }

    public void setHdshi(String hdshi) {
        this.hdshi = hdshi;
    }

    public String getHdfen() {
        return hdfen;
    }

    public void setHdfen(String hdfen) {
        this.hdfen = hdfen;
    }

    public HdItem(String hdorg,String hdname, String hdtime, String hdcontent, String hdplace, String hdrequests, String hdrenshu, String hdattention, String hdtrain, String hdpay, String hdyue, String hdri, String hdshi, String hdfen) {
        this.hdorg = hdorg;
        this.hdname = hdname;
        this.hdtime = hdtime;
        this.hdcontent = hdcontent;
        this.hdplace = hdplace;

        this.hdrequests = hdrequests;
        this.hdrenshu = hdrenshu;
        this.hdattention = hdattention;
        this.hdtrain = hdtrain;
        this.hdpay = hdpay;
        this.hdyue = hdyue;
        this.hdri = hdri;
        this.hdshi = hdshi;
        this.hdfen = hdfen;
    }



    public HdItem() {
        this.hdorg = "";
        this.hdname = "";
        this.hdtime = "";
        this.hdcontent ="";
        this.hdplace = "";

        this.hdrequests = "";
        this.hdrenshu = "";
        this.hdattention = "";
        this.hdtrain = "";
        this.hdpay = "";
        this.hdyue = "";
        this.hdri = "";
        this.hdshi ="";
        this.hdfen = "";
    }



}

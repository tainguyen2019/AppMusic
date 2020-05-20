package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TheLoai implements Serializable {

    @SerializedName("IDTheLoai")
    @Expose
    private String iDTheLoai;
    @SerializedName("IDChuDe")
    @Expose
    private String iDChuDe;
    @SerializedName("TenTheLoai")
    @Expose
    private String tenTheLoai;
    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;

    public TheLoai(String iDTheLoai, String iDChuDe, String tenTheLoai, String hinhNen) {
        this.iDTheLoai = iDTheLoai;
        this.iDChuDe = iDChuDe;
        this.tenTheLoai = tenTheLoai;
        this.hinhNen = hinhNen;
    }

    public String getIDTheLoai() {
        return iDTheLoai;
    }

    public void setIDTheLoai(String iDTheLoai) {
        this.iDTheLoai = iDTheLoai;
    }

    public String getIDChuDe() {
        return iDChuDe;
    }

    public void setIDChuDe(String iDChuDe) {
        this.iDChuDe = iDChuDe;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

    public String getHinhNen() {
        return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
        this.hinhNen = hinhNen;
    }

}
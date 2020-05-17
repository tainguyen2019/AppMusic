package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe {
    @SerializedName("IDChuDe")
    @Expose
    private String id;

    @SerializedName("TenChuDe")
    @Expose
    private String name;

    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;

    private Integer soBaiHat;

    public ChuDe() {
    }

    public ChuDe(String id) {
        this.id = id;
    }

    public ChuDe(String id, String name, String hinhNen, Integer soBaiHat) {
        this.id = id;
        this.name = name;
        this.hinhNen = hinhNen;
        this.soBaiHat = soBaiHat;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHinhNen() {
        return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
        this.hinhNen = hinhNen;
    }

    public Integer getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(Integer soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    @Override
    public String toString() {
        return "ChuDe{" +
                "iDChuDe='" + id + '\'' +
                ", tenChuDe='" + name + '\'' +
                ", hinhNen='" + hinhNen + '\'' +
                ", soBaiHat=" + soBaiHat +
                '}';
    }
}
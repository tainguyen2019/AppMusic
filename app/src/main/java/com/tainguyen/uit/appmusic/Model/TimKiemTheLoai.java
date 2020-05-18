package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemTheLoai {
    @SerializedName("IDTheLoai")
    @Expose
    private String id;
    @SerializedName("IDChuDe")
    @Expose
    private String idChude;
    @SerializedName("TenTheLoai")
    @Expose
    private String name;
    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;

    private Integer soBaiHat;

    public TimKiemTheLoai() {
    }

    public TimKiemTheLoai(String id) {
        this.id = id;
    }

    public TimKiemTheLoai(String id, String idChude, String name, String hinhNen, Integer soBaiHat) {
        this.id = id;
        this.idChude = idChude;
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

    public String getIdChude() {
        return idChude;
    }

    public void setIdChude(String idChude) {
        this.idChude = idChude;
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
        return "TimKiemTheLoai{" +
                "iDTheLoai='" + id + '\'' +
                ", iDChuDe='" + idChude + '\'' +
                ", tenTheLoai='" + name + '\'' +
                ", hinhNen='" + hinhNen + '\'' +
                ", soBaiHat=" + soBaiHat +
                '}';
    }
}
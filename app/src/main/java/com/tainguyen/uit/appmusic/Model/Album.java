package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("casi")
    @Expose
    private String caSi;

    @SerializedName("hinhnen")
    @Expose
    private String hinhNen;

    @SerializedName("sobaihat")
    @Expose
    private Integer soBaihat;

    public Album() {
    }

    public Album(String id) {
        this.id = id;
    }

    public Album(String id, String name, String caSi, String hinhNen, int soBaihat) {
        this.id = id;
        this.name = name;
        this.caSi = caSi;
        this.hinhNen = hinhNen;
        this.soBaihat = soBaihat;
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

    public String getCaSi() {
        return caSi;
    }

    public void setCaSi(String caSi) {
        this.caSi = caSi;
    }

    public String getHinhNen() {
        return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
        this.hinhNen = hinhNen;
    }

    public Integer getSoBaihat() {
        return soBaihat;
    }

    public void setSoBaihat(Integer soBaihat) {
        this.soBaihat = soBaihat;
    }

    @Override
    public String toString() {
        return "Album{" +
                "iDAlbum='" + id + '\'' +
                ", tenAlbum='" + name + '\'' +
                ", caSi='" + caSi + '\'' +
                ", hinhNen='" + hinhNen + '\'' +
                ", soBaihat=" + soBaihat +
                '}';
    }
}
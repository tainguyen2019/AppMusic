package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemPlaylist {
    @SerializedName("IDPlaylist")
    @Expose
    private String id;

    @SerializedName("TenPlaylist")
    @Expose
    private String name;

    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;

    public TimKiemPlaylist() {
    }

    public TimKiemPlaylist(String id) {
        this.id = id;
    }

    public TimKiemPlaylist(String id, String name, String hinhNen) {
        this.id = id;
        this.name = name;
        this.hinhNen = hinhNen;
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

    @Override
    public String toString() {
        return "TimKiemPlaylist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hinhNen='" + hinhNen + '\'' +
                '}';
    }
}
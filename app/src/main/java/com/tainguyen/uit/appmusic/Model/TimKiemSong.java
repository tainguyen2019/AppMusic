package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemSong {
    @SerializedName("IDBaiHat")
    @Expose
    private String id;

    @SerializedName("TenBaiHat")
    @Expose
    private String name;

    @SerializedName("CaSi")
    @Expose
    private String caSi;

    @SerializedName("HinhAnh")
    @Expose
    private String hinhAnh;

    @SerializedName("LinkBaiHat")
    @Expose
    private String linkBaiHat;

    @SerializedName("LuotNghe")
    @Expose
    private String luotNghe;

    public TimKiemSong() {
    }

    public TimKiemSong(String id) {
        this.id = id;
    }

    public TimKiemSong(String id, String name, String caSi, String hinhAnh, String linkBaiHat, String luotNghe) {
        this.id = id;
        this.name = name;
        this.caSi = caSi;
        this.hinhAnh = hinhAnh;
        this.linkBaiHat = linkBaiHat;
        this.luotNghe = luotNghe;
    }

    public String getIDBaiHat() {
        return id;
    }

    public void setIDBaiHat(String iDBaiHat) {
        this.id = iDBaiHat;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getLinkBaiHat() {
        return linkBaiHat;
    }

    public void setLinkBaiHat(String linkBaiHat) {
        this.linkBaiHat = linkBaiHat;
    }

    public String getLuotNghe() {
        return luotNghe;
    }

    public void setLuotNghe(String luotNghe) {
        this.luotNghe = luotNghe;
    }

    @Override
    public String toString() {
        return "TimKiemSong{" +
                "iDBaiHat='" + id + '\'' +
                ", tenBaiHat='" + name + '\'' +
                ", caSi='" + caSi + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", linkBaiHat='" + linkBaiHat + '\'' +
                ", luotNghe='" + luotNghe + '\'' +
                '}';
    }
}
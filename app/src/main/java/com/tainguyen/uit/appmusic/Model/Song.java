package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

    @SerializedName("IDBaiHat")
    @Expose
    private String iDBaiHat;
    @SerializedName("TenBaiHat")
    @Expose
    private String tenBaiHat;
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

    public String getIDBaiHat() {
        return iDBaiHat;
    }

    public void setIDBaiHat(String iDBaiHat) {
        this.iDBaiHat = iDBaiHat;
    }

    public String getTenBaiHat() {
        return tenBaiHat;
    }

    public void setTenBaiHat(String tenBaiHat) {
        this.tenBaiHat = tenBaiHat;
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

}
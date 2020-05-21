package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemPlaylist {

    @SerializedName("IDPlaylist")
    @Expose
    private String iDPlaylist;
    @SerializedName("TenPlaylist")
    @Expose
    private String tenPlaylist;
    @SerializedName("HinhNen")
    @Expose
    private String hinhNen;
    @SerializedName("sobaihat")
    @Expose
    private String sobaihat;

    public String getIDPlaylist() {
        return iDPlaylist;
    }

    public void setIDPlaylist(String iDPlaylist) {
        this.iDPlaylist = iDPlaylist;
    }

    public String getTenPlaylist() {
        return tenPlaylist;
    }

    public void setTenPlaylist(String tenPlaylist) {
        this.tenPlaylist = tenPlaylist;
    }

    public String getHinhNen() {
        return hinhNen;
    }

    public void setHinhNen(String hinhNen) {
        this.hinhNen = hinhNen;
    }

    public String getSobaihat() {
        return sobaihat;
    }

    public void setSobaihat(String sobaihat) {
        this.sobaihat = sobaihat;
    }

}
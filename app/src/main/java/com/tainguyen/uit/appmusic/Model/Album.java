package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Album implements Serializable {

@SerializedName("IDAlbum")
@Expose
private String iDAlbum;
@SerializedName("TenAlbum")
@Expose
private String tenAlbum;
@SerializedName("CaSi")
@Expose
private String caSi;
@SerializedName("HinhNen")
@Expose
private String hinhNen;

    public Album(String iDAlbum, String tenAlbum, String caSi, String hinhNen) {
        this.iDAlbum = iDAlbum;
        this.tenAlbum = tenAlbum;
        this.caSi = caSi;
        this.hinhNen = hinhNen;
    }

    public String getIDAlbum() {
return iDAlbum;
}

public void setIDAlbum(String iDAlbum) {
this.iDAlbum = iDAlbum;
}

public String getTenAlbum() {
return tenAlbum;
}

public void setTenAlbum(String tenAlbum) {
this.tenAlbum = tenAlbum;
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

}
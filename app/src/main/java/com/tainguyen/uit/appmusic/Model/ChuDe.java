package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ChuDe implements Serializable {

@SerializedName("IDChuDe")
@Expose
private String iDChuDe;
@SerializedName("TenChuDe")
@Expose
private String tenChuDe;
@SerializedName("HinhNen")
@Expose
private String hinhNen;

    public ChuDe(String iDChuDe, String tenChuDe, String hinhNen) {
        this.iDChuDe = iDChuDe;
        this.tenChuDe = tenChuDe;
        this.hinhNen = hinhNen;
    }

    public String getIDChuDe() {
return iDChuDe;
}

public void setIDChuDe(String iDChuDe) {
this.iDChuDe = iDChuDe;
}

public String getTenChuDe() {
return tenChuDe;
}

public void setTenChuDe(String tenChuDe) {
this.tenChuDe = tenChuDe;
}

public String getHinhNen() {
return hinhNen;
}

public void setHinhNen(String hinhNen) {
this.hinhNen = hinhNen;
}

}
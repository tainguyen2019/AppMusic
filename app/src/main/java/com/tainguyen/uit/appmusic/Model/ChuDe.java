package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDe {

@SerializedName("IDChuDe")
@Expose
private String iDChuDe;
@SerializedName("TenChuDe")
@Expose
private String tenChuDe;
@SerializedName("HinhNen")
@Expose
private String hinhNen;

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
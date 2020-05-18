package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemSong {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("casi")
    @Expose
    private String caSi;

    @SerializedName("hinhanh")
    @Expose
    private String hinhAnh;

    @SerializedName("link")
    @Expose
    private String linkBaiHat;

    @SerializedName("luotnghe")
    @Expose
    private String luotNghe;

    @SerializedName("idAlbum")
    @Expose
    private String idAlbum;

    @SerializedName("idTheloai")
    @Expose
    private String idTheloai;

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

    public TimKiemSong(String id, String name, String caSi, String hinhAnh, String linkBaiHat, String luotNghe, String idAlbum, String idTheloai) {
        this.id = id;
        this.name = name;
        this.caSi = caSi;
        this.hinhAnh = hinhAnh;
        this.linkBaiHat = linkBaiHat;
        this.luotNghe = luotNghe;
        this.idAlbum = idAlbum;
        this.idTheloai = idTheloai;
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

    public String getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(String idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getIdTheloai() {
        return idTheloai;
    }

    public void setIdTheloai(String idTheloai) {
        this.idTheloai = idTheloai;
    }

    @Override
    public String toString() {
        return "TimKiemSong{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", caSi='" + caSi + '\'' +
                ", hinhAnh='" + hinhAnh + '\'' +
                ", linkBaiHat='" + linkBaiHat + '\'' +
                ", luotNghe='" + luotNghe + '\'' +
                ", idAlbum='" + idAlbum + '\'' +
                ", idTheloai='" + idTheloai + '\'' +
                '}';
    }
}
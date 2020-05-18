package com.tainguyen.uit.appmusic.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TimKiemNgheSi {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("sobaihat")
    @Expose
    private Integer soBaihat;

    @SerializedName("soalbum")
    @Expose
    private Integer soAlbum;

    @SerializedName("sotheloai")
    @Expose
    private Integer soTheloai;

    @SerializedName("soluotnghe")
    @Expose
    private Integer soLuotnghe;

    @SerializedName("sochude")
    @Expose
    private Integer soChude;

    @SerializedName("hinhnen")
    @Expose
    private String hinhnen;

    public TimKiemNgheSi() {
    }

    public TimKiemNgheSi(String id) {
        this.id = id;
    }

    public TimKiemNgheSi(String id, String name, Integer soBaihat, Integer soAlbum, Integer soTheloai, Integer soLuotnghe, Integer soChude, String hinhnen) {
        this.id = id;
        this.name = name;
        this.soBaihat = soBaihat;
        this.soAlbum = soAlbum;
        this.soTheloai = soTheloai;
        this.soLuotnghe = soLuotnghe;
        this.soChude = soChude;
        this.hinhnen = hinhnen;
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

    public Integer getSoBaihat() {
        return soBaihat;
    }

    public void setSoBaihat(Integer soBaihat) {
        this.soBaihat = soBaihat;
    }

    public Integer getSoAlbum() {
        return soAlbum;
    }

    public void setSoAlbum(Integer soAlbum) {
        this.soAlbum = soAlbum;
    }

    public Integer getSoTheloai() {
        return soTheloai;
    }

    public void setSoTheloai(Integer soTheloai) {
        this.soTheloai = soTheloai;
    }

    public Integer getSoLuotnghe() {
        return soLuotnghe;
    }

    public void setSoLuotnghe(Integer soLuotnghe) {
        this.soLuotnghe = soLuotnghe;
    }

    public Integer getSoChude() {
        return soChude;
    }

    public void setSoChude(Integer soChude) {
        this.soChude = soChude;
    }

    public String getHinhnen() {
        return hinhnen;
    }

    public void setHinhnen(String hinhnen) {
        this.hinhnen = hinhnen;
    }

    @Override
    public String toString() {
        return "TimKiemNgheSi{" +
                "idNgheSi='" + id + '\'' +
                ", ten='" + name + '\'' +
                ", soBaihat=" + soBaihat +
                ", soAlbum=" + soAlbum +
                ", soTheloai=" + soTheloai +
                ", soLuotnghe=" + soLuotnghe +
                ", soChude=" + soChude +
                ", hinhnen='" + hinhnen + '\'' +
                '}';
    }
}

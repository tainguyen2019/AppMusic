package com.tainguyen.uit.appmusic.Model;

import android.os.Parcel;
import android.os.Parcelable;
//import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song implements Parcelable {

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

    protected Song(Parcel in) {
        iDBaiHat = in.readString();
        tenBaiHat = in.readString();
        caSi = in.readString();
        hinhAnh = in.readString();
        linkBaiHat = in.readString();
        luotNghe = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(iDBaiHat);
        dest.writeString(tenBaiHat);
        dest.writeString(caSi);
        dest.writeString(hinhAnh);
        dest.writeString(linkBaiHat);
        dest.writeString(luotNghe);
    }
}
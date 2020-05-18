package com.tainguyen.uit.appmusic.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuDeTheLoai {
    @SerializedName("TimKiemTheLoai")
    @Expose
    private List<TimKiemTheLoai> timKiemTheLoai = null;

    @SerializedName("TimKiemChuDe")
    @Expose
    private List<TimKiemChuDe> timKiemChuDe = null;

    public List<TimKiemTheLoai> getTimKiemTheLoai() {
    return timKiemTheLoai;
    }

    public void setTimKiemTheLoai(List<TimKiemTheLoai> timKiemTheLoai) {
    this.timKiemTheLoai = timKiemTheLoai;
    }

    public List<TimKiemChuDe> getTimKiemChuDe() {
    return timKiemChuDe;
    }

    public void setTimKiemChuDe(List<TimKiemChuDe> timKiemChuDe) {
    this.timKiemChuDe = timKiemChuDe;
    }

    @Override
    public String toString() {
        return "ChuDeTheLoai{" +
                "timKiemTheLoai=" + timKiemTheLoai +
                ", timKiemChuDe=" + timKiemChuDe +
                '}';
    }
}
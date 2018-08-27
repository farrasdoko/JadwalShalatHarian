package com.gmail.farrasabiyyu12.jadwalshalatharian.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetJadwal {
    @SerializedName("status_description")
    String status_description;
    @SerializedName("items")
    List<Jadwal> listDataJadwal;
//    @SerializedName("message")
//    String message;
    public String getStatus_description() {
        return status_description;
    }
    public void setStatus_description(String status_description) {
        this.status_description = status_description;
    }

//    public String getMessage() {
//        return message;
//    }
//    public void setMessage(String message) {
//        this.message = message;
//    }


    public List<Jadwal> getListDataJadwal() {
        return listDataJadwal;
    }
    public void setListDataJadwal(List<Jadwal> listDataJadwal) {
        this.listDataJadwal = listDataJadwal;
    }
}
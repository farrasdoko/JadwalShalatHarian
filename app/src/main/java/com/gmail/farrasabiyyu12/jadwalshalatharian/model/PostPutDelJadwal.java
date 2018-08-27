package com.gmail.farrasabiyyu12.jadwalshalatharian.model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelJadwal {
        @SerializedName("status_description")
        String status_description;
        @SerializedName("items")
        Jadwal mJadwal;
//        @SerializedName("message")
//        String message;
        public String getStatus_description() {
            return status_description;
        }
        public void setStatus_description(String status_description) {
            this.status_description = status_description;
        }
//        public String getMessage() {
//            return message;
//        }
//        public void setMessage(String message) {
//            this.message = message;
//        }
        public Jadwal getJadwal() {
            return mJadwal;
        }
        public void setJadwal(Jadwal jadwal) {
            mJadwal = jadwal;
        }

}
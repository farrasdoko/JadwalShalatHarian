package com.gmail.farrasabiyyu12.jadwalshalatharian.rest;

import com.gmail.farrasabiyyu12.jadwalshalatharian.model.GetJadwal;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("d1aa7cdf5e8c0d2d7f1f47811497a732")
    Call<GetJadwal> getJadwal();

}
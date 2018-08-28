package com.gmail.farrasabiyyu12.jadwalshalatharian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jadwalshalatharian.adapter.JadwalAdapter;
import com.gmail.farrasabiyyu12.jadwalshalatharian.model.ItemsItem;
import com.gmail.farrasabiyyu12.jadwalshalatharian.model.ResponseJadwal;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiClient;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    //TODO Declare
    TextView tv_kota;
    RecyclerView rc_item;
    RecyclerView.Adapter mAdapter;
    ApiInterface mApiInterface;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TODO Bind TextView
        tv_kota = findViewById(R.id.tv_kota);

        //TODO Bind RecyclerView
        rc_item = findViewById(R.id.rc_jadwal);

        //TODO Other
        mLayoutManager = new LinearLayoutManager(this);
        rc_item.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        //TODO Get Data
        getData();
    }

    //TODO set up getData
    private void getData() {
        Call<ResponseJadwal> jadwalCall = mApiInterface.getJadwal();
        jadwalCall.enqueue(new Callback<ResponseJadwal>() {
            @Override
            public void onResponse(Call<ResponseJadwal> call, Response<ResponseJadwal> response) {
                if (response.body().getStatusCode()==1) {
                    List<ItemsItem> JadwalList = response.body().getItems();
                    Log.d("Retrofit Get", "Jumlah data Jadwal Shalat: " +
                            String.valueOf(JadwalList.size()));
                    mAdapter = new JadwalAdapter(JadwalList);
                    rc_item.setAdapter(mAdapter);
                    tv_kota.setText(response.body().getState() + ", " + response.body().getCountry() + " " + response.body().getCountryCode());

            }

            }

            @Override
            public void onFailure(Call<ResponseJadwal> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}

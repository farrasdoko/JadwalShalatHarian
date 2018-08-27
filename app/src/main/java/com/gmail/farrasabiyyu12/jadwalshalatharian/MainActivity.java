package com.gmail.farrasabiyyu12.jadwalshalatharian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jadwalshalatharian.model.ItemsItem;
import com.gmail.farrasabiyyu12.jadwalshalatharian.model.ResponseJadwal;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiClient;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv_judul_shubuh, tv_judul_dzuhur, tv_judul_ashar, tv_judul_maghrib, tv_judul_isya, tv_info_shubuh, tv_info_dzuhur,
            tv_info_ashar, tv_info_maghrib, tv_info_isya, tv_kota, tv_tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info_shubuh = findViewById(R.id.tv_info_shubuh);
        tv_info_dzuhur = findViewById(R.id.tv_info_dzuhur);
        tv_info_ashar = findViewById(R.id.tv_info_ashar);
        tv_info_maghrib = findViewById(R.id.tv_info_maghrib);
        tv_info_isya = findViewById(R.id.tv_info_isya);
        tv_kota = findViewById(R.id.tv_kota);
        tv_tanggal = findViewById(R.id.tv_tanggal);

        getData();
    }

    private void getData() {
        ApiInterface api = ApiClient.getInstance();
        Call<ResponseJadwal> call = api.getJadwal();
        call.enqueue(new Callback<ResponseJadwal>() {
            @Override
            public void onResponse(Call<ResponseJadwal> call, Response<ResponseJadwal> response) {
                if (response.body().getStatusCode()==1) {
                    List<ItemsItem> mJadwalList = response.body().getItems();
                    tv_info_shubuh.setText(mJadwalList.get(0).getFajr());
                    tv_info_dzuhur.setText(mJadwalList.get(0).getDhuhr());
                    tv_info_ashar.setText(mJadwalList.get(0).getAsr());
                    tv_info_maghrib.setText(mJadwalList.get(0).getMaghrib());
                    tv_info_isya.setText(mJadwalList.get(0).getIsha());
                    tv_tanggal.setText(mJadwalList.get(0).getDateFor());

                    tv_kota.setText(response.body().getState() + ", " + response.body().getCountry() + " " + response.body().getCountryCode());

            }
            }

            @Override
            public void onFailure(Call<ResponseJadwal> call, Throwable t) {

            }
        });
    }
}

package com.gmail.farrasabiyyu12.jadwalshalatharian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.gmail.farrasabiyyu12.jadwalshalatharian.model.GetJadwal;
import com.gmail.farrasabiyyu12.jadwalshalatharian.model.Jadwal;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiClient;
import com.gmail.farrasabiyyu12.jadwalshalatharian.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextView tv_judul_shubuh, tv_judul_dzuhur, tv_judul_ashar, tv_judul_maghrib, tv_judul_isya, tv_info_shubuh, tv_info_dzuhur,
            tv_info_ashar, tv_info_maghrib, tv_info_isya;

    List<Jadwal> mJadwalList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_info_shubuh = findViewById(R.id.tv_info_shubuh);

//        String api_shalat_shubuh = mJadwalList.get(0).getFajr();

//        tv_info_shubuh.setText(api_shalat_shubuh);
    }

    private void getData() {
        ApiInterface api = ApiClient.getInstance();
        Call<GetJadwal> call = api.getJadwal();
        call.enqueue(new Callback<GetJadwal>() {
            @Override
            public void onResponse(Call<GetJadwal> call, Response<GetJadwal> response) {
                if (response.body().getStatus_description()=="Success.") {
//                    tv_info_shubuh.setText(response.body().getStatus_description());
                    tv_info_shubuh.setText(mJadwalList.get(0).getFajr());
                }
            }

            @Override
            public void onFailure(Call<GetJadwal> call, Throwable t) {

            }
        });
    }
}

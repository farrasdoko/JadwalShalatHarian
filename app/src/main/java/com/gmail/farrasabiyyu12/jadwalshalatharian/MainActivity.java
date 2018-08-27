package com.gmail.farrasabiyyu12.jadwalshalatharian;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_judul_shubuh, tv_judul_dzuhur, tv_judul_ashar, tv_judul_maghrib, tv_judul_isya, tv_info_shubuh, tv_info_dzuhur,
            tv_info_ashar, tv_info_maghrib, tv_info_isya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv_info_shubuh.setText(getFajr);
    }
}

package com.example.kursusadzan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;


import com.example.kursusadzan2.data.RecyclerViewAdapter;
import com.example.kursusadzan2.data.model.AdzanResponse;
import com.example.kursusadzan2.data.remote.AdzanService;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);



        //memanggil adzanservis metho get api

        AdzanService.getAPI()
                .getPrayerTimeByCity("Makassar", "ID")
                .enqueue(new Callback<AdzanResponse>() {
                    @Override
                    public void onResponse(Call<AdzanResponse> call, Response<AdzanResponse> response) {
                        if (response.isSuccessful()) {
                            List<AdzanResponse.DataBean> dataBeans = response.body().getData();

                            for (AdzanResponse.DataBean dataBean : dataBeans) {
                                AdzanResponse.DataBean.TimingsBean timingsBean = dataBean.getTimings();
                                AdzanResponse.DataBean.DateBean dateBean = dataBean.getDate();
                                AdzanResponse.DataBean.MetaBean metaBean = dataBean.getMeta();

                                Log.d("Jadwal Sholat Subuh ", timingsBean.getFajr() + "in "
                                        + dateBean.getReadable() + " Kota "
                                        + metaBean.getTimezone());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AdzanResponse> call, Throwable t) {
                        Log.e("pesan gagal", t.getMessage());
                    }
                });
    }
}
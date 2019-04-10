package com.example.kursusadzan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.renderscript.RenderScript;
import android.util.Log;
import android.view.View;


import com.example.kursusadzan2.data.RecyclerViewAdapter;
import com.example.kursusadzan2.data.model.APIEndpoint;
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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        AdzanService.getAPI()
                .getPrayerTimeByCity("Makassar", "ID")
                .enqueue(new Callback<AdzanResponse>() {
                    @Override
                    public void onResponse(Call<AdzanResponse> call, Response<AdzanResponse> response) {
                        if (response.isSuccessful()) {
                            List<AdzanResponse.DataBean> list = response.body().getData();
                            adapter = new RecyclerViewAdapter(list);
                            recyclerView.setAdapter(adapter);

                        }
                    }

                    @Override
                    public void onFailure(Call<AdzanResponse> call, Throwable t) {
                        Log.e("pesan gagal", t.getMessage());
                    }
                });
    }
}
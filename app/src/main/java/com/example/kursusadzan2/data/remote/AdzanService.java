package com.example.kursusadzan2.data.remote;

import com.example.kursusadzan2.data.model.APIEndpoint;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AdzanService {
    public static final String BASE_URL = "http://api.aladhan.com/v1/";

    private Retrofit retrofit;

    public static APIEndpoint getAPI() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(APIEndpoint.class);
    }

}

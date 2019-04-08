package com.example.kursusadzan2.data.model;

import com.example.kursusadzan2.data.model.AdzanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIEndpoint {

    @GET("calendarByCity")
    Call<AdzanResponse> getPrayerTimeByCity(
            @Query("city") String city,
            @Query("country") String country
    );


}

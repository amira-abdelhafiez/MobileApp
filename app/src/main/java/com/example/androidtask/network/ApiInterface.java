package com.example.androidtask.network;

import com.example.androidtask.model.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("/api/v1/cars")
    Call<ApiResponse> GetCars(@Query("page") int PageNo);
}

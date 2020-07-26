package com.example.androidtask.model;

import android.util.Log;

import com.example.androidtask.network.ApiClient;
import com.example.androidtask.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCarsModel implements IModel {
    @Override
    public void getCarsList(OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ApiResponse> call = apiService.GetCars(pageNo);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d("Amira" , response.toString());
                List<Car> cars = response.body().getData();
                Log.d("Amira" , cars.toString());
                onFinishedListener.onFinished(cars);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("Amira" , t.getMessage());
                onFinishedListener.onFailure(t);
            }
        });
    }
}

package com.example.androidtask.model;

import android.util.Log;

import com.example.androidtask.network.ApiClient;
import com.example.androidtask.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCarsModel implements IModel {
    private static final String DEBUG_TAG = GetCarsModel.class.getSimpleName();
    @Override
    public void getCarsList(OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<ApiResponse> call = apiService.GetCars(pageNo);
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                Log.d(DEBUG_TAG , response.toString());
                List<Car> cars = new ArrayList<>();
                if(response.body().getStatus() == 1){
                    cars = response.body().getData();
                    Log.d(DEBUG_TAG , cars.toString());
                }
                onFinishedListener.onFinished(cars);
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d(DEBUG_TAG , t.getMessage());
                onFinishedListener.onFailure(t);
            }
        });
    }
}

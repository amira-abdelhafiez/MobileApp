package com.example.androidtask.view;

import com.example.androidtask.model.Car;

import java.util.List;

public interface IView {

    void showProgress();

    void hideProgress();

    void setDataToRecyclerView(List<Car> CarArrayList);

    void onResponseFailure(Throwable throwable);
}

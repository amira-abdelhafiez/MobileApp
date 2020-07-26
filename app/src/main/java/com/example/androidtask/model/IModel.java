package com.example.androidtask.model;

import java.util.List;

public interface IModel {
    interface OnFinishedListener {
        void onFinished(List<Car> carsList);

        void onFailure(Throwable t);
    }

    void getCarsList(OnFinishedListener onFinishedListener, int pageNo);
}

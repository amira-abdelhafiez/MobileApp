package com.example.androidtask.presenter;

import com.example.androidtask.model.Car;
import com.example.androidtask.model.GetCarsModel;
import com.example.androidtask.model.IModel;
import com.example.androidtask.view.IView;

import java.util.List;

public class CarsPresenter implements IPresenter , IModel.OnFinishedListener {
    private IView carsListView;

    private IModel carsListModel;

    public CarsPresenter(IView carsListView) {
        this.carsListView = carsListView;
        this.carsListModel = new GetCarsModel();
    }

    @Override
    public void onDestroy() {
        this.carsListView = null;
    }

    @Override
    public void getNextPage(int pageNo) {

        if (carsListView != null) {
            carsListView.showProgress();
        }
        carsListModel.getCarsList(this, pageNo);
    }

    @Override
    public void requestDataFromServer() {

        if (carsListView != null) {
            carsListView.showProgress();
        }
        carsListModel.getCarsList(this, 1);
    }

    @Override
    public void onFinished(List<Car> CarArrayList) {
        carsListView.setDataToRecyclerView(CarArrayList);
        if (carsListView != null) {
            carsListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {

        carsListView.onResponseFailure(t);
        if (carsListView != null) {
            carsListView.hideProgress();
        }
    }
}

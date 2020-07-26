package com.example.androidtask.presenter;

public interface IPresenter {
    void onDestroy();

    void getNextPage(int pageNo);

    void requestDataFromServer();
}

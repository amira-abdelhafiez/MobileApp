package com.example.androidtask.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidtask.R;
import com.example.androidtask.adapter.CarsAdapter;
import com.example.androidtask.model.Car;
import com.example.androidtask.presenter.CarsPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView{

    @BindView(R.id.scrollview)
    NestedScrollView scrollView;
    @BindView(R.id.recView)
    RecyclerView recyclerView;
    @BindView(R.id.pb_loader)
    ProgressBar progressBar;

    public int page = 1;
    public ArrayList<Car> dataList = new ArrayList<>();
    public CarsAdapter adapter;
    public CarsPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Binding views
        ButterKnife.bind(this);

        adapter = new CarsAdapter(this , dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL , false));

        presenter = new CarsPresenter(this);

        presenter.requestDataFromServer();
        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if(scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()){
                    page++;
                    presenter.getNextPage(page);
                }
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {

        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setDataToRecyclerView(List<Car> CarArrayList) {
        dataList.addAll(CarArrayList);
        adapter.notifyDataSetChanged();

        // No need to increase page here
        //page++;
    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Toast.makeText(this, getString(R.string.ErrorMsg), Toast.LENGTH_LONG).show();
    }
}

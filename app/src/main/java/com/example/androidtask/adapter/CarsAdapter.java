package com.example.androidtask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidtask.R;
import com.example.androidtask.model.Car;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.ItemViewHolder> {
    ArrayList<Car> data = new ArrayList();
    Context context;
    public CarsAdapter(Context context , ArrayList<Car> data){
        this.data = data;
        this.context = context;
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rec_item , parent , false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.brandTextView.setText(data.get(position).getBrand());
        holder.YearTextView.setText(data.get(position).getYear());
        holder.IsUsedTextView.setText(data.get(position).isUsed());
        Picasso.get().load(data.get(position).getImageUrl()).into(holder.imgView);
    }

    @Override
    public int getItemCount() {
        if(data != null) { return data.size();} else { return  0;}
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView brandTextView ,IsUsedTextView ,YearTextView;
        ImageView imgView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.carimg);
            brandTextView = itemView.findViewById(R.id.brand);
            IsUsedTextView = itemView.findViewById(R.id.isUsed);
            YearTextView = itemView.findViewById(R.id.year);
        }
    }
}

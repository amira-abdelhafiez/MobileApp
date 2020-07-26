package com.example.androidtask.model;

import com.google.gson.annotations.SerializedName;

public class Car {

    @SerializedName("id")
    private int id;
    @SerializedName("brand")
    private String brand;
    @SerializedName("constructionYear")
    private String year;
    @SerializedName("isUsed")
    private boolean isUsed;
    @SerializedName("imageUrl")
    private String imageUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String isUsed() {
        if(isUsed){
            return "Used";
        }else{
            return "New";
        }
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

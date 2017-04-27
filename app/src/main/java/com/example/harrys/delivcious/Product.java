package com.example.harrys.delivcious;

import android.content.Context;


public class Product {
    int images;
    String mJudul;
    String mDeskripsi;

    public Product(int images, String mJudul, String mDeskripsi) {
        this.images = images;
        this.mJudul = mJudul;
        this.mDeskripsi = mDeskripsi;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getmJudul() {
        return mJudul;
    }

    public void setmJudul(String mJudul) {
        this.mJudul = mJudul;
    }

    public String getmDeskripsi() {
        return mDeskripsi;
    }

    public void setmDeskripsi(String mDeskripsi) {
        this.mDeskripsi = mDeskripsi;
    }
}

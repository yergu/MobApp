package com.example.androidapp_development.assignment5;

import android.graphics.drawable.Drawable;

public class Model2 {
    private String name;
    private int image;

    public Model2(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}

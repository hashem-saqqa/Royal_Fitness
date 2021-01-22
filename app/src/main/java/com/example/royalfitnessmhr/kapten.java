package com.example.royalfitnessmhr;

import android.content.Context;

public class kapten {
    private int img;
    private String name;
   private Context context;

    public kapten(Context context) {
        this.context = context;
    }

    public kapten(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}

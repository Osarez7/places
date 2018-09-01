package com.example.juliosalddana.places.model.datamodels;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

public class Place {

    @DrawableRes
    int imageId;
    @StringRes
    int name;
    @StringRes
    int description;


    public Place(int imageId, int name, int description) {
        this.imageId = imageId;
        this.name = name;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }
}

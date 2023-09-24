package com.aman.bookingapp;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;

public class Villa {
    String name;
    String bedroom;
    String costPerRoom;
    String area;
    ArrayList<Drawable> villa_images;

    public Villa(String name, String bedroom, String costPerRoom, String area, ArrayList<Drawable> villa_images) {
        this.name = name;
        this.bedroom = bedroom;
        this.costPerRoom = costPerRoom;
        this.area = area;
        this.villa_images = villa_images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    public String getCostPerRoom() {
        return costPerRoom;
    }

    public void setCostPerRoom(String costPerRoom) {
        this.costPerRoom = costPerRoom;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public ArrayList<Drawable> getVilla_images() {
        return villa_images;
    }

    public void setVilla_images(ArrayList<Drawable> villa_images) {
        this.villa_images = villa_images;
    }
}

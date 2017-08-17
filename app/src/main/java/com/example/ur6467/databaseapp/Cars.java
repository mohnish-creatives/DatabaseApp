package com.example.ur6467.databaseapp;

/**
 * Created by ur6467 on 8/1/2017.
 */


/**
 * Created by Nihal on 1/24/2017.
 */

public class Cars {
    //int id;
    String name;
    String color;
    String place;

    public Cars(String color, String name, String place) {
        this.color = color;
        this.name = name;
        this.place = place;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
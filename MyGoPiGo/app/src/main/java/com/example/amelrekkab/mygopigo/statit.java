package com.example.amelrekkab.mygopigo;

/**
 * Created by Amel Rekkab on 27/12/2016.
 */

public class statit {
    private long id;
    private String distance;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    // Sera utilisée par ArrayAdapter dans la ListView
    @Override
    public String toString() {
        return distance;
    }
}

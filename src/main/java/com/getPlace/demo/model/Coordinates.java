package com.getPlace.demo.model;


public class Coordinates {
    private Double lat;
    private Double lon;
    public Coordinates(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }
    public Double getLat() {
        return lat;
    }
    public void setLat(Double lat) {
        this.lat = lat;
    }
    public Double getLon() {
        return lon;
    }
}


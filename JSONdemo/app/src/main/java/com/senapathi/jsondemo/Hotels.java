package com.senapathi.jsondemo;

public class Hotels{
    public String title;
    public double lat;
    public double  lon;

    public Hotels(){

    }


    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTitle() {
        return title;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}

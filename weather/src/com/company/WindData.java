package com.company;

import org.json.simple.JSONObject;

public class WindData {

    private double speed;
    private double deg;

    public WindData(JSONObject wind) {
        speed = (double)wind.get("speed");
        deg = (double)wind.get("deg");
    }

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    public String toString(){
        return "Wind date:" +
                "\n\tSpeed: "+getSpeed()+
                "\n\tDeg: "+getDeg();
    }
}

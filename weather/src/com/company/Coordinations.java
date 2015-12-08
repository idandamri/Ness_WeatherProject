package com.company;

import org.json.simple.JSONObject;

public class Coordinations {

    private double lon;
    private double lat;

    public Coordinations(JSONObject json) {
        lon =  Double.parseDouble(json.get("lon").toString());
        lat =  Double.parseDouble(json.get("lat").toString());
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public String toString(){
        return "\nCoordinations:\n\tlon: "+getLon()+"\n\tlat: "+getLat();
    }

    //Expand

}

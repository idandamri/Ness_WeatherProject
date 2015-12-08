package com.company;

import org.json.simple.JSONObject;

public class SunData {

    String country;
    long sunrise;
    long sunset;

    public long getSunset() {
        return sunset;
    }

    public long getSunrise() {
        return sunrise;
    }

    public String getCountry() {
        return country;
    }

    public SunData(JSONObject sys) {
        country = (String)sys.get("country");
        sunrise = (long)sys.get("sunrise");
        sunset = (long)sys.get("sunset");
    }

    public String toString(){
        return "SunData:" +
                "\n\tCountry - "+getCountry()+
                "\n\tSunrise - "+getSunrise()+
                "\n\tSunset - "+getSunset();
    }
}


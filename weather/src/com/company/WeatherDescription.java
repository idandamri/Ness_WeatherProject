package com.company;

import org.json.simple.JSONObject;

public class WeatherDescription {

    private String main;
    private String desc;

    public WeatherDescription(JSONObject weather) {
        main = (String)weather.get("main");
        desc = (String)weather.get("description");
    }

    public String getMain() {
        return main;
    }

    public String getDesc() {
        return desc;
    }

    public String toString(){
        return "Weather description:" +
                "\n\tMain: "+ getMain()+
                "\n\tDescription: "+getDesc();
    }
}

package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class City {

    private long id;
    private String name;
    private Coordinations coords;
    private SunData sundata;
    private WeatherDescription wetherDes;
    private WeatherData wetherData;
    private WindData winData;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinations getCoords() {
        return coords;
    }

    public SunData getSundata() {
        return sundata;
    }

    public WeatherDescription getWetherDes() {
        return wetherDes;
    }

    public WeatherData getWetherData() {
        return wetherData;
    }

    public WindData getWinData() {
        return winData;
    }

    public Clouds getClouds() {
        return clouds;
    }

    private Clouds clouds;


    public City(JSONObject jObj){
        id = (long)jObj.get("id");
        name = (String)jObj.get("name");
        coords = new Coordinations((JSONObject)jObj.get("coord"));
        sundata = new SunData((JSONObject)jObj.get("sys"));

        JSONObject res = null;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(jObj.get("weather").toString());
            JSONArray arr = (JSONArray)obj;
            res=(JSONObject)arr.get(0);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        wetherDes = new WeatherDescription(res);
        wetherData = new WeatherData((JSONObject)jObj.get("main"));
        winData = new WindData((JSONObject)jObj.get("wind"));
        clouds = new Clouds((JSONObject)jObj.get("clouds"));
    }

    public String toString(){
        return "\n" + name +", ID = "+ getId() +"\n------------------------\n" + getCoords() + "\n" + getSundata() +"\n"+ getWetherDes() +"\n"+ getWetherData() +"\n"+ getWinData() +"\n"+ getClouds();
    }
}

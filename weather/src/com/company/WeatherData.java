package com.company;

import org.json.simple.JSONObject;

public class WeatherData {

    private double temp;
    private long pressure;
    private long humidity;
    private double temp_min;
    private double temp_max;
    private double sea_level;
    private double grnd_level;

    public WeatherData(JSONObject main) {
        this.temp = (double)main.get("temp");
        this.pressure = (long)main.get("pressure");
        this.humidity = (long)main.get("humidity");
        this.temp_min = (double)main.get("temp_min");
        this.temp_max = (double)main.get("temp_max");
        this.sea_level = (double)main.get("sea_level");
        this.grnd_level = (double)main.get("grnd_level");
    }

    public double getTemp() {
        return temp;
    }

    public long getPressure() {
        return pressure;
    }

    public long getHumidity() {
        return humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getSea_level() {
        return sea_level;
    }

    public double getGrnd_level() {
        return grnd_level;
    }

    public String toString(){
        return "Weather Data:" +
                "\n\tTemp: " + (getTemp()-273.15) + " Celsius"+
                "\n\tPressure: " + getPressure() +
                "\n\tHumidity: " + getHumidity() +
                "\n\tMin temp: " + (getTemp_min()-273.15) + " Celsius" +
                "\n\tMax temp: " + (getTemp_max()-273.15) + " Celsius" +
                "\n\tSea_level: " + getSea_level() + " meters" +
                "\n\tGrnd_level: " + getGrnd_level() + " meters" ;


    }
}

package com.company;

import org.json.simple.JSONObject;

public class WeatherData {

    private double temp;
    private double pressure;
    private double humidity;
    private double temp_min;
    private double temp_max;
    private double sea_level;
    private double grnd_level;

    public WeatherData(JSONObject main) {
        try {
            this.temp = (double) main.get("temp");
        } catch (ClassCastException ex) {
            this.temp = (long) main.get("temp");
        }
        try {
            this.pressure = (double) main.get("pressure");
        } catch (ClassCastException ex) {
            this.pressure = (long) main.get("pressure");
        }
        try {
            this.humidity = (double) main.get("humidity");
        } catch (ClassCastException ex) {
            this.humidity = (long) main.get("humidity");
        }
        try {
            this.temp_min = (double) main.get("temp_min");
        } catch (ClassCastException ex) {
            this.temp_min = (long) main.get("temp_min");
        }
        try {
            this.temp_max = (double) main.get("temp_max");
        } catch (ClassCastException ex) {
            this.temp_max = (double) main.get("temp_max");
        }
        try {
            this.sea_level = (double) main.get("sea_level");
        } catch (ClassCastException ex) {
            this.sea_level = (long) main.get("sea_level");
        }
        catch (NullPointerException nullEx){
            sea_level = 0;
        }
        try {
            this.grnd_level = (double) main.get("grnd_level");
        } catch (ClassCastException ex) {
            this.grnd_level = (long) main.get("grnd_level");
        }
        catch (NullPointerException nullEx){
            grnd_level = 0;
        }
    }

    public double getTemp() {
        return temp;
    }

    public double getPressure() {
        return pressure;
    }

    public double getHumidity() {
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

package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

public class CityHistory extends Thread {

    private ArrayList<City> history = new ArrayList<>();
    private String cityName="";
    private int count = 0;

    public void createHistoryFromFile(){
        String readText = new FileHandle().readFile(getCityName());
        if(readText.length()>1) parseAndInsertCity(readText);
    }

    private void parseAndInsertCity(String readText) {
//        int lastReadIndex = 0;
//        count = checkNumberOfHistoryDays(readText);
//        for(int i=0;i<=count;i++) {
//            history.add(i,createCityFromString(readText,lastReadIndex));
            setHistory(createCityFromString(readText,0));
//        }
    }

    private ArrayList<City> createCityFromString(String str, int lastReadIndex){
        ArrayList<City> citiesFromFile = new ArrayList<>();
        City city;
        while (lastReadIndex != -1) {
            int nextJson = str.indexOf("@@@@@@@@@@", lastReadIndex+1);
            String toJson="";
            if(nextJson==(-1)){ toJson = str.substring(lastReadIndex+20);}
            else {toJson = str.substring(lastReadIndex+20,nextJson);}
            JSONObject json = null;
            if (str.length() != 0) {
                try {
                    json = (JSONObject)new JSONParser().parse(toJson);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                city = new City(json);
                citiesFromFile.add(city);
                setCount(getCount()+1);
                lastReadIndex = nextJson;
            }
        }
        return citiesFromFile;
    }

    public ArrayList<City> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<City> history) {
        this.history = history;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public CityHistory(String cTName) {
        setCityName(cTName);
        createHistoryFromFile();
    }

    @Override
    public String toString() {
        if(getCount()==0) return "\nThere is no history for the chosen city!\n";
        if(getCount()==1)return "\n\nCityHistory of the past day for the chosen city " + getCityName() + ":\n" + getHistory().get(0) + "\n\n";
        if(getCount()>1) {
            String ans = "CityHistory of the past " + getCount() + " days for the chosen city: " + getCityName() + "\n";
            for (int i = 0; i < getCount(); i++) {
                ans += "City history record #" + (getCount()-i) + ":";
                ans += getHistory().get(i);
                ans += "\n\n\n*******************\n\n\n";
            }
            return ans;
        }
        return "";
    }
}

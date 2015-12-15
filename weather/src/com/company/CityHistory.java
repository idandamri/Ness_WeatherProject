package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.ArrayList;

public class CityHistory {

    ArrayList<City> history = new ArrayList<>(3);
    String cityName="";
    int count = 0;

    public CityHistory(String cTName) {
        this.cityName = cTName;
        createHistoryFromFile();
    }

    public void createHistoryFromFile(){
        String readText = readFromFile();
        if(readText.length()>1) parseAndInsertCity(readText);
    }

    private void parseAndInsertCity(String readText) {
        int lastReadIndex = 0;
        count = checkNumberOfHistoryDays(readText);
        for(int i=0;i<=count;i++) {
            history.add(i,createCityFromString(readText,lastReadIndex));
        }
    }

    private City createCityFromString(String str, int lastReadIndex){
        City city = null;
        while (lastReadIndex != -1) {
            int formerLastIndx = lastReadIndex;
            lastReadIndex = str.indexOf("@@@@@@@@@@", lastReadIndex);
            String toJson = str.substring(formerLastIndx,lastReadIndex);
            JSONObject json = null;
            if (lastReadIndex != -1) {
                try {
                    json = (JSONObject)new JSONParser().parse(toJson);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                city = new City(json);
                count++;
            }
        }
        return city;
    }

    private int checkNumberOfHistoryDays(String readText) {
        String parser = "@@@@@@@@@@";
        int lastIndex = 0;
        int count = 0;
        while (lastIndex != -1) {
            lastIndex = readText.indexOf(parser, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += parser.length();
            }
        }
        return  count;
    }

    private String readFromFile() {
        FileReader fileReader;
            String read = "";
            if (new File(cityName).exists()) {
                try {
                    fileReader = new FileReader(cityName);
                    BufferedReader br = new BufferedReader(fileReader);
                    String line;
                    try {
                        while ((line = br.readLine()) != null) {
                            read += line;
                        }
                        br.close();
                    } catch (IOException e) {
                        System.out.println("Unable to read from file '" + cityName + "'");
                    }
                } catch (FileNotFoundException ex) {
                    System.out.println("Unable to open file '" + cityName + "'");
                }
        } else System.out.println("File doesn't exist!!\n");
        return read;
    }
}

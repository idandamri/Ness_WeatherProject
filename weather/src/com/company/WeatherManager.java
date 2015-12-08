package com.company;

import java.util.ArrayList;

public class WeatherManager {

    boolean first;
    ArrayList<CityHistory> citysHistory = new ArrayList<>(3);

    public WeatherManager() {
        first = true;
    }
}

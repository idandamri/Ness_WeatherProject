package com.company;

import org.json.simple.JSONObject;


public class Clouds{

    private long all;

        public Clouds(JSONObject cloud) {
            all = (long)cloud.get("all");
        }

    public long getAll() {
        return all;
    }

    public String toString(){
            return "Clouds:" +
                    "\n\tAll - " + getAll();
        }
}

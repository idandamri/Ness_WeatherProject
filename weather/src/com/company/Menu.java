package com.company;

import org.json.simple.JSONObject;

public class Menu {

    int num_of_choices;
    WeatherManager wm;
    String[] citiesJsonToString = new String[10];
    JSONObject[] citeisJsons = new JSONObject[10];

    public Menu(int num_of_choices) {
        this.num_of_choices = num_of_choices;
        wm = new WeatherManager();
        jsonToArray();
        updateCitiesFromUrl();
    }


    private void jsonToArray(){
        try {
            citeisJsons[0] = TParse.readJsonFromUrl(CitiesEName.BEERSHEBA);
            citeisJsons[1] = TParse.readJsonFromUrl(CitiesEName.HAIFA);
            citeisJsons[2] = TParse.readJsonFromUrl(CitiesEName.TELAVIV);
            citeisJsons[3] = TParse.readJsonFromUrl(CitiesEName.NEWYORK);
            citeisJsons[4] = TParse.readJsonFromUrl(CitiesEName.MADRID);
            citeisJsons[5] = TParse.readJsonFromUrl(CitiesEName.BARCELONA);
            citeisJsons[6] = TParse.readJsonFromUrl(CitiesEName.ROME);
            citeisJsons[7] = TParse.readJsonFromUrl(CitiesEName.PARIS);
            citeisJsons[8] = TParse.readJsonFromUrl(CitiesEName.LONDON);
            citeisJsons[9] = TParse.readJsonFromUrl(CitiesEName.ISTANBUL);
        }
        catch (Exception e) {
            System.out.println("city json failed\n\n" + e);
        }
    }



    private void updateCitiesFromUrl() {
        try {
            for (int i=0; i<10; i++) {
                citiesJsonToString[i] = citeisJsons[i].toJSONString();
            }
        }
        catch (Exception e){
            System.out.println("city json failed\n\n"+e);
        }
    }

    public void print_first_menu(){
        System.out.println("1)Choose a city to view it's weather.\n2)Quit");
    }

    public void print_second_menu() {
        System.out.println("Choose one of the following city to view:");
    }

    public void print_third_menu() {
        System.out.println("1)Beer-Sheba\t" +
                "2)Haifa \t" +
                "3)Tel-Aviv\t" +
                "4)New-York\t" +
                "5)Madrid\n" +
                "6)Barcelona \t" +
                "7)Rome \t" +
                "8)Paris \t" +
                "9)London \t" +
                "10)Istanbul\n" +
                "11)Return to previous menu\n");
    }

    public void handleChosenCity(int number) {
        if(number>0 && number<12){
            switch(number) {
                case 11:
                    print_first_menu();
                    return;
                case 1:
//
               case 2:
                    //;
                case 3:
                    //;
                case 4:
                    //;
                case 5:
                    //;
                case 6:
                    //;
                case 7:
                    //;
                case 8:
                    //;
                case 9:
                    //;
                case 10:
                    //;
                default:
                    City c = new City(citeisJsons[number-1]);
                    System.out.println("\n"+c+"\n\n");
                    print_first_menu();
            }
        }
        else{
            System.out.println("\nYour choice is not valid.\nChoose again.\n");
        }
    }
}

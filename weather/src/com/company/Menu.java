package com.company;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Menu {

    private int num_of_choices;
    private WeatherManager wm;
    public static String[] citiesJsonToString = new String[10];
    public static JSONObject[] citesJson = new JSONObject[10];
    private ArrayList<String> names = new ArrayList<>();

    public Menu(int num_of_choices) {
        setNum_of_choices(num_of_choices);
        WeatherManager T2 = new WeatherManager("WeatherManager");
        Main.executor.execute((T2));
        setNames(getCityNames());
    }

    private ArrayList<String> getCityNames() {
        ArrayList<String> ans = new ArrayList<>(10);
        ans.add(0,CitiesEName.BEERSHEBA_City);
        ans.add(1,CitiesEName.HAIFA_City);
        ans.add(2,CitiesEName.TELAVIV_City);
        ans.add(3,CitiesEName.NEWYORK_City);
        ans.add(4,CitiesEName.MADRID_City);
        ans.add(5,CitiesEName.BARCELONA_City);
        ans.add(6,CitiesEName.TOKYO_City);
        ans.add(7,CitiesEName.PARIS_City);
        ans.add(8,CitiesEName.LONDON_City);
        ans.add(9,CitiesEName.ISTANBUL_City);
        return ans;
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public void setNames(ArrayList<String> arr) {
        this.names = arr;
    }



    public void print_first_menu(){
        System.out.println("1)Choose a city to view it's weather.\n2)View city history\n3)Quit");
    }

    public void print_second_menu() {
        System.out.println("Choose one of the following city to view:");
    }

    public void print_third_menu() {
        System.out.println(
                "1)Beer-Sheba\t" +
                "2)Haifa \t" +
                "3)Tel-Aviv\t" +
                "4)New-York\t" +
                "5)Madrid\n" +
                "6)Barcelona \t" +
                "7)Rome \t" +
                "8)Paris \t" +
                "9)London \t" +
                "10)Istanbul\n" +
                "11)Return to previous menu\n"
        );
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
                    City c = new City(citesJson[number-1]);
                    new FileHandle().writeFile(c.getName(),citiesJsonToString[number-1]);
                    System.out.println("\n"+c+"\n\n");
                    print_first_menu();
            }
        }
        else{
            System.out.println("\nYour choice is not valid.\nChoose again.\n");
        }
    }

    public void handleCityHistory(int number) {
       if(number== 11) {
           print_first_menu();
           return;
       }
        else {
           //CityHistory - thread??
           String cityChosenByNumber = getNames().get(number-1);
           CityHistory ch = new CityHistory(cityChosenByNumber);
           System.out.println(ch.toString());
           print_first_menu();
           return;
       }
    }

    public void setNum_of_choices(int num_of_choices) {
        this.num_of_choices = num_of_choices;
    }

}

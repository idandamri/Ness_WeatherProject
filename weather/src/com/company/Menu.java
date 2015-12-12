package com.company;

import org.json.simple.JSONObject;

import java.util.Scanner;

public class Menu {

    int num_of_choices;
    WeatherManager wm;
    static String[] citiesJsonToString = new String[10];
    static JSONObject[] citesJson = new JSONObject[10];

    public Menu(int num_of_choices) {
        this.num_of_choices = num_of_choices;
        wm = new WeatherManager();
        ThreadCityUpdate T2 = new ThreadCityUpdate("Thread-City-Update");
        ThreadMenu.appThreads.add(T2);
        T2.start();
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
                    City c = new City(citesJson[number-1]);
                    System.out.println("\n"+c+"\n\n");
                    print_first_menu();
            }
        }
        else{
            System.out.println("\nYour choice is not valid.\nChoose again.\n");
        }
    }
}

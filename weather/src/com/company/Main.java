package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to World-Wide-Weather");
        Menu menu = new Menu(2);
        menu.print_first_menu();
        //int choice=-1;
        while (true){
            int choice = getNumber();
            if(choice == 2)
                break;//quit
            if(choice == 1) handleToCities(menu);
            else{
                // a choice that is not in the menu
                System.out.println("\nYou choose badly.\nChose again please:");
                menu.print_first_menu();
            }
        }
        System.out.println("\nGood Bye...");
    }

    private static void handleToCities(Menu menu) {
        menu.print_second_menu();//choose city
        menu.print_third_menu();//cities
        menu.handleChosenCity(getNumber());
    }

    private static int getNumber() {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            String s = scanner.nextLine();
             choice= Integer.parseInt(s);
        }catch(NumberFormatException ex){
            System.out.println("\nERORR:\nYou entered something that is not a number!!!\n");
        }
        return choice;
    }
}

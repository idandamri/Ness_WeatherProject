package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadMenu extends Thread {

    private Thread t;
    private String threadName;

    ThreadMenu( String name){
        threadName = name;
//        System.out.println("Creating " +  threadName );
    }
    public void run() {
//        System.out.println("Running " +  threadName );
//        try {
        System.out.println("Welcome to World-Wide-Weather");
        Menu menu = new Menu(2);
        menu.print_first_menu();
        //int choice=-1;
        while (true) {
            int choice = getNumber();
            if (choice == 2) {
                Main.executor.shutdownNow();
                break;//quit
            }
            if (choice == 1) handleToCities(menu);
            else {
                // a choice that is not in the menu
                System.out.println("\nYou choose badly.\nChose again please:");
                menu.print_first_menu();
            }
        }
        System.out.println("\nGood Bye...");
//        }
//        catch (InterruptedException e) {
//            System.out.println("Thread " +  threadName + " interrupted.");
//        }
//        System.out.println("Thread " +  threadName + " exiting.");
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
            String s = Integer.toString(scanner.nextInt());
            choice= Integer.parseInt(s);
        }catch(NumberFormatException ex){
            System.out.println("\nERROR:\nYou entered something that is not a number!!!\n");
        }
        return choice;
        // Let the thread sleep for a while.
    }

    public void start ()
    {
//        System.out.println("Starting " +  threadName );
        if (t == null)
        {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

}

package com.czajor.rps;

import java.util.List;

public class ProgramScreens {

    public static void printMainMenu(List menu){
        menu.forEach(System.out::println);
    }

    // prints decision dialog: exit or new game?
    public static boolean printAfterMatchScreen(){
        String userChoice;
        do {
            System.out.println("Do you want to exit game? 'x' Or start a new game? 'n'");
            userChoice = InputScanner.scanString();
            switch (userChoice) {
                case "x":
                    System.out.println("Are you sure you want to exit? y/n");
                    if (!InputScanner.scanSure()) {
                        printAfterMatchScreen();
                    }
                    return true;
                case "n":
                    System.out.println("Are you sure you want to start a new game? y/n");
                    if (!InputScanner.scanSure()) {
                        printAfterMatchScreen();
                    }
                    break;
                default:
                    System.out.println("Wrong choice! Please input 'x' or 'n'");

            }
        }while(!(userChoice.equals("x") || userChoice.equals("n") || userChoice.equals("y")));
        return false;
    }
}

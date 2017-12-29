package com.czajor.rps;

import java.util.ArrayList;
import java.util.List;

public class ProgramScreens {
    private final List<String> MAIN_MENU_LINES = new ArrayList<>();

    public void printMainMenu(){
        MAIN_MENU_LINES.forEach(System.out::println);
    }

    public void prepareMainMenu(String username, List<Weapon> weapons) {
        MAIN_MENU_LINES.add("Hi " + username);
        MAIN_MENU_LINES.add("Welcome to Paper-Rock-Scissors!");
        MAIN_MENU_LINES.add("Gameplay keys:");

        for(Weapon weapon : weapons){
            MAIN_MENU_LINES.add(weapon.getId() + " - " + weapon);
        }

        MAIN_MENU_LINES.add("x - exit game");
        MAIN_MENU_LINES.add("n - new game");
    }

    public boolean printAfterMatchScreen(){
        InputScanner inputScanner = new InputScanner();
        String userChoice;

        do {
            System.out.println("Do you want to exit game? 'x' Or start a new game? 'n'");
            userChoice = inputScanner.scanString();
            switch (userChoice) {
                case "x":
                    System.out.println("Are you sure you want to exit? y/n");
                    if (!inputScanner.scanSure()) {
                        printAfterMatchScreen();
                    }
                    return true;
                case "n":
                    System.out.println("Are you sure you want to start a new game? y/n");
                    if (!inputScanner.scanSure()) {
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

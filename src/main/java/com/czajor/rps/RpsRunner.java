package com.czajor.rps;

import java.util.*;

public class RpsRunner {
    static private int numberOfGames;
    static private Scanner userInput = new Scanner(System.in);
    static private boolean end = false;

    public static void main(String[] args){
        System.out.println("Hi there! Please enter your name: ");
        Player user = new Player(InputScanner.scanName());
        Player machine = new Player("Machine");

        System.out.println("Please provide number of games to play: ");
        numberOfGames = userInput.nextInt();

        printMainMenu(user.getName());

        while(!end){
            System.out.println("Game has started, choose weapon: ");
            System.out.println(Weapon.solveFight(numberOfGames, user, machine) + " Won!");
            System.out.println("Do you want to exit game? 'x' Or start a new game? 'n'");
            afterMatchScreen();
        }
    }

    public static void afterMatchScreen(){
        String userChoice;
        do {
            userChoice = userInput.next();
            switch (userChoice) {
                case "x":
                    System.out.println("Are you sure? y/n");
                    if (InputScanner.scanSure()) {
                        end = true;
                    }
                    break;
                case "n":
                    System.out.println("Do you want to start a new game?");
                    if (InputScanner.scanSure()) {
                        main(null);
                    }
                    break;
                default:
                    System.out.println("Wrong choice! Please input 'y' or 'n'");

            }
        }while(!(userChoice.equals("x") || userChoice.equals("y")));
    }

    public static void printMainMenu(String username){
        List<String> menuTitle = new ArrayList<>();
        menuTitle.add("Hi " + username);
        menuTitle.add("Welcome to Paper-Rock-Scissors!");
        menuTitle.add("Gameplay keys:");

        Map<Character, String> positions = new HashMap<>();
        positions.put('1'," - rock");
        positions.put('2'," - paper");
        positions.put('3'," - scissors");
        positions.put('x'," - exit game");
        positions.put('n'," - new game");

        menuTitle.stream()
                .forEach(System.out::println);
        positions.entrySet().stream()
                .forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));
    }
}


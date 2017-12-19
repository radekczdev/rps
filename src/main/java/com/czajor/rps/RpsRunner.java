package com.czajor.rps;

import java.util.*;

public class RpsRunner {
    static private String username;
    static private int numberOfGames;
    static private int userScore = 0;
    static private int machineScore = 0;
    static private Scanner userInput = new Scanner(System.in);
    static private boolean end = false;

    public static void main(String[] args){
        System.out.println("Hi there! Please enter your name: ");
        username = userInput.next();
        System.out.println("Please provide number of games to play: ");
        numberOfGames = userInput.nextInt();

        printMainMenu(username);

        while(!end){
            System.out.println("Game has started, choose weapon: ");
            System.out.println(solveMatch(numberOfGames) + " Won!");
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
                    System.out.println("Are you sure?");
                    if (userInput.next().charAt(0) == 'y') {
                        end = true;
                    }
                    break;
                case "n":
                    System.out.println("Do you want to start a new game?");
                    if (userInput.next().charAt(0) == 'y') {
                        main(null);
                    }
                    break;
                default:
                    System.out.println("Wrong choice! Please input 'x' or 'n'");

            }
        }while(!(userChoice.equals("x") || userChoice.equals("y")));
    }

    public static String solveMatch(int numberOfGames){
        Random rnd = new Random();
        int userMove;
        int machineMove;

        for(int i = 0; i < numberOfGames; i++) {
            do {
                userMove = userInput.nextInt();
            }while(!(userMove==1 || userMove==2 || userMove==3));
            machineMove = rnd.nextInt(3) + 1;

            if(userMove != machineMove){
                if (userMove == machineMove - 1 || userMove == 3 && machineMove == 1) {
                    userScore++;
                } else
                    machineScore++;
            }

            System.out.println("User weapon: " + userMove + ", Machine weapon: " + machineMove + "\nScore: user |" + userScore + " vs. " + machineScore + "| machine");
        }
        if(userScore > machineScore){
            return username;
        }
        return "Machine";
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


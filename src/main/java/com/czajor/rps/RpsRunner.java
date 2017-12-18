package com.czajor.rps;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class RpsRunner {
    static private String username;
    static int numberOfGames;
    static int userScore = 0;
    static int machineScore = 0;
    static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args){
        boolean end = false;

        int currentNumberOfGames = 0;
        String userChoice;

        System.out.println("Hi there! Please enter your name: ");
        username = userInput.nextLine();
        System.out.println("Please provide number of games to play: ");
        numberOfGames = userInput.nextInt();

        while(!end){
            printMainMenu(username);
            userChoice = userInput.next();
            switch(userChoice){
                case "x":
                    System.out.println("Are you sure?");
                    if(userInput.next().charAt(0)=='y') end = true;
                    break;
                case "n":
                    System.out.println("Do you want to start a new game?");
                    if(userInput.next().charAt(0)=='y') currentNumberOfGames = numberOfGames;
                    break;
                default:
                    solveMatch(userChoice, numberOfGames);
                    System.out.println("");
                    System.out.println(username + " score: " + userScore);
                    userScore = 0;
                    System.out.println("PC score: " + machineScore);
                    machineScore = 0;
                    break;
            }
        }
    }

    public void user(String username){
        this.username = username;
    }

    public static void solveMatch(String userMove, int numberOfGames){
        Random rnd = new Random();
        int tempUserMove;

        for(int i = 0; i < numberOfGames; i++) {
            int machineMove = rnd.nextInt(3) + 1;
            System.out.println("User move: " + userMove + "Machine move: " + machineMove);
            tempUserMove = Integer.parseInt(userMove);
         if(tempUserMove != machineMove){
            if (tempUserMove == 3) {
                if (machineMove == 1) {
                    userScore++;
                }
                else machineScore++;
            } else if (tempUserMove == (machineMove - 1)) {
                userScore++;
            } else
                machineScore++;
        }
            userMove = userInput.next();
        }
    }

    public static void printMainMenu(String username){
        Map<Character, String> positions = new HashMap<>();
        positions.put('1'," - rock");
        positions.put('2'," - paper");
        positions.put('3'," - scissors");
        positions.put('x'," - exit game");
        positions.put('n'," - new game");

        System.out.println("\nHi " + username + "!\nWelcome to Paper-Rock-Scissors!" + "\nGameplay keys: ");
        for(Map.Entry<Character, String> pos : positions.entrySet()){
            System.out.println(pos.getKey() + pos.getValue());
        }
    }



}


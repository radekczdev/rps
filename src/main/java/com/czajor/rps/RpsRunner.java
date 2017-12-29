package com.czajor.rps;

import java.util.*;

public class RpsRunner {

    static private boolean end = false;

    public static void main(String[] args) {
        InputScanner inputScanner = new InputScanner();
        ProgramScreens programScreens = new ProgramScreens();
        GamePlay gamePlay = new GamePlay();

        gamePlay.prepareGame();
        System.out.println("Hi there! Please enter your name: ");
        Player user = new Player(inputScanner.scanString());
        Player machine = new Player("Machine");

        programScreens.prepareMainMenu(user.getName(), gamePlay.getWeaponList());
        programScreens.printMainMenu();

        while (!end) {
            System.out.println("Please provide number of games to play: ");
            int numberOfGames = new Scanner(System.in).nextInt();
            System.out.println("Game has started, choose weapon: ");
            gamePlay.gameplay(numberOfGames, user, machine);
            System.out.println(gamePlay.returnWinner(user, machine) + " Won!");
            gamePlay.clearScores(user, machine);
            end = programScreens.printAfterMatchScreen();
        }
    }
}
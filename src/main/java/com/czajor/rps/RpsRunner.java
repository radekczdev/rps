package com.czajor.rps;

import java.util.*;

import static com.czajor.rps.ProgramScreens.getMainMenu;
import static com.czajor.rps.ProgramScreens.printAfterMatchScreen;

public class RpsRunner {

    static private boolean end = false;

    public static void main(String[] args) {
        System.out.println("Hi there! Please enter your name: ");
        Player user = new Player(InputScanner.scanString());
        Player machine = new Player("Machine");

        ProgramScreens.printMainMenu(getMainMenu(user.getName()));

        GamePlay gamePlay = new GamePlay();

        while (!end) {
            System.out.println("Please provide number of games to play: ");
            int numberOfGames = new Scanner(System.in).nextInt();
            System.out.println("Game has started, choose weapon: ");
            System.out.println(gamePlay.gameplay(numberOfGames, user, machine) + " Won!");
            end = printAfterMatchScreen();
        }
    }
}
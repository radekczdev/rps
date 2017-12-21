package com.czajor.rps;

import java.util.*;

import static com.czajor.rps.ProgramScreens.printAfterMatchScreen;

public class RpsRunner {

    static private boolean end = false;

    public static void main(String[] args){
        System.out.println("Hi there! Please enter your name: ");
        Player user = new Player(InputScanner.scanString());
        Player machine = new Player("Machine");

        ProgramScreens.printMainMenu(getMainMenu(user.getName()));

        while(!end){
            System.out.println("Please provide number of games to play: ");
            int numberOfGames = new Scanner(System.in).nextInt();
            System.out.println("Game has started, choose weapon: ");
            System.out.println(gameplay(numberOfGames, user, machine) + " Won!");
            end = printAfterMatchScreen();
        }
    }

    // method for preparing menu lines
    public static List<String> getMainMenu(String username){
        List<String> mainMenu = new ArrayList<>();
        mainMenu.add("Hi " + username);
        mainMenu.add("Welcome to Paper-Rock-Scissors!");
        mainMenu.add("Gameplay keys:");
        mainMenu.add("1 - rock");
        mainMenu.add("2 - paper");
        mainMenu.add("3 - scissors");
        mainMenu.add("x - exit game");
        mainMenu.add("n - new game");
        return mainMenu;
    }

    // method for preparing weapon list
    public static List<Weapon> getWeaponList() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon(0, "scissors"));
        weapons.add(new Weapon(1, "paper"));
        weapons.add(new Weapon(2, "rock"));
        return weapons;
    }

    //method for preparing win/loose combination array
    public static int[][] getJudgeList(){
        return new int[][]{
                {0, 1, 2},
                {2, 0, 1},
                {1, 2, 0}
        };
    }

    // finds winning weapon acc. to JudgeList array
    private static int fightSolver(Weapon player1, Weapon player2){
        return getJudgeList()[player1.getId()][player2.getId()];
    }

    // get user weapon input -> draw machine weapon -> add points -> print current status of fight -> return winner name/draw info
    public static String gameplay(int numberOfGames, Player user, Player machine) {
        int winner = 1;

        for(int i = 0; i < numberOfGames; i++) {
            int weaponId;
            do {
                System.out.println("Round " + i + ". Choose weapon: ");
                weaponId = InputScanner.scanWeapon();
            } while(weaponId == -1);

            user.setLastWeapon(getWeaponList().get(weaponId));
            machine.setLastWeapon(Weapon.drawMachineWeapon());

            winner = fightSolver(user.getLastWeapon(), machine.getLastWeapon());
            if (winner == 1) {
                user.addPoint();
            } else if (winner == 2) {
                machine.addPoint();
            }

            System.out.println("User weapon: "
                    + user.getLastWeapon()
                    + ", Machine weapon: "
                    + machine.getLastWeapon()
                    + "\nScore: user |"
                    + user.getScore()
                    + " vs. "
                    + machine.getScore()
                    + "| machine");
        }

        if(user.getScore() == machine.getScore()){
            return "DRAW! no one";
        }

        List<Player> players = new ArrayList<>();
        players.add(user);
        players.add(machine);

        return players.get(winner - 1).getName();
    }
}


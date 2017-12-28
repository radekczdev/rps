package com.czajor.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GamePlay {
    public String gameplay(int numberOfGames, Player user, Player machine) {
        int winner = 0;

        for (int i = 0; i < numberOfGames; i++) {
            user.setCurrentWeapon(getWeaponList().get(readWeaponValidator(i)));
            machine.setCurrentWeapon(drawMachineWeapon());

            winner = fightSolver(user.getCurrentWeapon(), machine.getCurrentWeapon());

            if (winner == 1) {
                user.addPoint();
            } else if (winner == 2) {
                machine.addPoint();
            }

            printCurrentStatistic(user, machine);
        }

        if (user.getScore() == machine.getScore()) {
            return "DRAW! no one";
        }

        List<Player> players = new ArrayList<>();
        players.add(user);
        players.add(machine);

        for(Player pl : players){
            pl.clearScore();
        }

        return players.get(winner - 1).getName();
    }

    public static Weapon drawMachineWeapon() {
        return getWeaponList().get(new Random().nextInt(getWeaponList().size()));
    }

    public static List<Weapon> getWeaponList() {
        List<Weapon> weapons = new ArrayList<>();

        weapons.add(new Weapon(0, "scissors"));
        weapons.add(new Weapon(1, "paper"));
        weapons.add(new Weapon(2, "rock"));
        weapons.add(new Weapon(3, "lizard"));
        weapons.add(new Weapon(4, "spock"));

        return weapons;
    }

    public static int[][] getJudgeList() {
        return new int[][]{
                {0, 1, 2, 1, 2},
                {2, 0, 1, 2, 1},
                {1, 2, 0, 1, 2},
                {2, 1, 2, 0, 1},
                {1, 2, 1, 2, 0}
        };
    }

    private static int fightSolver(Weapon player1, Weapon player2) {
        return getJudgeList()[player1.getId()][player2.getId()];
    }

    public int readWeaponValidator(int i) {
        int weaponId;
        do {
            System.out.println("Round " + i + ". Choose weapon: ");
            weaponId = InputScanner.scanWeapon();
        } while (weaponId == -1);
        return weaponId;
    }

    public void printCurrentStatistic(Player user, Player machine){
        System.out.println("User weapon: "
                + user.getCurrentWeapon()
                + ", Machine weapon: "
                + machine.getCurrentWeapon()
                + "\nScore: user |"
                + user.getScore()
                + " vs. "
                + machine.getScore()
                + "| machine");
    }
}

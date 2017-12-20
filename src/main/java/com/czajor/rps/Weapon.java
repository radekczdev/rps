package com.czajor.rps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Weapon {

    public static int drawMachineWeapon(){
        return new Random().nextInt(3) + 1;
    }

    public static String solveFight(int numberOfGames, Player user, Player machine) {
        int     userWeapon,
                machineWeapon;

        for(int i = 0; i < numberOfGames; i++) {
            do {
                System.out.println("Round " + i + ". Choose weapon: ");
                userWeapon = InputScanner.scanWeapon();
            } while(userWeapon == 0);

            machineWeapon = Weapon.drawMachineWeapon();

            if(userWeapon != machineWeapon){
                if (userWeapon == machineWeapon - 1 || userWeapon == 3 && machineWeapon == 1) {
                    user.addPoint();
                } else
                    machine.addPoint();
            }

            System.out.println("User weapon: "
                    + userWeapon
                    + ", Machine weapon: "
                    + machineWeapon+ "\nScore: user |"
                    + user.getScore() + " vs. "
                    + machine.getScore() + "| machine");
        }

        if(user.getScore()==machine.getScore()){
            return "DRAW! no one";
        }

        List<Player> players = new ArrayList<>();
        players.add(user);
        players.add(machine);
        return players.stream().max(Comparator.comparing(Player::getScore)).get().getName();
    }
}

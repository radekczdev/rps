package com.czajor.rps;

import java.util.Scanner;

public class InputScanner {
    public static boolean scanSure() {
        char input = new Scanner(System.in).next().charAt(0);
        return input == 'y';
    }

    public static int scanWeapon() {
        int input = new Scanner(System.in).nextInt();

        if(GamePlay.getWeaponList().stream()
                .map(n -> n.getId())
                .anyMatch(x -> x == input)) {
            return input;
        }
        else {
            return -1;
        }
    }

    public static String scanString() {
        return new Scanner(System.in).nextLine();
    }
}

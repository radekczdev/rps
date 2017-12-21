package com.czajor.rps;

import java.util.Scanner;

public class InputScanner {
    // gets input from user; checks if 'y' is provided by user
    public static boolean scanSure() {
        char input = new Scanner(System.in).next().charAt(0);
        return input == 'y';
    }

    // gets input from user; checks if weapon number is correct
    public static int scanWeapon() {
        int input = new Scanner(System.in).nextInt();
        if(input > 0 && input <= RpsRunner.getWeaponList().size()) {
            return input-1;
        }
        else {
            return -1;
        }
    }

    // gets input from user; username
    public static String scanString() {
        return new Scanner(System.in).nextLine();
    }
}

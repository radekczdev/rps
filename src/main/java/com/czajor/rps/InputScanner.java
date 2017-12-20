package com.czajor.rps;

import java.util.Scanner;

public class InputScanner {
    public static boolean scanSure() {
        char input = new Scanner(System.in).next().charAt(0);
        return input == 'y';
    }


    public static int scanWeapon() {
        int input = new Scanner(System.in).nextInt();
        if(input == 1 || input == 2 || input == 3) {
            return input;
        }
        else {
            return 0;
        }
    }

    public static String scanName() {
        return new Scanner(System.in).nextLine();
    }
}

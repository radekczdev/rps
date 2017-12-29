package com.czajor.rps;

import java.util.List;
import java.util.Scanner;

public class InputScanner {
    public boolean scanSure() {
        char input = new Scanner(System.in).next().charAt(0);
        return input == 'y';
    }

    public int scanWeapon(List<Weapon> weapons) {
        int input = new Scanner(System.in).nextInt();

        if(weapons.stream()
                .map(n -> n.getId())
                .anyMatch(x -> x == input)) {
            return input;
        }
        else {
            return -1;
        }
    }

    public String scanString() {
        return new Scanner(System.in).nextLine();
    }
}

package com.czajor.rps;

import java.util.Random;

public class Weapon {

    private int id;
    private String name;

    public Weapon(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    // draw Weapon for Machine
    public static Weapon drawMachineWeapon(){
        return RpsRunner.getWeaponList().get(new Random().nextInt(3));
    }

    @Override
    public String toString() {
        return name;
    }
}

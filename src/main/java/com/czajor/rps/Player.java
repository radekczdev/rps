package com.czajor.rps;

public class Player {
    private String name;
    private int score = 0;
    private Weapon lastWeapon;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setLastWeapon(Weapon lastWeapon) {
        this.lastWeapon = lastWeapon;
    }

    public Weapon getLastWeapon() {
        return lastWeapon;
    }

    public void addPoint() {
        score++;
    }

    @Override
    public String toString() {
        return name;
    }
}

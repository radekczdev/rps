package com.czajor.rps;

public class Player {
    private String name;
    private int score = 0;
    private Weapon currentWeapon;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void clearScore() {
        score = 0;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void addPoint() {
        score++;
    }

    @Override
    public String toString() {
        return name;
    }
}

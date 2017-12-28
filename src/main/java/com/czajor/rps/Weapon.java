package com.czajor.rps;

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

    @Override
    public String toString() {
        return name;
    }
}

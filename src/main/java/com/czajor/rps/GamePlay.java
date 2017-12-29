package com.czajor.rps;

import java.util.*;

public class GamePlay {
    private final int DRAW = 0;
    private final int USER = 1;
    private final int MACHINE = 2;
    private final List<Weapon> WEAPONS = new ArrayList<>();
    private final int[][] JUDGE_LIST = {{DRAW, USER, MACHINE, USER, MACHINE},
            {MACHINE, DRAW, USER, MACHINE, USER},
            {USER, MACHINE, DRAW, USER, MACHINE},
            {MACHINE, USER, MACHINE, DRAW, USER},
            {USER, MACHINE, USER, MACHINE, DRAW}};

    public void prepareGame(){
        createWeaponList();
    }

    public String returnWinner(Player... players){
        List<Player> playersArray = new ArrayList<>();
        playersArray.addAll(Arrays.asList(players));

        if (playersArray.stream().map(Player::getScore).distinct().count() == 1) {
            return "DRAW! no one";
        }
        return playersArray.stream().reduce((a, b) -> a.getScore() > b.getScore() ? a:b).get().getName();
    }

    public void gameplay(int numberOfGames, Player user, Player machine) {
        int winner;

        for (int i = 0; i < numberOfGames; i++) {
            user.setCurrentWeapon(getWeaponList().get(readWeaponValidator(i)));
            machine.setCurrentWeapon(drawMachineWeapon());
            winner = fightSolver(user.getCurrentWeapon(), machine.getCurrentWeapon());

            if (winner == USER) {
                user.addPoint();
            } else if (winner == MACHINE) {
                machine.addPoint();
            }

            printCurrentStatistic(user, machine);
        }
    }

    public void clearScores(Player... players){
        Arrays.stream(players).forEach(Player::clearScore);
    }

    public Weapon drawMachineWeapon() {
        return getWeaponList().get(new Random().nextInt(getWeaponList().size()));
    }

    public List<Weapon> getWeaponList() {
        return WEAPONS;
    }

    public void createWeaponList() {
        WEAPONS.add(new Weapon(0, "scissors"));
        WEAPONS.add(new Weapon(1, "paper"));
        WEAPONS.add(new Weapon(2, "rock"));
        WEAPONS.add(new Weapon(3, "lizard"));
        WEAPONS.add(new Weapon(4, "spock"));
    }

    public int[][] getJudgeList() {
        return JUDGE_LIST;
    }

    private int fightSolver(Weapon player1, Weapon player2) {
        return getJudgeList()[player1.getId()][player2.getId()];
    }

    public int readWeaponValidator(int i) {
        int weaponId;
        InputScanner inputScanner = new InputScanner();
        do {
            System.out.println("Round " + i + ". Choose weapon: ");
            weaponId = inputScanner.scanWeapon(WEAPONS);
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

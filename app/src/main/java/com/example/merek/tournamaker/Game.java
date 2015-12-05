package com.example.merek.tournamaker;

/**
 * Created by Merek on 2015-12-01.
 */
public class Game {

    private Team t1;
    private Team t2;

    public Game(Team t1, Team t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Team getWinner() {
        if(t1.getNumOfGoals() > t2.getNumOfGoals()) {
            t1.incrementNumGamesWon();
            t2.incrementNumGamesLost();
            return t1;
        } else {
            t1.incrementNumGamesLost();
            t2.incrementNumGamesWon();
            return t2;
        }
    }

    public Team getT1() {
        return t1;
    }

    public Team getT2() {
        return t2;
    }

    public String getScore() {
        return (t1.getName() + "-" + t1.getNumOfGoals() + " " + t2.getNumOfGoals() + "-" + t2.getName());
    }

}

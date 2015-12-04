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

    public String toString() {
        return t1.getName() + " vs " + t2.getName();
    }
}

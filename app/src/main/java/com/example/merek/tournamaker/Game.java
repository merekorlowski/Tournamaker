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
        if(t1.getNumOfGoals() > t2.getNumOfGoals())
            return t1;
        else
            return t2;
    }

}

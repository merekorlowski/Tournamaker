package com.example.merek.tournamaker;

/**
 * Created by Merek on 2015-12-01.
 */
public class Team {

    private String name;
    private int numOfGoals;
    private int leaguePosition;

    public Team(String name, int numOfGoals, int leaguePosition) {
        this.name = name;
        this.numOfGoals = numOfGoals;
        this.leaguePosition = leaguePosition;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setLeaguePosition(int position) {
        leaguePosition = position;
    }

}

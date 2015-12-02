package com.example.merek.tournamaker;

/**
 * Created by Merek on 2015-12-01.
 */
public class Team {

    private String name;
    private int numOfGoals;
    private int numGamesWon;
    private int numGamesLost;
    private int leaguePosition;

    public Team(String name, int numOfGoals, int numGamesWon, int numGamesLost, int leaguePosition) {
        this.name = name;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
        this.leaguePosition = leaguePosition;

    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int goals) {
        numOfGoals = goals;
    }

    public int getNumGamesWon() {
        return numGamesWon;
    }

    public void incrementNumGamesWon() {
        numGamesWon++;
    }

    public int getNumGamesLost() {
        return numGamesLost;
    }

    public void incrementNumGamesLost() {
        numGamesLost++;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int position) {
        leaguePosition = position;
    }

}

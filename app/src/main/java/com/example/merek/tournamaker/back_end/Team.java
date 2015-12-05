package com.example.merek.tournamaker.back_end;

/**
 * Created by Merek on 2015-12-01.
 */
public class Team implements Comparable {

    //declare variables
    private String name;
    private int numOfGoals;
    private int numGamesWon;
    private int numGamesLost;
    private int leaguePosition;

    //team constructor
    public Team(String name, int numOfGoals, int numGamesWon, int numGamesLost, int leaguePosition) {
        this.name = name;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
        this.leaguePosition = leaguePosition;
    }

    //getters and setters
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

    public int getNumGamesLost() {
        return numGamesLost;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    //increment this teams number of games won
    public void incrementNumGamesWon() {
        numGamesWon++;
    }

    //increment this teams number of games lost
    public void incrementNumGamesLost() {
        numGamesLost++;
    }

    //used to sort teams by order of number of games won
    @Override
    public int compareTo(Object another) {
        return getNumGamesWon() - ((Team)another).getNumGamesWon();
    }
}

package com.example.merek.tournamaker;

import java.io.Serializable;

public class Team implements Comparable, Serializable {

    //declare variables
    private String name;
    private Tournament tournament;
    private int numOfGoals;
    private int numGamesWon;
    private int numGamesLost;

    // Used in the database to create a team without knowing the tournament
    public Team(String name, int numOfGoals, int numGamesWon, int numGamesLost) {
        this.name = name;
        tournament = null;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
    }

    public Team(String name, Tournament tournament){
        this.name = name;
        this.tournament = tournament;
        numOfGoals = 0;
        numGamesWon = 0;
        numGamesLost = 0;
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getTournamentName(){
        return tournament.getName();
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

    public String getStats() {
        return name + ", " + numGamesWon + " wins, " + numGamesLost + " losses";
    }
}
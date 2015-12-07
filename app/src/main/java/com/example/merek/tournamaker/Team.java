package com.example.merek.tournamaker;

import java.io.Serializable;

public class Team implements Comparable, Serializable {

    //declare variables
    private String name;
    private Tournament tournament;
    private int numOfGoals;
    private int numGamesWon;
    private int numGamesLost;
    private int leaguePosition;


    //team tournament stats constructor
    public Team(String name, Tournament tournament, int numOfGoals, int numGamesWon, int numGamesLost, int leaguePosition) {
        this.name = name;
        this.tournament = tournament;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
        this.leaguePosition = leaguePosition;
    }

    public Team(String name, Tournament tournament){
        this.name = name;
        this.tournament = tournament;
        this.numOfGoals = 0;
        this.numGamesWon = 0;
        this.numGamesLost = 0;
        this.leaguePosition = 0;
    }

    //getters and setters
    public String getTeamName(){
        return name;
    }

    public void setTeamName(String name){
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

    public String getStats() {
        return name + ", " + numGamesWon + " wins, " + numGamesLost + " loses";
    }
}

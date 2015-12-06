package com.example.merek.tournamaker;

import java.io.Serializable;

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
    private String iconPath;
    private boolean isIconDrawable;

    //team constructor
    public Team(String name, int numOfGoals, int numGamesWon, int numGamesLost, int leaguePosition, String iconPath, boolean isIconDrawable) {
        this.name = name;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
        this.leaguePosition = leaguePosition;
        this.iconPath = iconPath;
        this.isIconDrawable = isIconDrawable;
    }

    public Team(String name){
        this.name = name;
        this.numOfGoals = 0;
        this.numGamesWon = 0;
        this.numGamesLost = 0;
        this.leaguePosition = 0;
        this.iconPath = null;
        this.isIconDrawable = false;
    }

    public Team(){}

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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath( String iconPath ) {
        this.iconPath = iconPath;
    }

    public boolean getIsIconDrawable() {
        return isIconDrawable;
    }

    public void setIsIconDrawable( boolean isIconDrawable ) {
        this.isIconDrawable = isIconDrawable;
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
        return getName() + ", " + numGamesWon + " wins, " + numGamesLost + " loses";
    }
}

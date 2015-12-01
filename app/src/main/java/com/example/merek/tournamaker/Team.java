package com.example.merek.tournamaker;

/**
 * Created by Merek on 2015-12-01.
 */
public class Team {

    private String name;
    private int numOfGoals;
    private int leaguePosition;
    private Team next;

    public Team(String name, int numOfGoals, int leaguePosition, Team next) {
        this.name = name;
        this.numOfGoals = numOfGoals;
        this.leaguePosition = leaguePosition;
        this.next = next;
    }

    public Team getNext() {
        return next;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int goals) {
        numOfGoals = goals;
    }

    public void setLeaguePosition(int position) {
        leaguePosition = position;
    }

}

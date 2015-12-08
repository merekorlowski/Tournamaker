package com.example.merek.tournamaker;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament implements Serializable {

    //declare variables
    private String type;
    private String name;
    private boolean active;
    private ArrayList<Team> teams;
    private ArrayList<Round> rounds;
    private int numOfRounds;

    //tournament constructors
    public Tournament(String type, String name, ArrayList<Team> teams) {

        this.type = type;
        this.name = name;
        active = false;
        this.teams = teams;
        rounds = new ArrayList<>();
        numOfRounds = 0;

    }

    public Tournament(String type, String name) {

        this.type = type;
        this.name = name;
        active = false;
        teams = new ArrayList<>();
        rounds = new ArrayList<>();
        numOfRounds = 0;

    }

    //initialize a new round
    public void initializeRound(int i, ArrayList<Team> teams) {
        rounds.add(new Round(i, teams));
    }

    //getters and setters
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public ArrayList<Team> getTeamList() {
        return teams;
    }

    public ArrayList<String> getStatistics() {

        //initialize array list of stats,
        //used to populate statistics page
        ArrayList<String> stats = new ArrayList<>();

        Collections.sort(teams);

        for(int i = 0; i < teams.size(); i++) {
            stats.add(teams.get(i).getStats());
        }

        return stats;
    }

    public void setTeamList(ArrayList<Team> t) {
        teams = t;
    }

    public Round getRound(int i) {
        return rounds.get(i);
    }

    public int getNumberOfRounds() {
        return numOfRounds;
    }

    public void setNumOfRounds(int n) {
        numOfRounds = n;
    }

    public void add(Team t) {
        teams.add(t);
    }

    //tests to see if this tournament is active
    public boolean isActive() {
        return active;
    }

    public void setIsActive(boolean isActive) {
        active = isActive;
    }

}
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

    //tournament constructor
    public Tournament(String type, String name) {

        this.type = type;
        this.name = name;
        active = false;
        teams = new ArrayList<>();
        rounds = new ArrayList<>();

        //determine number of rounds by type
        /*if(type.equals("Round Robin"))
            rounds = new Round[teamList.size()];

        else if(type.equals("Knockout"))
            rounds = new Round[(int)Math.log(2)*teamList.size()];

        else
            rounds = new Round[(teamList.size()) + (int)Math.log(2)*((teamList.size())/3)];*/

    }

    //initialize a new round
    public void initializeRound(int i, ArrayList<Team> teams) {
        rounds.set(i, new Round(i, teams));
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

    public ArrayList<String> getTeamNames() {

        //initialize arraylist of team names,
        //used to populate team select and edit lists
        ArrayList<String> names = new ArrayList<>();

        for(int i = 0; i < teams.size(); i++) {
            names.add(teams.get(i).getName());
        }

        return names;

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

    //returns team by a specific name
    public Team getTeam(String name) {

        int i = 0;
        while(teams.get(i).getName() != name) {
            i++;
        }

        return teams.get(i);
    }

    public void setTeamList(ArrayList<Team> t) {
        teams = t;
    }

    public Round getRound(int i) {
        return rounds.get(i);
    }

    public int getNumberOfRounds() {
        return rounds.size();
    }

    public void add(Team t) {
        teams.add(t);
    }

    //remove team from tournament
    public void remove(Team t) {
        teams.remove(t);
    }

    //tests to see if this tournament is active
    public boolean isActive() {
        return active;
    }

    public void setIsActive(boolean isActive) {
        active = isActive;
    }

}

package com.example.merek.tournamaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament implements Serializable {

    //declare variables
    private String type;
    private String name;
    private boolean active;
    private ArrayList<Team> teams;
    private Round[] rounds;

    //tournament constructor
    public Tournament(String type, String name, boolean active, ArrayList<Team> teams) {
        this.type = type;
        this.name = name;
        this.active = active;
        this.teams = teams;

        //determine number of rounds by type
        if(type.equals("Round Robin"))
            rounds = new Round[teams.size() - 1];

        else if(type.equals("Knockout"))
            rounds = new Round[(int)Math.log(2)*teams.size()];

        else
            rounds = new Round[(teams.size() - 1) + (int)Math.log(2)*((teams.size() - 1)/3)];

    }

    //initialize a new round
    public void initializeRound(int i, ArrayList<Team> teams) {
        rounds[i] = new Round(i, teams);
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

    public ArrayList<Team> getTeams() {
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

    public void setTeams(ArrayList<Team> t) {
        teams = t;
    }

    public Round getRound(int i) {
        return rounds[i];
    }

    public int getNumberOfRounds() {
        return rounds.length;
    }

    //returns true if doesnt already contain team and adds to tournament
    //returns false if already contains
    public boolean add(Team t) {

        if(!teams.contains(t)) {
            teams.add(t);
            return true;

        } else
            return false;

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

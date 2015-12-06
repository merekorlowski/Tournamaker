package com.example.merek.tournamaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Tournament implements Serializable {

    //declare variables
    private String type;
    private String name;
    private boolean active;
    private ArrayList<TeamTournamentStats> teamTournamentStatsList;
    private ArrayList<Round> rounds;

    //tournament constructor
    public Tournament(String type, String name, boolean active, ArrayList<TeamTournamentStats> teamTournamentStatsList) {
        this.type = type;
        this.name = name;
        this.active = active;
        this.teamTournamentStatsList = teamTournamentStatsList;
        rounds = new ArrayList<>();

        //determine number of rounds by type
        /*if(type.equals("Round Robin"))
            rounds = new Round[teamTournamentStatsList.size()];

        else if(type.equals("Knockout"))
            rounds = new Round[(int)Math.log(2)*teamTournamentStatsList.size()];

        else
            rounds = new Round[(teamTournamentStatsList.size()) + (int)Math.log(2)*((teamTournamentStatsList.size())/3)];*/

    }

    //initialize a new round
    public void initializeRound(int i, ArrayList<TeamTournamentStats> teamTournamentStatsList) {
        rounds.set(i, new Round(i, teamTournamentStatsList));
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

    public ArrayList<TeamTournamentStats> getTeamTournamentStatsList() {
        return teamTournamentStatsList;
    }

    public ArrayList<String> getTeamNames() {

        //initialize arraylist of team names,
        //used to populate team select and edit lists
        ArrayList<String> names = new ArrayList<>();

        for(int i = 0; i < teamTournamentStatsList.size(); i++) {
            names.add(teamTournamentStatsList.get(i).getTeamName());
        }

        return names;

    }

    public ArrayList<String> getStatistics() {

        //initialize array list of stats,
        //used to populate statistics page
        ArrayList<String> stats = new ArrayList<>();

        Collections.sort(teamTournamentStatsList);

        for(int i = 0; i < teamTournamentStatsList.size(); i++) {
            stats.add(teamTournamentStatsList.get(i).getStats());
        }

        return stats;
    }

    //returns team by a specific name
    public TeamTournamentStats getTeam(String name) {

        int i = 0;
        while(teamTournamentStatsList.get(i).getTeamName() != name) {
            i++;
        }

        return teamTournamentStatsList.get(i);
    }

    public void setTeamTournamentStatsList(ArrayList<TeamTournamentStats> t) {
        teamTournamentStatsList = t;
    }

    public Round getRound(int i) {
        return rounds.get(i);
    }

    public int getNumberOfRounds() {
        return rounds.size();
    }

    public void add(TeamTournamentStats t) {
        teamTournamentStatsList.add(t);
    }

    //remove team from tournament
    public void remove(TeamTournamentStats t) {
        teamTournamentStatsList.remove(t);
    }

    //tests to see if this tournament is active
    public boolean isActive() {
        return active;
    }

    public void setIsActive(boolean isActive) {
        active = isActive;
    }

}

package com.example.merek.tournamaker;

import java.util.ArrayList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament {

    private String type;
    private String name;
    private boolean completed;
    private ArrayList<Team> teams;
    private Round[] rounds;

    public Tournament(String type, String name, boolean completed, ArrayList<Team> teams) {
        this.type = type;
        this.name = name;
        this.completed = completed;
        this.teams = teams;
        rounds = new Round[teams.size() - 1];
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public boolean isCompleted() {
        return completed;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> t) {
        teams = t;
    }

    public Team getWinner() {

        //return team that has won the most games
        if(type.equals("RoundRobin")) {
            Team winner = teams.get(0);
            Team current = teams.get(1);

            for(int i = 1; i < teams.size(); i++) {
                if (winner.getNumGamesWon() > teams.get(i).getNumGamesWon())
                    winner = teams.get(i);
            }

            return winner;

        //return last team in the list
        } else
            return teams.get(0);

    }

}

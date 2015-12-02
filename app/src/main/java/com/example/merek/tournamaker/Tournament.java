package com.example.merek.tournamaker;

import java.util.LinkedList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament {

    private String type;
    private String name;
    private boolean completed;
    private LinkedList<Team> teams;
    private Round[] rounds;

    public Tournament(String type, String name, boolean completed, LinkedList<Team> teams, Round[] rounds) {
        this.type = type;
        this.name = name;
        this.completed = completed;
        this.teams = teams;
        this.rounds = rounds;
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

    public LinkedList<Team> getTeams() {
        return teams;
    }

    public void setTeams(LinkedList<Team> t) {
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

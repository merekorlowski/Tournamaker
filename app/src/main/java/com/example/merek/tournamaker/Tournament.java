package com.example.merek.tournamaker;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament {

    private String type;
    private String name;
    private boolean completed;
    private ArrayList<Team> teams;
    private Round[] rounds;
    private Bracket[] brackets;
    private ArrayList<Team> firstHalf;
    private ArrayList<Team> secondHalf;
    private ArrayList<Team> winningTeams;

    public Tournament(String type, String name, boolean completed, ArrayList<Team> teams) {
        this.type = type;
        this.name = name;
        this.completed = completed;
        this.teams = teams;

        if(type.equals("RoundRobin"))
            rounds = new Round[teams.size() - 1];
        else if(type.equals("Knockout"))
            rounds = new Round[(int)Math.log(2)*teams.size()];
        else {
            /*brackets = new Bracket[2];
            firstHalf = new ArrayList<Team>();
            secondHalf = new ArrayList<Team>();
            winningTeams = new ArrayList<Team>();

            for(int i = 0; i < teams.size()/2; i++)
                firstHalf.set(i, teams.get(i));
            for(int i = teams.size()/2; i < teams.size(); i++)
                secondHalf.set(i, teams.get(i));

            brackets[1] = new Bracket(firstHalf);
            brackets[2] = new Bracket(secondHalf);*/

            rounds = new Round[(teams.size() - 1)/2 + (int)Math.log(2)*((teams.size() - 1)/2)];
        }

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
        Collections.sort(teams);
        return teams.get(teams.size() - 1);
    }
}

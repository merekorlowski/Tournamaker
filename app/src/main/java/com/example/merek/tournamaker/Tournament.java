package com.example.merek.tournamaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament implements Serializable {

    private String type;
    private String name;
    private boolean active;
    private ArrayList<Team> teams;
    private Round[] rounds;
    private Bracket[] brackets;
    private ArrayList<Team> firstHalf;
    private ArrayList<Team> secondHalf;
    private ArrayList<Team> winningTeams;

    public Tournament(String type, String name, boolean active, ArrayList<Team> teams) {
        this.type = type;
        this.name = name;
        this.active = active;
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

    public void playRound(int i, ArrayList<Team> teams) {
        rounds[i] = new Round(i, teams);
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

    public boolean isActive() {
        return active;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<String> getTeamNames() {
        ArrayList<String> names = new ArrayList<>();
        for(int i = 0; i < teams.size(); i++) {
            names.add(teams.get(i).getName());
        }
        return names;
    }

    public void add(Team t) {
        if(!teams.contains(t))
            teams.add(t);
        else//temporary, need a way to pop up error
            System.out.println("Team already exists in tournament.");
    }

    public void remove(Team t) {
        teams.remove(t);
    }

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

    public Team getWinner() {
        Collections.sort(teams);
        return teams.get(teams.size() - 1);
    }

    public Round getRound(int i) {
        return rounds[i];
    }

    public void setRound(int i, ArrayList<Team> teams, int numOfGames) {
        rounds[i] = new Round(i, teams);
    }
}

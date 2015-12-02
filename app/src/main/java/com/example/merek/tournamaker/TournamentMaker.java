package com.example.merek.tournamaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Merek on 2015-12-02.
 */
public class TournamentMaker {

    private ArrayList<Tournament> tournaments;
    private ArrayList<Team> teams;
    private static TournamentMaker instance = null;

    private TournamentMaker(ArrayList<Tournament> tournaments, ArrayList<Team> teams) {
        this.tournaments = tournaments;
        this.teams = teams;
    }

    public static TournamentMaker getInstance() {
        if(instance == null) {
            instance = new TournamentMaker(new ArrayList<Tournament>(), new ArrayList<Team>());
        }
        return instance;
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public void addTournament(Tournament t) {
        tournaments.add(t);
    }

    public void deleteTournament(Tournament t) {
        tournaments.remove(t);
    }

    public void addTeam(Team t) {
        if(!teams.contains(t))
            teams.add(t);
        else//temporary, need a way to pop up error
            System.out.println("Team already exists in tournamament maker.");
    }

    public void deleteTeam(Team t) {
        teams.remove(t);
    }

}

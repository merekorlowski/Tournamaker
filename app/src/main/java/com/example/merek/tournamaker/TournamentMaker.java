package com.example.merek.tournamaker;

import java.util.ArrayList;


//Singleton
public class TournamentMaker {

    //initialize variables
    private ArrayList<Tournament> tournaments = new ArrayList<>(); // All tournaments in the app
    private ArrayList<String> teams = new ArrayList<>(); // ALl teams in the app
    private static TournamentMaker instance;

    //private tournament maker constructor
    private TournamentMaker() {}

    //used to make sure only one instance can be created
    public static synchronized TournamentMaker getInstance() {
        if(instance == null) {
            instance = new TournamentMaker();
        }
        return instance;
    }

    //getters and setters
    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public Tournament getTournament(int i) {
        return tournaments.get(i);
    }

    //used to populate load list
    public ArrayList<String> getTournamentNames() {

        ArrayList<String> names = new ArrayList<>();

        for(int i = 0; i < tournaments.size(); i++) {
            names.add(tournaments.get(i).getName());
        }

        return names;

    }

    public ArrayList<String> getTeams() {
        return teams;
    }

    public void setTeamName(int i, String name) {
        teams.set(i, name);
    }

    public void addTournament(Tournament t) {
        tournaments.add(t);
    }

    public void deleteTournament(Tournament t) {
        tournaments.remove(t);
    }

    public void add(String team) {
        teams.add(team);
    }



    public void deleteTeam(int i) {
        teams.remove(i);
    }


}

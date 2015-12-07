package com.example.merek.tournamaker;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


//Singleton
public class TournamentMaker {

    //initialize variables
    private ArrayList<Tournament> tournaments = new ArrayList<>(); // All tournaments in the app
    private List<String> teams = new ArrayList<>(); // ALl teams in the app
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

    public List<String> getTeams(Context context) {
        TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(context);
        teams = databaseHelper.getAllTeams();
        return teams;
    }

    public void setTeamName(Context context, int i, String name) {
        TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(context);
        databaseHelper.editTeamName(teams.get(i), name);
        teams = databaseHelper.getAllTeams();
    }

    public void addTournament(Context context, Tournament t) {
        TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(context);
        databaseHelper.addTournament(t);
    }

    public void deleteTournament(Tournament t) {
        tournaments.remove(t);
    }

    public void addTeam(Context context, String team) {
        TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(context);
        databaseHelper.addTeam(team);
        teams = databaseHelper.getAllTeams();
    }



    public void deleteTeam(Context context, int i) {
        TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(context);
        databaseHelper.deleteTeam(teams.get(i));
        teams = databaseHelper.getAllTeams();
    }


}

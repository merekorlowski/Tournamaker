package com.example.merek.tournamaker;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Merek on 2015-12-02.
 */
public class TournamentMaker {

    private ArrayList<Tournament> tournaments;
    private static TournamentMaker instance = null;

    private TournamentMaker(ArrayList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public static TournamentMaker getInstance() {
        if(instance == null) {
            instance = new TournamentMaker(new ArrayList<Tournament>());
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

}

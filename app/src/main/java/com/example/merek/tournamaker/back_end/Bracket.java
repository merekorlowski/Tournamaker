package com.example.merek.tournamaker.back_end;

import com.example.merek.tournamaker.back_end.Round;
import com.example.merek.tournamaker.back_end.Team;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Merek on 2015-12-01.
 */
public class Bracket {

    private ArrayList<Team> teams;
    private Round[] rounds;

    public Bracket(ArrayList<Team> teams) {
        this.teams = teams;
        rounds = new Round[teams.size() - 1];
    }

    public ArrayList<Team> getTopTeams() {
        Collections.sort(teams);
        ArrayList<Team> topHalf = new ArrayList<Team>();
        for(int i = 0; i < teams.size()/2; i++) {
            topHalf.set(i, teams.get(i));
        }
        return topHalf;
    }

}


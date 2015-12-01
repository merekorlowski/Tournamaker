package com.example.merek.tournamaker;

import java.util.LinkedList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Tournament {

    private String name;
    private LinkedList<Team> teams;
    private String type;
    private Round[] r;

    public Tournament(String name, LinkedList<Team> teams, String type, Round[] r) {
        this.name = name;
        this.teams = teams;
        this.type = type;
        this.r = r;
    }



}

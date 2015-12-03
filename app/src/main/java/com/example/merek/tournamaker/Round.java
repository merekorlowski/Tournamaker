package com.example.merek.tournamaker;

import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Round {

    private int roundNumber;
    private ArrayList<Team> teams;
    private int numOfGames;
    private Game[] games;


    public Round(int roundNumber, ArrayList<Team> teams) {
        this.roundNumber = roundNumber;
        this.teams = teams;
        numOfGames = teams.size()/2;
        games = new Game[numOfGames];
    }

    public void playGames() {

        Team pass = new Team();
        //if there is an impair number of teams, pass the last one to the next round
        if(teams.size() % 2 == 1) {
            pass = teams.get(teams.size() - 1);
            teams.remove(teams.size() - 1);
        }
        /*for(int i = 0; i < numOfGames; i++) {
            for(int j = i + 1; j < numOfGames; j++)
                games[i] = new Game(teams.get(i), teams.get(j));
        }*/

        for(int i = 0; i < numOfGames; i += 2) {
            games[i] = new Game(teams.get(i), teams.get(i + 1));
        }

        //randomize play order
        Collections.shuffle(Arrays.asList(games));
        //place pass team to the front of the list to ensure it plays next round
        if(pass != new Team())
            teams.add(0, pass);

    }

    public ArrayList<Team> getRoundWinners() {

        ArrayList<Team> winners = new ArrayList<Team>();

        for(int i = 0; i < numOfGames; i++) {
            winners.add(games[i].getWinner());
        }

        return winners;

    }

}
package com.example.merek.tournamaker;

import java.util.Collections;
import java.util.ArrayList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Round {

    private int roundNumber;
    private int numOfGames;
    private Game[] games;
    private ArrayList<Team> teams;

    public Round(int roundNumber,ArrayList<Team> teams, int numOfGames) {
        this.roundNumber = roundNumber;
        this.teams = teams;
        this.numOfGames = numOfGames;
        games = new Game[numOfGames];
    }

    public void randomizePlayOrder() {

        Collections.shuffle(teams);

        int j = 0;
        for(int i = 0; i < numOfGames; i++) {
            games[i] = new Game(teams.get(j), teams.get(j+1));
            j = j + 2;
        }

    }

    public ArrayList<Team> getRoundWinners() {

        ArrayList<Team> winners = new ArrayList<Team>();

        for(int i = 0; i < numOfGames; i++) {
            winners.add(games[i].getWinner());
        }

        return winners;

    }

}
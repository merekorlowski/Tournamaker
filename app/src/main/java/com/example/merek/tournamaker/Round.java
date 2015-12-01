package com.example.merek.tournamaker;

import java.util.LinkedList;

/**
 * Created by Merek on 2015-12-01.
 */
public class Round {

    private int roundNumber;
    private int numOfGames;
    private Game[] games;
    private LinkedList<Team> teams;

    public Round(int roundNumber, int numOfGames, LinkedList<Team> teams) {
        this.roundNumber = roundNumber;
        this.numOfGames = numOfGames;
        games = new Game[numOfGames];
        this.teams = teams;
    }

    public void randomizePlayOrder() {

    }

    public LinkedList<Team> getRoundWinners() {

        LinkedList<Team> winners = new LinkedList<Team>();

        for(int i = 0; i < numOfGames; i++) {
            winners.add(games[i].getWinner());
        }

        return winners;

    }

}
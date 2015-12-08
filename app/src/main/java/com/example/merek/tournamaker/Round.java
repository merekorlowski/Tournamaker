package com.example.merek.tournamaker;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class  Round implements Serializable {

    //declare variables
    private int roundNumber;
    private ArrayList<Team> teams;
    private int numOfGames;
    private Game[] games;

    //round constructor
    public Round(int roundNumber, ArrayList<Team> teams) {
        this.roundNumber = roundNumber;
        this.teams = teams;
        numOfGames = teams.size()/2;
        games = new Game[numOfGames]; //initialize array of games of size numOfGames
    }

    public void setGames() {

        //initialize team to pass
        Team bye = null;

        //if there is an impair number of teams, pass the last one to the next round
        if(teams.size() % 2 == 1) {
            bye = teams.get(teams.size() - 1);
            teams.remove(teams.size() - 1);
        }
        //initialize games
        int j = 0;
        for(int i = 0; i < numOfGames; i++) {
            games[i] = new Game(teams.get(j), teams.get(j + 1));
            j += 2;
        }

        //randomize play order
        Collections.shuffle(Arrays.asList(games));

        //place pass team to the front of the list to ensure it plays next round
        if(bye != null)
            teams.add(0, bye);

    }

    public ArrayList<Team> getTeamList() {
        return teams;
    }

    //returns an arraylist of all the winners of this round
    public ArrayList<Team> getRoundWinners() {

        //initialize arraylist of winners
        ArrayList<Team> winners = new ArrayList<>();

        for(int i = 0; i < numOfGames; i++) {

            if(games[i].getWinner() == null) {

                winners.add(games[i].getTeamOne());
                winners.add(games[i].getTeamTwo());

            } else
                winners.add(games[i].getWinner());

        }
        return winners;

    }

    //returns arraylist of game scores of this round
    public ArrayList<String> getGameScoreList() {

        //initialize arraylist of game scores
        ArrayList<String> gameList = new ArrayList<>();

        for(int i = 0; i < games.length; i++) {
            gameList.add(games[i].getScore());
        }

        return gameList;

    }

    //getters

    public int getRoundNumber() {
        return roundNumber;
    }

    public Game getGame(int i) {
        return games[i];
    }

    public int getNumOfGames() {
        return numOfGames;
    }

}
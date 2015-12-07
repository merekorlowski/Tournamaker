package com.example.merek.tournamaker;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Round implements Serializable {

    //declare variables
    private int roundNumber;
    private ArrayList<Team> teams;
    private Tournament tournament;
    private ArrayList<Game> games;

    //round constructor
    public Round(int roundNumber, ArrayList<Team> teams, Tournament tournament) {
        this.roundNumber = roundNumber;
        this.teams = teams;
        this.tournament = tournament;
        games = new ArrayList<>();
    }

    public void setGames() {

        //initialize team to pass
        Team pass;

        //initialize games
        int k = 0;
        for(int i = 0; i < teams.size(); i++) {
            for(int j = i + 1; j < teams.size(); j++) {
                if(roundNumber > 0) {
                    if (!teams.get(i).hasPlayed(teams.get(j), tournament.getRound(roundNumber - 1))
                            && (!teams.get(i).isPlaying() || !teams.get(i).isPlaying())) {
                        games.add(new Game(teams.get(i), teams.get(j)));
                        k++;
                    }
                } else {
                    if (!teams.get(i).isPlaying() || !teams.get(i).isPlaying()) {
                        games.add(new Game(teams.get(i), teams.get(j)));
                        k++;
                    }
                }
            }
        }

        //randomize play order
        Collections.shuffle(games);

        //if there is an impair number of teams, pass the last one to the next round
        if(teams.size() % 2 == 1) {
            pass = teams.get(teams.size() - 1);
            teams.remove(teams.size() - 1);
            teams.add(0, pass);
        }

    }

    public ArrayList<Team> getTeamList() {
        return teams;
    }

    public Tournament getTournament() {
        return tournament;
    }

    //returns an arraylist of all the winners of this round
    public ArrayList<Team> getRoundWinners() {

        //initialize arraylist of winners
        ArrayList<Team> winners = new ArrayList<>();

        for(int i = 0; i < games.size(); i++) {

            if(games.get(i).getWinner() == null) {

                winners.add(games.get(i).getTeamOne());
                winners.add(games.get(i).getTeamTwo());

            } else
                winners.add(games.get(i).getWinner());

        }
        return winners;

    }

    //returns arraylist of game scores of this round
    public ArrayList<String> getGameScoreList() {

        //initialize arraylist of game scores
        ArrayList<String> gameList = new ArrayList<>();

        for(int i = 0; i < games.size(); i++) {
            gameList.add(games.get(i).getScore());
        }

        return gameList;

    }

    //getters

    public int getRoundNumber() {
        return roundNumber;
    }

    public Game getGame(int i) {
        return games.get(i);
    }

    public int getNumOfGames() {
        return games.size();
    }

}
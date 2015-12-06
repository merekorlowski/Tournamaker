package com.example.merek.tournamaker;

/**
 * Created by Merek on 2015-12-01.
 */
public class Game {

    //declare variables
    private Team teamOne;
    private Team teamTwo;

    //game constructor
    public Game(Team teamOne, Team teamTwo) {

        this.teamOne = teamOne;
        this.teamTwo = teamTwo;

    }

    //returns winner of this game
    public Team getWinner() {

        if(teamOne.getNumOfGoals() > teamTwo.getNumOfGoals()) {

            teamOne.incrementNumGamesWon(); //increment t1's number of wins
            teamTwo.incrementNumGamesLost(); //increment t2's number of loses

            return teamOne;

        } else {

            teamOne.incrementNumGamesLost(); //increment t1's number of loses
            teamTwo.incrementNumGamesWon(); //increment t2's number of wins

            return teamTwo;

        }

    }

    //getters
    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public String getTeamOneName() {
        return teamOne.getName();
    }

    public String getTeamTwoName() {
        return teamTwo.getName();
    }


    //return String of this games score
    public String getScore() {
        return (teamOne.getName() + "-" + teamOne.getNumOfGoals() + " " + teamTwo.getNumOfGoals() + "-" + teamTwo.getName());
    }

}

package com.example.merek.tournamaker;

import java.io.Serializable;

public class Game implements Serializable{

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

        if(teamOne.getNumOfGoals() > teamTwo.getNumOfGoals())
            return teamOne;
        else if(teamOne.getNumOfGoals() < teamTwo.getNumOfGoals())
            return teamTwo;
        else
            return null;

    }

    public void editWinsAndLosses() {

        if(teamOne.getNumOfGoals() > teamTwo.getNumOfGoals()) {

            teamOne.incrementNumGamesWon(); //increment t1's number of wins
            teamTwo.incrementNumGamesLost(); //increment t2's number of loses

        } else if(teamOne.getNumOfGoals() < teamTwo.getNumOfGoals()){

            teamOne.incrementNumGamesLost(); //increment t1's number of loses
            teamTwo.incrementNumGamesWon(); //increment t2's number of wins

        } else {}
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
        return (teamOne.getName() + " - " + teamOne.getNumOfGoals() + " , " + teamTwo.getName() + " - " + teamTwo.getNumOfGoals());
    }

}

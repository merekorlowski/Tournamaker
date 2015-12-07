package com.example.merek.tournamaker;

import java.io.Serializable;

public class Game implements Serializable{

    //declare variables
    private Team teamOne;
    private Team teamTwo;

    //game constructor
    public Game(Team teamOne, Team teamTwo) {

        this.teamOne = teamOne;
        this.teamOne.setIsPlaying(true);
        this.teamTwo = teamTwo;
        this.teamTwo.setIsPlaying(true);

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

    public boolean contains(Team tOne, Team tTwo) {

        if((teamOne.equals(tOne) && teamTwo.equals(tTwo))
                || (teamOne.equals(tTwo) && teamOne.equals(tOne)))
            return true;
        else
            return false;

    }

    //return String of this games score
    public String getScore() {
        return (teamOne.getName() + " - " + teamOne.getNumOfGoals() + " , " + teamTwo.getName() + " - " + teamTwo.getNumOfGoals());
    }

}

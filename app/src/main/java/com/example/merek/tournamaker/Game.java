package com.example.merek.tournamaker;

public class Game {

    //declare variables
    private TeamTournamentStats teamTournamentStatsOne;
    private TeamTournamentStats teamTournamentStatsTwo;

    //game constructor
    public Game(TeamTournamentStats teamTournamentStatsOne, TeamTournamentStats teamTournamentStatsTwo) {

        this.teamTournamentStatsOne = teamTournamentStatsOne;
        this.teamTournamentStatsTwo = teamTournamentStatsTwo;

    }

    //returns winner of this game
    public TeamTournamentStats getWinner() {

        if(teamTournamentStatsOne.getNumOfGoals() > teamTournamentStatsTwo.getNumOfGoals()) {

            teamTournamentStatsOne.incrementNumGamesWon(); //increment t1's number of wins
            teamTournamentStatsTwo.incrementNumGamesLost(); //increment t2's number of loses

            return teamTournamentStatsOne;

        } else if(teamTournamentStatsOne.getNumOfGoals() < teamTournamentStatsTwo.getNumOfGoals()) {

            teamTournamentStatsOne.incrementNumGamesLost(); //increment t1's number of loses
            teamTournamentStatsTwo.incrementNumGamesWon(); //increment t2's number of wins

            return teamTournamentStatsTwo;

        } else {

            return null;

        }

    }

    //getters
    public TeamTournamentStats getTeamTournamentStatsOne() {
        return teamTournamentStatsOne;
    }

    public TeamTournamentStats getTeamTournamentStatsTwo() {
        return teamTournamentStatsTwo;
    }

    public String getTeamOneName() {
        return teamTournamentStatsOne.getTeamName();
    }

    public String getTeamTwoName() {
        return teamTournamentStatsTwo.getTeamName();
    }


    //return String of this games score
    public String getScore() {
        return (teamTournamentStatsOne.getTeamName() + "-" + teamTournamentStatsOne.getNumOfGoals() + " " + teamTournamentStatsTwo.getNumOfGoals() + "-" + teamTournamentStatsTwo.getTeamName());
    }

}

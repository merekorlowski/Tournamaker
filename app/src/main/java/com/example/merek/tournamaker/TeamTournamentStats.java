package com.example.merek.tournamaker;

public class TeamTournamentStats implements Comparable {

    //declare variables
    private Team team;
    private Tournament tournament;
    private int numOfGoals;
    private int numGamesWon;
    private int numGamesLost;
    private int leaguePosition;


    //team constructor
    public TeamTournamentStats(Team team, Tournament tournament, int numOfGoals, int numGamesWon, int numGamesLost, int leaguePosition) {
        this.team = team;
        this.tournament = tournament;
        this.numOfGoals = numOfGoals;
        this.numGamesWon = numGamesWon;
        this.numGamesLost = numGamesLost;
        this.leaguePosition = leaguePosition;
    }

    public TeamTournamentStats(Team team, Tournament tournament){
        this.numOfGoals = 0;
        this.numGamesWon = 0;
        this.numGamesLost = 0;
        this.leaguePosition = 0;
    }

    public TeamTournamentStats(){}

    //getters and setters
    public String getTeamName(){
        return team.getName();
    }

    public void setTeamName( String name ){
        team.setName(name);
    }

    public String getTournamentName(){
        return tournament.getName();
    }

    public int getNumOfGoals() {
        return numOfGoals;
    }

    public void setNumOfGoals(int goals) {
        numOfGoals = goals;
    }

    public int getNumGamesWon() {
        return numGamesWon;
    }

    public int getNumGamesLost() {
        return numGamesLost;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    //increment this teams number of games won
    public void incrementNumGamesWon() {
        numGamesWon++;
    }

    //increment this teams number of games lost
    public void incrementNumGamesLost() {
        numGamesLost++;
    }

    //used to sort teams by order of number of games won
    @Override
    public int compareTo(Object another) {
        return getNumGamesWon() - ((TeamTournamentStats)another).getNumGamesWon();
    }

    public String getStats() {
        return team.getName() + ", " + numGamesWon + " wins, " + numGamesLost + " loses";
    }
}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    //declare variables
    Tournament tournament;
    Round round;
    int roundNumber;
    ArrayList<Team> winningTeamList;
    int gameNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize roundNumber and tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        roundNumber = (int)i.getSerializableExtra("roundNumber");
        gameNumber = (int)i.getSerializableExtra("gameNumber");

        if(roundNumber > 1)
            winningTeamList = (ArrayList<Team>)i.getSerializableExtra("teams");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        setRoundNumber();

    }

    //set text view to current round #
    public void setRoundNumber() {

        TextView textView = (TextView) findViewById(R.id.roundNumberTextView);

        //set round number
        textView.setText("" + roundNumber);

    }

    public void startRoundClick(View v){

        //initialize round
        ArrayList<Team> teamList = tournament.getTeamList();

        if(tournament.getType().equals("Round Robin"))
            tournament.initializeRound(roundNumber - 1, teamList);
        else if(tournament.getType().equals("Knockout"))
            tournament.initializeRound(roundNumber - 1, winningTeamList);
        else {

            if(roundNumber < teamList.size() - 1)
                tournament.initializeRound(roundNumber - 1, teamList);
            else
                tournament.initializeRound(roundNumber - 1, winningTeamList);

        }

        round = tournament.getRound(roundNumber - 1);

        Intent intent = new Intent(this, GameActivity.class);

        //track round by sending it as an extra
        intent.putExtra("Round", round);
        intent.putExtra("gameNumber", gameNumber);

        startActivity(intent);
    }

    public void viewStatsClick(View v){

        //Open the stats page
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        Intent intent;

        if(roundNumber > 1) {

            intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Tournament", tournament);

        } else {

            intent = new Intent(this, TournamentSetup.class);

        }

        intent.putExtra("round", round);
        startActivity(intent);

    }

}
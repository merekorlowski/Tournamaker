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
    int currentRoundIndex;
    int numOfRounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize roundNumber and tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        currentRoundIndex = (int)i.getSerializableExtra("roundIndex");

        round = tournament.getRound(currentRoundIndex);

        ArrayList<Team> teamList = tournament.getTeamList();

        if(tournament.getType().equals("Round Robin"))
            tournament.setNumOfRounds(teamList.size() - 1);
        else if(tournament.getType().equals("Knockout"))
            tournament.setNumOfRounds((int)Math.round(Math.log(2)*(teamList.size())));
        else
            tournament.setNumOfRounds(teamList.size() - 1 + (int)Math.round(Math.log(2)*((teamList.size())/3)));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        setRoundNumber();

    }

    //set text view to current round #
    public void setRoundNumber() {

        TextView textView = (TextView) findViewById(R.id.roundNumberTextView);

        //set round number
        textView.setText("" + (currentRoundIndex + 1));

    }

    public void startRoundClick(View v){

        round.setGames();

        Intent intent = new Intent(this, GameActivity.class);

        //track round by sending it as an extra
        intent.putExtra("Tournament", tournament);
        intent.putExtra("Round", round);
        intent.putExtra("gameIndex", 0);

        startActivity(intent);

    }

    public void viewStatsClick(View v){

        //Open the stats page
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.putExtra("Tournament", tournament);
        intent.putExtra("roundIndex", currentRoundIndex);
        startActivity(intent);

    }

    /*@Override
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

    }*/

}
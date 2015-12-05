package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Round;
import com.example.merek.tournamaker.back_end.Team;
import com.example.merek.tournamaker.back_end.Tournament;

import java.util.ArrayList;

public class RoundActivity extends AppCompatActivity {

    //declare variables
    Tournament tournament;
    Round round;
    int roundNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize roundNumber and tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        roundNumber = (int)i.getSerializableExtra("roundNumber");

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
        ArrayList<Team> teams = tournament.getTeams();
        tournament.initializeRound(roundNumber - 1, teams);
        round = tournament.getRound(roundNumber - 1);

        Intent intent = new Intent(this, GameActivity.class);

        //track round by sending it as an extra
        intent.putExtra("Round", round);
        intent.putExtra("gameNumber", 1);

        startActivity(intent);
    }

    public void viewStatsClick(View v){

        //Open the stats page
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }

}
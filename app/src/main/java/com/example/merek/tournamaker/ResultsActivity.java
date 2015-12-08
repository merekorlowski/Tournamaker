package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    //declare variables
    private Tournament tournament;
    private Round round;
    private ArrayList<Team> teamList;
    private ArrayList<Team> winningTeamList;
    private int currentRoundIndex;
    private int nextRoundIndex;
    private int numOfRounds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        round = (Round)i.getSerializableExtra("Round");
        teamList = round.getTeamList();
        winningTeamList = round.getRoundWinners();
        currentRoundIndex = round.getRoundNumber();
        nextRoundIndex = currentRoundIndex + 1;
        numOfRounds = tournament.getNumberOfRounds();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        if(currentRoundIndex == numOfRounds - 1) {

            Button btn = (Button) findViewById(R.id.buttonContinue);
            btn.setText("View stats");

        }

        populateListView();
    }

    //populate the results with the game scores of this tournament
    public void populateListView() {

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, round.getGameScoreList());
        ListView listview = (ListView) findViewById(R.id.gamesList);
        listview.setAdapter(adapter);

    }

    //go to next round when clicked
    public void gotToNextRoundClick(View view) {

        if(tournament.getType().equals("Round Robin")) {

            if (currentRoundIndex < numOfRounds - 1)
                tournament.initializeRound(nextRoundIndex, teamList);

        } else if(tournament.getType().equals("Knockout")) {

            if (currentRoundIndex < numOfRounds - 1)
                tournament.initializeRound(nextRoundIndex, winningTeamList);

        } else {

            if (currentRoundIndex < numOfRounds - 1) {

                if (currentRoundIndex < teamList.size() - 1)
                    tournament.initializeRound(nextRoundIndex, teamList);
                else
                    tournament.initializeRound(nextRoundIndex, winningTeamList);

            }

        }

        Intent intent;

        if(currentRoundIndex == numOfRounds - 1) {

            //sets tournament to inactive
            tournament.setIsActive(false);

            intent = new Intent(this, StatisticsActivity.class);
            intent.putExtra("Tournament", tournament);

        } else {

            intent = new Intent(this, RoundActivity.class);
            intent.putExtra("Tournament", tournament);
            intent.putExtra("roundIndex", nextRoundIndex);

        }

        startActivity(intent);

    }

}
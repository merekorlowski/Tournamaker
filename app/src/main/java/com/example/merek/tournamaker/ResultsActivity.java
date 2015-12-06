package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultsActivity extends AppCompatActivity {

    //declare variables
    Tournament tournament;
    Round round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        round = (Round)i.getSerializableExtra("Round");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

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

        Intent intent;

        if(round.getRoundNumber() == tournament.getNumberOfRounds()) {

            intent = new Intent(this, StatisticsActivity.class);

            //sets tournament to inactive
            tournament.setIsActive(false);

            startActivity(intent);

        } else {

            intent = new Intent(this, RoundActivity.class);
            intent.putExtra("teams", round.getRoundWinners());
            intent.putExtra("roundNumber", round.getRoundNumber() + 1);
            startActivity(intent);

        }

    }

}

package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Round;
import com.example.merek.tournamaker.back_end.Tournament;

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

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, round.getGameScoreList());
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);

    }

    //go to next round when clicked
    public void gotToNextRoundClick() {

        Intent intent = new Intent(this, RoundActivity.class);
        intent.putExtra("roundNumber", round.getRoundNumber() + 1);
        startActivity(intent);

    }

}

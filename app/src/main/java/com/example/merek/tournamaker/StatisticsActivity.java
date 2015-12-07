package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class StatisticsActivity extends AppCompatActivity {

    //declare variable
    Tournament tournament;
    int currentRoundIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        currentRoundIndex = (int)i.getSerializableExtra("roundIndex");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        populateListView();
    }

    //populate list with team standings
    public void populateListView() {

        //get array list of tournament stats
        ArrayList<String> stats = tournament.getStatistics();

        //populate
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, stats);
        ListView listview = (ListView) findViewById(R.id.statsListView);
        listview.setAdapter(adapter);

    }

    public void exitStats(View view) {

        Intent intent;

        if(!tournament.isActive())
            intent = new Intent(this, MainActivity.class);
        else {
            intent = new Intent(this, RoundActivity.class);
            intent.putExtra("Tournament", tournament);
            intent.putExtra("roundIndex", currentRoundIndex);
        }


        startActivity(intent);

    }

}
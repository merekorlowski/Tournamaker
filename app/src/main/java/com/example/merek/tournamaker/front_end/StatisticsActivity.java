package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Team;
import com.example.merek.tournamaker.back_end.Tournament;

import java.util.ArrayList;
import java.util.Collections;

public class StatisticsActivity extends AppCompatActivity {

    //declare variable
    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        populateListView();
    }

    //populate list with team standings
    public void populateListView() {


        //sort teams by number of wins
        ArrayList<Team> teams  = tournament.getTeams();
        Collections.sort(teams);

        //get array list of tournament stats
        ArrayList<String> stats = tournament.getStatistics();

        //populate
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stats);
        ListView listview = (ListView) findViewById(R.id.statsListView);
        listview.setAdapter(adapter);

    }

}
package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SelectTeams extends AppCompatActivity {

    //declare variable
    Tournament tournament;
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);

        populateList();
        //registerClickCallback();

    }

    //populate list view with all teams in tournament maker
    public void populateList() {

        //initialize arraylist of teams
        ArrayList<String> teamNames = TournamentMaker.getInstance().getTeams();

        //add to listview
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, teamNames);
        listview = (ListView) findViewById(R.id.listviewSelectTeams);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listview.setAdapter(adapter);

    }

    public void submitTeamSelection(View view) {

        SparseBooleanArray sba = listview.getCheckedItemPositions();

        for(int i = 0; i < sba.size(); i++) {
            if(sba.valueAt(i)) {
                String name = TournamentMaker.getInstance().getTeam(i);
                tournament.add(new Team(name, tournament));
            }
        }

        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }
}


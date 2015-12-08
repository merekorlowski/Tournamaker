package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class SelectTeams extends AppCompatActivity {

    //declare variable
    private Tournament tournament;
    private ListView listview;

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
        List<String> teamNames = TournamentMaker.getInstance().getTeams(this);

        //add to listview
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, teamNames);
        listview = (ListView) findViewById(R.id.listviewSelectTeams);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listview.setAdapter(adapter);

    }

    public void submitTeamSelection(View view) {

        ArrayList<Team> teams = new ArrayList<>();

        SparseBooleanArray sba = listview.getCheckedItemPositions();

        for(int i = 0; i < sba.size(); i++) {
            if(sba.valueAt(i)) {
                String name = TournamentMaker.getInstance().getTeams(this).get(sba.keyAt(i));
                teams.add(new Team(name, tournament));
            }
        }

        if(!teams.isEmpty())
            tournament.setTeamList(teams);

        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }
}


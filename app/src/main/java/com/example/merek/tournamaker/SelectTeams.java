package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.Team;
import com.example.merek.tournamaker.Tournament;
import com.example.merek.tournamaker.TournamentMaker;

import java.util.ArrayList;


public class SelectTeams extends AppCompatActivity {

    //declare variable
    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize tournament from intent
        tournament = (Tournament) i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);

        populateList();
        registerClickCallback();

    }

    //populate list view with all teams in tournament maker
    public void populateList() {

        //initialize arraylist of teams
        ArrayList<String> teamNames = TournamentMaker.getInstance().getTeamNames();

        //add to listview
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, teamNames);
        ListView listview = (ListView) findViewById(R.id.listviewSelectTeams);
        listview.setAdapter(adapter);

    }

    //add selected teams to this tournament
    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listviewSelectTeams);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                //get team at position selected
                Team team = TournamentMaker.getInstance().getTeams().get(position);

                //add team to tournament
                tournament.add(team);

            }
        });

    }

    public void exitTeamSelection(View view) {

        Intent intent = new Intent(this, TournamentSetup.class);
        startActivity(intent);

    }
}


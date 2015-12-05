package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SelectTeams extends AppCompatActivity {

    //declare variable
    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        //retrieve objects from intent
        tournament = (Tournament) i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);
        populateList();
        registerClickCallback();
    }
    //populate list view with all teams in tournamaker
    public void populateList() {
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, TournamentMaker.getInstance().getTeams());
        ListView listview = (ListView) findViewById(R.id.listviewSelectTeams);
        listview.setAdapter(adapter);
    }

    //add selected teams to this tournament
    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listviewSelectTeams);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                tournament.add(TournamentMaker.getInstance().getTeams().get(position));
            }
        });
    }
}


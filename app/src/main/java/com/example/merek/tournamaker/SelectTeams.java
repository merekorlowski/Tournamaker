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
        tournament = (Tournament) i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_teams);

        populateList();
        //registerClickCallback();

    }

    //populate list view with all teams in tournament maker
    public void populateList() {

        //initialize arraylist of teams
        ArrayList<String> teamNames = TournamentMaker.getInstance().getTeamNames();

        //add to listview
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_multichoice, teamNames);
        listview = (ListView) findViewById(R.id.listviewSelectTeams);
        listview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listview.setAdapter(adapter);

    }

    //add selected teams to this tournament
   /* public void registerClickCallback() {

        list = (ListView) findViewById(R.id.listviewSelectTeams);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                //get team at position selected
                TeamTournamentStats team = TournamentMaker.getInstance().getTeamTournamentStatsList().get(position);

                //add team to tournament
                tournament.add(team);

            }
        });

    }*/

    public void submitTeamSelection(View view) {

        ArrayList<TeamTournamentStats> teamTournamentStatsList = new ArrayList<>();

        SparseBooleanArray sba = listview.getCheckedItemPositions();

        for(int i = 0; i < sba.size(); i++) {
            if(sba.valueAt(i)) {
                Team team = TournamentMaker.getInstance().getTeamTournamentStatsList().get(sba.keyAt(i));
                teamTournamentStatsList.add(new TeamTournamentStats(team, tournament));
            }
        }

        if(!teamTournamentStatsList.isEmpty())
            tournament.setTeamTournamentStatsList(teamTournamentStatsList);

        Intent intent = new Intent(this, TournamentSetup.class);
        startActivity(intent);

    }
}


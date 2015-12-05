package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Team;
import com.example.merek.tournamaker.back_end.TournamentMaker;

public class TeamCreate extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);

    }

    //add a new team to the list of teams
    public void createTeam(View v){

        EditText inputTxt = (EditText) findViewById(R.id.editTextTeam);
        // Store EditText in Variable
        String name = inputTxt.getText().toString();

        TournamentMaker.getInstance().addTeam(new Team(name));

        ListView listView = (ListView) findViewById(R.id.listViewEdit);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        Intent intent = new Intent(this, TeamManager.class);
        startActivity(intent);

    }


}

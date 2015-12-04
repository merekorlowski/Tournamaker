package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class TeamCreate extends AppCompatActivity {

    private TournamentMaker tournamaker;

    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournamaker = (TournamentMaker)i.getSerializableExtra("Tournamaker");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);
    }

    public void createTeam(View v){
        //add the team to the list of teams

        EditText inputTxt = (EditText) findViewById(R.id.editTextTeam);
        // Store EditText in Variable
        String name = inputTxt.getText().toString();

        tournamaker.addTeam(new Team(name, 0, 0, 0, 0));

        Intent intent = new Intent(this, TeamManager.class);
        intent.putExtra("Tournamaker", tournamaker);
        startActivity(intent);
    }


}

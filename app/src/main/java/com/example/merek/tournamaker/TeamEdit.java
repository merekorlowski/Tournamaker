package com.example.merek.tournamaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class TeamEdit extends AppCompatActivity {

    //declare variables
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables from intent
        position = (int)i.getSerializableExtra("position");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit);

        EditText team = (EditText) findViewById(R.id.editTextTeam);
        team.setText(TournamentMaker.getInstance().getTeams(this).get(position));
    }


    public void editTeam(View view) {

        EditText inputTxt = (EditText) findViewById(R.id.editTextTeam);

        // Store input in Variable
        String name = inputTxt.getText().toString();

        //displays message if user doesn't input a name
        if(name.equals("")) {

            Context context = getApplicationContext();
            CharSequence text = "Enter team name to continue.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            //displays message if tournament by that name already exists
        } else if(TournamentMaker.getInstance().getTournamentNames().contains(name)) {

            Context context = getApplicationContext();
            CharSequence text = "A team already has this name.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {

            //edit team name in list
            TournamentMaker.getInstance().setTeamName(this, position, name);

            Intent intent = new Intent(this, TeamManager.class);
            startActivity(intent);

        }
    }

    public void deleteTeam(View view) {

        //delete team from list
        TournamentMaker.getInstance().deleteTeam(this, position);

        Intent intent = new Intent(this, TeamManager.class);
        startActivity(intent);
    }


}

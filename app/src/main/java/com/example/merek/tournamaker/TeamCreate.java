package com.example.merek.tournamaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

        //displays message if user doesn't input a name
        if(name.equals("")) {

            Context context = getApplicationContext();
            CharSequence text = "Enter team name to continue.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

            //displays message if team by that name already exists
        } else if(TournamentMaker.getInstance().getTeams(this).contains(name)) {

            Context context = getApplicationContext();
            CharSequence text = "A team already has this name.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {

            TournamentMaker.getInstance().addTeam(this, name);

            Intent intent = new Intent(this, TeamManager.class);
            startActivity(intent);

        }

    }


}

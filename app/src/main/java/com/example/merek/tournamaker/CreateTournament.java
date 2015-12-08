package com.example.merek.tournamaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class CreateTournament extends AppCompatActivity {


    //declare variables
    private String type;
    private String name;
    private Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        type = (String)i.getSerializableExtra("type"); //retrieve tournament type from intent
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
    }

    public void createTournamentClick(View view) {

        EditText inputTxt = (EditText) findViewById(R.id.editTextTournament);

        // Store EditText in Variable
        name = inputTxt.getText().toString();

        //displays message if user doesn't input a name
        if(name.equals("")) {

            Context context = getApplicationContext();
            CharSequence text = "Enter tournament name to continue.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        //displays message if tournament by that name already exists
        } else if(TournamentMaker.getInstance().getTournamentNames().contains(name)) {

            Context context = getApplicationContext();
            CharSequence text = "A tournament already has this name.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        //initializes new tournament and goes to tournament setup
        } else {

            tournament = new Tournament(type, name);

            //add to list of tournaments
            TournamentMaker.getInstance().addTournament(this, tournament);

            Intent intent = new Intent(this, TournamentSetup.class);
            intent.putExtra("Tournament", tournament); //sends tournament to next activity
            startActivity(intent);

        }


    }

}

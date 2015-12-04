package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

//import android.view.Menu;
//import android.view.MenuItem;

public class CreateTournament extends AppCompatActivity {

    private TournamentMaker tournamaker;
    private String type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournamaker = (TournamentMaker)i.getSerializableExtra("Tournamaker");
        type = (String)i.getSerializableExtra("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
    }


    public void createTournamentClick(View view) {
        //create an instance of tournament, according to type
        EditText inputTxt = (EditText) findViewById(R.id.editTextTournament);

        // Store EditText in Variable
        String name = inputTxt.getText().toString();

        tournamaker.addTournament(new Tournament(type, name, false, new ArrayList<Team>()));
        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("Tournament", tournamaker.getTournament(name));
        startActivity(intent);

    }

}

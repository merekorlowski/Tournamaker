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
import com.example.merek.tournamaker.back_end.Tournament;
import com.example.merek.tournamaker.back_end.TournamentMaker;

import java.util.ArrayList;


public class CreateTournament extends AppCompatActivity {

    //declare variables
    String type;
    String name;
    Tournament tournament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize type from intent
        type = (String)i.getSerializableExtra("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);

    }

    //called when create tournament button is clicked
    public void createTournamentClick(View view) {


        EditText inputTxt = (EditText) findViewById(R.id.editTextTournament);

        //Store user input value in tournament
        name = inputTxt.getText().toString();
        tournament = new Tournament(type, name, false, new ArrayList<Team>());

        //add new tournament to tournament maker
        TournamentMaker.getInstance().addTournament(tournament);

        //update tournament list in load menu
        ListView listView = (ListView) findViewById(R.id.listViewLoad);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        Intent intent = new Intent(this, TournamentSetup.class);

        //pass tournament to next activity
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }

}

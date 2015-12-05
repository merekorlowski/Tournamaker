package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

//import android.view.Menu;
//import android.view.MenuItem;

public class CreateTournament extends AppCompatActivity {

    String type;
    String name;
    Tournament tournament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        type = (String)i.getSerializableExtra("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
    }


    public void createTournamentClick(View view) {

        ListView listView = (ListView) findViewById(R.id.listViewEdit);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        EditText inputTxt = (EditText) findViewById(R.id.editTextTournament);

        // Store EditText in Variable
        name = inputTxt.getText().toString();
        tournament = new Tournament(type, name, false, new ArrayList<Team>());
        TournamentMaker.getInstance().addTournament(tournament);

        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }

}

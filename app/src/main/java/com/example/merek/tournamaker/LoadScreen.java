package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class LoadScreen extends AppCompatActivity {

    private  TournamentMaker tournamaker;
    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournamaker = (TournamentMaker)i.getSerializableExtra("Tournamaker");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);


        // Get ListView object from xml
        ListView listview = (ListView) findViewById(R.id.listViewLoad);

        //the data to laod
        /*String[] teams = {"Game1", "game 2", "mygame", "otherPerson Game", "some game"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < teams.length; ++i) {
            list.add(teams[i]);
        }*/

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, tournamaker.getTournamentNames());
        listview.setAdapter(adapter);

    }


}

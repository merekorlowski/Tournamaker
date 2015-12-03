package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamEditList extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit_list);

        // Get ListView object from xml
        final ListView listview = (ListView) findViewById(R.id.listViewEdit);

        //the data to laod
        String[] teams = {"alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotle", "india", "juliette", "kilo"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < teams.length; ++i) {
            list.add(teams[i]);
        }

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        final ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);


    }

    public void createTeamClick(View view) {
        //on the user clicking a team in the list, launch the edit....

        Intent intent = new Intent(this, TeamEdit.class);
        startActivity(intent);
    }


}
package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class StatisticsActivity extends AppCompatActivity {

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        name = (String)i.getSerializableExtra("name");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        populateListView();
    }

    public void populateListView() {
        ArrayList<String> names = TournamentMaker.getInstance().getTournament(name).getTeamNames();
        Collections.sort(names);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, names);
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

}
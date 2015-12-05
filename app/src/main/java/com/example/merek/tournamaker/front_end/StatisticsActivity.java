package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Tournament;

import java.util.ArrayList;
import java.util.Collections;

public class StatisticsActivity extends AppCompatActivity {

    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        populateListView();
    }

    public void populateListView() {
        ArrayList<String> names = tournament.getTeamNames();
        Collections.sort(names);
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, names);
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

}
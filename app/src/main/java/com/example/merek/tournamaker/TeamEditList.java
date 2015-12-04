package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class TeamEditList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit_list);
        populateListView();
        registerClickCallback();
    }

    public void populateListView() {

        //the data to load
        /*String[] teams = {"alpha", "bravo", "charlie", "delta", "echo", "foxtrot", "golf", "hotle", "india", "juliette", "kilo"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < teams.length; ++i) {
            list.add(teams[i]);
        }*/

        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, TournamentMaker.getInstance().getTeamNames());
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewEdit);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TeamEdit.class);
                intent.putExtra("position", position);
                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }

}
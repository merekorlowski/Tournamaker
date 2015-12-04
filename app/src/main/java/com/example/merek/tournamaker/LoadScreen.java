package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class LoadScreen extends AppCompatActivity {

    ListView listView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        populateListView();
        registerClickCallback();
    }

    public void populateListView() {

        //the data to laod
        /*String[] teams = {"Game1", "game 2", "mygame", "otherPerson Game", "some game"};
        final ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < teams.length; ++i) {
            list.add(teams[i]);
        }*/

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, TournamentMaker.getInstance().getTournamentNames());
        ListView listview = (ListView) findViewById(R.id.listViewLoad);
        listview.setAdapter(adapter);
    }
    //

    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewEdit);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TournamentSetup.class);
                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }


}

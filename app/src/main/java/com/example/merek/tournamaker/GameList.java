package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class GameList extends AppCompatActivity {

    String name;
    int round;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        name = (String)i.getSerializableExtra("name");
        round = (int)i.getSerializableExtra("round");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_list);
        populateListView();
        registerClickCallback();
    }

    public void populateListView() {
        ArrayList<String> games = TournamentMaker.getInstance().getTournament(name).getRound(round).getGameList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, games);
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewEdit);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }

}

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

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);

        populateListView();
        registerClickCallback();
    }

    //populate tournament list view
    public void populateListView() {

        ArrayList<String> tournamentNames = TournamentMaker.getInstance().getTournamentNames();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, tournamentNames);
        ListView listview = (ListView) findViewById(R.id.listViewLoad);
        listview.setAdapter(adapter);

    }

    //load tournament when clicked
    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewLoad);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {

                if(TournamentMaker.getInstance().getTournament(position).isActive() == true) {



                } else {

                    Intent intent = new Intent(getApplicationContext(), StatisticsActivity.class);
                    intent.putExtra("id", String.valueOf(id));
                    startActivity(intent);

                }
            }
        });

    }

}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ResultsActivity extends AppCompatActivity {

    Tournament tournament;
    int roundNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        roundNumber = (int)i.getSerializableExtra("roundNumber");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        populateListView();
    }

    public void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, tournament.getRound(roundNumber - 1).getGameTextList());
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

    public void gotToNextRoundClick() {
        Intent intent = new Intent(this, RoundActivity.class);
        intent.putExtra("roundNumber", roundNumber++);
        startActivity(intent);
    }

}

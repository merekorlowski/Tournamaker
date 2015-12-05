package com.example.merek.tournamaker.front_end;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Team;
import com.example.merek.tournamaker.back_end.Tournament;
import com.example.merek.tournamaker.back_end.TournamentMaker;

import java.util.ArrayList;



public class CreateTournament extends Activity {

    String type;
    String name;
    Tournament tournament;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        type = (String)i.getSerializableExtra("type");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        // Background Thread
        /*new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.createTournamentBackgroundLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();*/

    }


    public void createTournamentClick(View view) {

        EditText inputTxt = (EditText) findViewById(R.id.editTextTournament);

        // Store EditText in Variable
        name = inputTxt.getText().toString();
        tournament = new Tournament(type, name, false, new ArrayList<Team>());

        //update list of tournaments
        TournamentMaker.getInstance().addTournament(tournament);
        ListView listView = (ListView) findViewById(R.id.listViewLoad);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);

    }

}

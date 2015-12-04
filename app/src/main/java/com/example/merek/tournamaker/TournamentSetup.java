package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TournamentSetup extends AppCompatActivity {

    public String name;

    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        name = (String)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup);
    }


    public void selectTeamsClick(View view) {
        Intent intent = new Intent(this, SelectTeams.class); //Application Context and Activity
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void teamManagerClick (View view) {
        Intent intent = new Intent(this, TeamManager.class); //Application Context and Activity
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void startClick (View view) {
        Intent intent = new Intent(this, RoundActivity.class); //Application Context and Activity
        intent.putExtra("name", name);
        startActivity(intent);
    }

    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

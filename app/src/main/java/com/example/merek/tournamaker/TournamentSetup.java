package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TournamentSetup extends AppCompatActivity {

    //declare variable
    Tournament tournament;

    protected void onCreate(Bundle savedInstanceState) {
        //retrieve objects from intent
        Intent i = getIntent();
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup);

        new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.tournamentSetupLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();
    }

    //select teams to add to tournament
    public void selectTeamsClick(View view) {
        Intent intent = new Intent(this, SelectTeams.class);
        //send this tournament to intent
        intent.putExtra("Tournament", tournament);
        startActivity(intent);
    }

    //go to team manager menu
    public void teamManagerClick (View view) {
        Intent intent = new Intent(this, TeamManager.class);
        //send this tournament to intent
        intent.putExtra("Tournament", tournament);
        startActivity(intent);
    }

    //start first round of tournament
    public void startClick (View view) {
        Intent intent = new Intent(this, RoundActivity.class);
        //send this tournament and set round number to 0
        intent.putExtra("Tournament", tournament);
        intent.putExtra("roundNumber", 0);
        startActivity(intent);
    }

    //temporary
    public void goHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

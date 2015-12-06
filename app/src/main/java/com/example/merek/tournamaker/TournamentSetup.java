package com.example.merek.tournamaker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class TournamentSetup extends AppCompatActivity {

    //declare variable
    Tournament tournament;
    Round round;

    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize tournament from intent
        tournament = (Tournament)i.getSerializableExtra("Tournament");

        if(tournament.isActive())
            round = (Round) i.getSerializableExtra("round");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup);

        /*new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.tournamentSetupLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();*/

    }

    //select teams to add to tournament
    public void selectTeamsClick(View view) {

        if(tournament.isActive()) {

            Context context = getApplicationContext();
            CharSequence text = "Can't select teams if tournament is active.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {

            Intent intent = new Intent(this, SelectTeams.class);

            //send this tournament to intent
            intent.putExtra("Tournament", tournament);
            startActivity(intent);

        }

    }

    //go to team manager menu
    public void teamManagerClick(View view) {

        Intent intent = new Intent(this, TeamManager.class);
        startActivity(intent);

    }

    //start first round of tournament
    public void startClick(View view) {

        Intent intent;

        if(!tournament.isActive()) {

            if(tournament.getTeamList().size() < 3) {

                Context context = getApplicationContext();
                CharSequence text = "Requires at least 3 teams to start.";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

            } else {

                //set tournament to active
                tournament.setIsActive(true);

                intent = new Intent(this, RoundActivity.class);

                //send this tournament and set round number to 1
                intent.putExtra("Tournament", tournament);
                intent.putExtra("roundNumber", 1);
                intent.putExtra("gameNumber", 1);
                startActivity(intent);

            }

        } else {

            intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("round", round);
            startActivity(intent);

        }

    }

}

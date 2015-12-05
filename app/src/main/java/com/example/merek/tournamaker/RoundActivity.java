package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class RoundActivity extends AppCompatActivity {

    int roundNumber;
    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        roundNumber = (int)i.getSerializableExtra("roundNumber");
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);
        setRoundNumber();
    }

    public void setRoundNumber() {
        TextView textView = (TextView) findViewById(R.id.textViewRound);
        String roundText = (String)textView.getText();
        String ss[] = roundText.split(" ", 2);
        ss[1] = Integer.toString(roundNumber);
        textView.setText(ss[0] + " " + ss[1]);
    }

    public void startRoundClick(View v){

        //Open the result page
        Intent intent = new Intent(this, GameActivity.class);

        //track round by sending it as an extra
        intent.putExtra("roundNumber", roundNumber);
        intent.putExtra("gameNumber", 1);
        intent.putExtra("Tournament", tournament);

        startActivity(intent);
    }

    public void viewStatsClick(View v){

        //Open the stats page
        Intent intent = new Intent(this, StatisticsActivity.class);
        intent.putExtra("Tournament", tournament);
        startActivity(intent);
    }

}
package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RoundActivity extends AppCompatActivity {

    private int roundNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        //check if extra intent was passed, specifically roundIncrease
        /*if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("roundNumber")) {
            int round = getIntent().getExtras().getInt("roundNumber");
            roundNumber = round;
        }

        setRoundNumber();*/
    }


    /*private void setRoundNumber(){
        TextView tV= (TextView)findViewById(R.id.textView7);
        tV.setText("Round " + roundNumber);
    }*/

    public void startRoundClick(View v){

        //Open the result page
        Intent intent = new Intent(this, ResultsActivity.class);

        //track round by sending it as an extra
        //Intent roundIncrease = intent.putExtra("roundNumber", roundNumber);

        startActivity(intent);
    }

    public void viewStatsClick(View v){

        //Open the stats page
        Intent intent = new Intent(this, StatisticsActivity.class);
        startActivity(intent);
    }

}
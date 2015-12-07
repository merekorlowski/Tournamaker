package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    //declare variables
    Round round;
    int gameNumber;
    Game game;
    int teamOneGoals;
    int teamTwoGoals;
    NumberPicker teamOneNumberSelect;
    NumberPicker teamTwoNumberSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables
        round = (Round)i.getSerializableExtra("Round");
        gameNumber = (int)i.getSerializableExtra("gameNumber");
        game = round.getGame(gameNumber - 1);

        //change next round button to see results at last game

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if(gameNumber == round.getNumOfGames()) {

            Button nextGameBtn = (Button) findViewById(R.id.nextGameBtn);
            nextGameBtn.setText("See results");

        }

        setGameNumber();
        setTeamNames();
        setNumberPickers();

    }

    //set game number to current game
    public void setGameNumber() {

        TextView textView = (TextView) findViewById(R.id.gameNumberTextView);
        textView.setText("" + gameNumber);

    }

    //set team names to teams in this game
    public void setTeamNames() {

        TextView teamOneText = (TextView) findViewById(R.id.teamOneTextView);
        teamOneText.setText(game.getTeamOneName());

        TextView teamTwoText = (TextView) findViewById(R.id.teamTwoTextView);
        teamTwoText.setText(game.getTeamTwoName());

    }

    public void setNumberPickers() {

        teamOneNumberSelect = (NumberPicker) findViewById(R.id.teamOneScore);
        teamOneNumberSelect.setMinValue(0);
        teamOneNumberSelect.setMaxValue(50);
        teamOneNumberSelect.setWrapSelectorWheel(false);

        teamTwoNumberSelect = (NumberPicker) findViewById(R.id.teamTwoScore);
        teamTwoNumberSelect.setMinValue(0);
        teamTwoNumberSelect.setMaxValue(50);
        teamTwoNumberSelect.setWrapSelectorWheel(false);

    }

    //set team one score with number picker
    public void setTeamOneScore(View view) {

        teamOneGoals = teamOneNumberSelect.getValue();
        game.getTeamOne().setNumOfGoals(teamOneGoals);

    }

    //set team two score with number picker
    public void setTeamTwoScore(View view) {

        teamTwoGoals = teamTwoNumberSelect.getValue();
        game.getTeamTwo().setNumOfGoals(teamTwoGoals);

    }

    //called when next game or see results button is clicked
    public void nextGame(View view) {

        Intent intent;

        //continues round until until all games are played
        if(gameNumber < round.getNumOfGames()) {

            intent = new Intent(this, GameActivity.class);

            intent.putExtra("Round", round);
            intent.putExtra("gameNumber", gameNumber++);

        //goes to results page when round is over
        } else {

            intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Round", round);

        }

        startActivity(intent);

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, RoundActivity.class);
        intent.putExtra("gameNumber", gameNumber);
        startActivity(intent);

    }

}

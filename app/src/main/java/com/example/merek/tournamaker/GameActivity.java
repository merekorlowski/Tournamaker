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
    Tournament tournament;
    Round round;
    Game game;
    int currentGameIndex;
    Button nextGameBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        round = (Round)i.getSerializableExtra("Round");
        currentGameIndex = (int)i.getSerializableExtra("gameIndex");

        game = round.getGame(currentGameIndex);

        //change next round button to see results at last game

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if(currentGameIndex == round.getNumOfGames() - 1) {

            nextGameBtn = (Button) findViewById(R.id.nextGameBtn);
            nextGameBtn.setText("See results");

        }

        TextView textView = (TextView) findViewById(R.id.gameNumberTextView);
        textView.setText("" + (currentGameIndex + 1));

        TextView teamOneText = (TextView) findViewById(R.id.teamOneTextView);
        teamOneText.setText(game.getTeamOneName());

        TextView teamTwoText = (TextView) findViewById(R.id.teamTwoTextView);
        teamTwoText.setText(game.getTeamTwoName());

        NumberPicker teamOneNumberSelect = (NumberPicker) findViewById(R.id.teamOneScore);
        teamOneNumberSelect.setMinValue(0);
        teamOneNumberSelect.setMaxValue(50);
        teamOneNumberSelect.setWrapSelectorWheel(false);

        NumberPicker teamTwoNumberSelect = (NumberPicker) findViewById(R.id.teamTwoScore);
        teamTwoNumberSelect.setMinValue(0);
        teamTwoNumberSelect.setMaxValue(50);
        teamTwoNumberSelect.setWrapSelectorWheel(false);

        teamOneNumberSelect.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                game.getTeamOne().setNumOfGoals(newVal);
            }
        });

        teamTwoNumberSelect.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                game.getTeamTwo().setNumOfGoals(newVal);
            }
        });

        if(game.getWinner() == game.getTeamOne()) {

            game.getTeamOne().incrementNumGamesWon();
            game.getTeamTwo().incrementNumGamesLost();

        }

        if(game.getWinner() == game.getTeamTwo()) {

            game.getTeamOne().incrementNumGamesLost();
            game.getTeamTwo().incrementNumGamesWon();

        }

    }

    //called when next game or see results button is clicked
    public void nextGame(View view) {

        Intent intent;

        //continues round until until all games are played
        if(currentGameIndex < round.getNumOfGames() - 1) {

            intent = new Intent(this, GameActivity.class);

            intent.putExtra("Tournament", tournament);
            intent.putExtra("Round", round);
            intent.putExtra("gameIndex", currentGameIndex + 1);

        //goes to results page when round is over
        } else {

            intent = new Intent(this, ResultsActivity.class);
            intent.putExtra("Tournament", tournament);
            intent.putExtra("Round", round);

        }

        startActivity(intent);

    }

    /*@Override
    public void onBackPressed() {

        Intent intent = new Intent(this, RoundActivity.class);
        intent.putExtra("gameIndex", currentGameIndex);
        startActivity(intent);

    }*/

}

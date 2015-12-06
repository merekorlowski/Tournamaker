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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables
        round = (Round)i.getSerializableExtra("Round");
        gameNumber = (int)i.getSerializableExtra("gameNumber");
        game = round.getGame(gameNumber - 1);

        //change next round button to see results at last game
        if(gameNumber == round.getGames().length) {

            Button nextGameBtn = (Button) findViewById(R.id.nextGameBtn);
            nextGameBtn.setText("See results");

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setGameNumber();
        setTeamNames();
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

    //set team one score with number picker
    public void setTeamOneScore(View view) {

        NumberPicker num = (NumberPicker) findViewById(R.id.teamOneScore);
        teamOneGoals = num.getValue();
        game.getTeamTournamentStatsOne().setNumOfGoals(teamOneGoals);

    }

    //set team two score with number picker
    public void setTeamTwoScore(View view) {

        NumberPicker num = (NumberPicker) findViewById(R.id.teamTwoScore);
        teamTwoGoals = num.getValue();
        game.getTeamTournamentStatsTwo().setNumOfGoals(teamTwoGoals);

    }

    //called when next game or see results button is clicked
    public void nextGame(View view) {

        //continues round until until all games are played
        if(gameNumber < round.getGames().length) {

            Intent intent = new Intent(this, Game.class);

            intent.putExtra("Round", round);
            intent.putExtra("gameNumber", gameNumber++);

            startActivity(intent);

        //goes to results page when round is over
        } else {

            Intent intent2 = new Intent(this, ResultsActivity.class);
            intent2.putExtra("Round", round);

        }

    }

}

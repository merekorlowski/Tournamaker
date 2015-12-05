package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    Tournament tournament;
    int roundNumber;
    int gameNumber;
    String team1Name;
    int goals1;
    String team2Name;
    int goals2;
    String newButtonTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournament = (Tournament)i.getSerializableExtra("Tournament");
        roundNumber = (int)i.getSerializableExtra("roundNumber");
        gameNumber = (int)i.getSerializableExtra("gameNumber");
        if(gameNumber == tournament.getRound(roundNumber - 1).getGames().length) {
            Button nextGameBtn = (Button) findViewById(R.id.nextGame);
            nextGameBtn.setText("See results");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setGameNumber();
        setTeamNames();
    }

    public void setGameNumber() {
        TextView textView = (TextView) findViewById(R.id.gameTextView);
        String gameText = (String)textView.getText();
        String ss[] = gameText.split(" ", 2);
        ss[1] = Integer.toString(gameNumber);
        textView.setText(ss[0] + " " + ss[1]);
    }

    public void setTeamNames() {
        TextView team1 = (TextView) findViewById(R.id.team1text);
        team1.setText(tournament.getRound(roundNumber - 1).getGame(gameNumber - 1).getT1().getName());
        TextView team2 = (TextView) findViewById(R.id.team2text);
        team2.setText(tournament.getRound(roundNumber - 1).getGame(gameNumber - 1).getT2().getName());
    }

    public void setTeam1Score() {
        TextView team = (TextView) findViewById(R.id.team1text);
        team1Name = (String) team.getText();
        NumberPicker num = (NumberPicker) findViewById(R.id.numberPicker);
        goals1 = num.getValue();
        tournament.getTeam(team1Name).setNumOfGoals(goals1);
    }

    public void setTeam2Score() {
        TextView team = (TextView) findViewById(R.id.team2text);
        team2Name = (String) team.getText();
        NumberPicker num = (NumberPicker) findViewById(R.id.numberPicker3);
        goals2 = num.getValue();
        tournament.getTeam(team2Name).setNumOfGoals(goals2);
    }

    public void nextGame() {

        if(gameNumber < tournament.getRound(roundNumber - 1).getGames().length) {

            Intent intent = new Intent(this, Game.class);

            intent.putExtra("Tournament", tournament);
            intent.putExtra("roundNumber", roundNumber);
            intent.putExtra("gameNumber", gameNumber++);

            startActivity(intent);

        } else {
            Intent intent2 = new Intent(this, ResultsActivity.class);
            intent2.putExtra("Tournament", tournament);
            intent2.putExtra("roundNumber", roundNumber);
        }

    }

}

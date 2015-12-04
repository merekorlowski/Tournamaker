package com.example.merek.tournamaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {

    String name;
    String game;
    int round;
    int id;
    String team1Name;
    int goals1;
    String team2Name;
    int goals2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        name = (String)i.getSerializableExtra("name");
        game = (String)i.getSerializableExtra("game");
        round = (int)i.getSerializableExtra("round");
        id = (int)i.getSerializableExtra("id");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setTeamNames();
    }

    public void setTeamNames() {
        String split[] = game.split(" ", 3);
        TextView team1 = (TextView) findViewById(R.id.team1text);
        team1.setText(split[0]);
        TextView team2 = (TextView) findViewById(R.id.team2text);
        team2.setText(split[2]);
    }

    public void setTeam1Score() {
        TextView team = (TextView) findViewById(R.id.team1text);
        team1Name = (String) team.getText();
        NumberPicker num = (NumberPicker) findViewById(R.id.numberPicker);
        goals1 = num.getValue();
        TournamentMaker.getInstance().getTournament(name).getTeam(team1Name).setNumOfGoals(goals1);
    }

    public void setTeam2Score() {
        TextView team = (TextView) findViewById(R.id.team2text);
        team2Name = (String) team.getText();
        NumberPicker num = (NumberPicker) findViewById(R.id.numberPicker3);
        goals2 = num.getValue();
        TournamentMaker.getInstance().getTournament(name).getTeam(team2Name).setNumOfGoals(goals2);
    }

    public void goBack() {
        String result = team1Name + "-" + goals1 + " " + goals2 + "-" + team2Name;
        TournamentMaker.getInstance().getTournament(name).getRound(round).getGameList().set(id, result);
        Intent intent = new Intent(this, GameList.class);
        startActivity(intent);
    }


}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class TeamEdit extends AppCompatActivity {

    public int position;
    public String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        position = (int)i.getSerializableExtra("position");
        id = (String)i.getSerializableExtra("id");
        EditText team = (EditText) findViewById(R.id.editTextTeam);
        team.setText(id);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit);
    }


    public void editTeam(View view) {

        EditText inputTxt = (EditText) findViewById(R.id.editTextTeam);
        // Store EditText in Variable
        String name = inputTxt.getText().toString();

        TournamentMaker.getInstance().setTeamName(position, name);

        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);
    }

    public void deleteTeam(View view) {

        TournamentMaker.getInstance().deleteTeam(position);

        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);
    }


}

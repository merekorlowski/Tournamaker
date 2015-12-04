package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamManager extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);
    }


    public void createTeamClick(View view) {
        Intent intent = new Intent(this, TeamCreate.class);
        startActivity(intent);
    }

    public void editTeamClick (View view) {
        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);
    }
}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamCreate extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_create);
    }

    public void createTeam(View v){
        //add the team to the list of teams

        Intent intent = new Intent(this, TeamManager.class);
        startActivity(intent);
    }


}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit);
    }


    public void confirmChangesClick(View view) {

        Intent intent = new Intent(this, TeamCreate.class);
        startActivity(intent);
    }

    public void deleteTeamClick(View view) {

        Intent intent = new Intent(this, TeamCreate.class);
        startActivity(intent);
    }


}

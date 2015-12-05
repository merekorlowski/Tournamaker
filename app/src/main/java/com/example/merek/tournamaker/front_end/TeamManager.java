package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Tournament;

public class TeamManager extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

    }

    //called when create team button is clicked
    public void createTeamClick(View view) {

        //goes to team create activity
        Intent intent = new Intent(this, TeamCreate.class);
        startActivity(intent);

    }

    //called when edit team button is clicked
    public void editTeamClick (View view) {

        //go to team edit list activity
        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);

    }
}

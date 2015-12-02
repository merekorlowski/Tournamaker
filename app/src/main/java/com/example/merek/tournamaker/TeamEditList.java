package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamEditList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit_list);
    }

    public void createTeamClick(View view) {
        //on the user clicking a team in the list, launch the edit....

        Intent intent = new Intent(this, TeamEdit.class);
        startActivity(intent);
    }


}
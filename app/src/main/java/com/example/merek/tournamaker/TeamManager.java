package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamManager extends AppCompatActivity {

    private TournamentMaker tournamaker;

    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        tournamaker = (TournamentMaker)i.getSerializableExtra("Tournamaker");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);
    }


    public void createTeamClick(View view) {
        Intent intent = new Intent(this, TeamCreate.class);
        intent.putExtra("Tournamaker", tournamaker);
        startActivity(intent);
    }

    public void editTeamClick (View view) {
        Intent intent = new Intent(this, TeamEditList.class);
        intent.putExtra("Tournamaker", tournamaker);
        startActivity(intent);
    }
}

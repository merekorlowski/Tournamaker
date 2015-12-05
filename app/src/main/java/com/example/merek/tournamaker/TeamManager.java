package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

public class TeamManager extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

        new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.teamManagerLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();
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

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TeamManager extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

        /*new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.teamManagerLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();*/

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

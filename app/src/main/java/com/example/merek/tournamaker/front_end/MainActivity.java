package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import com.example.merek.tournamaker.R;

public class MainActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //show the home menu
            setContentView(com.example.merek.tournamaker.R.layout.activity_main);

            //Background Image Thread
            new Thread(new Runnable() {
                public void run() {
                    RelativeLayout layout =(RelativeLayout)findViewById(R.id.backgroundRelativeLayout);
                    layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
                }
            }).start();

//            TournamakerDatabaseHelper databaseHelper = TournamakerDatabaseHelper.getInstance(this);
//
//            Team team = new Team("Real Madrid");
//            databaseHelper.addTeam(team,"aia.png",null,true);
//
//            List<Team> teams = databaseHelper.getAllTeams();
//            for (Team oneteam : teams) {
//
//                Log.d("MainActivity", oneteam.getName());
//                //Log.d("MainActivity", databaseHelper.getIconName(team.getName()));
//            }
        }
        //go to select type menu
        public void goToCreateTournament(View v){
            final Intent intent = new Intent(this, SelectTypeActivity.class);
            startActivity(intent);
        }
        //go to load tournament menu
        public void goToLoadTournament(View v) {
            final Intent intent = new Intent(this, LoadScreen.class);
            startActivity(intent);
        }
        //go to team manager menu
        public void goToManageTeams(View v) {
            final Intent intent = new Intent(this, TeamManager.class);
            startActivity(intent);
        }
}

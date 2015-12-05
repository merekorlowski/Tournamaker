package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //show the home menu
            setContentView(com.example.merek.tournamaker.R.layout.activity_main);
        }
        //go to select type menu
        public void goToCreateTournament(View v){
            Intent intent = new Intent(this, SelectTypeActivity.class);
            startActivity(intent);
        }
        //go to load tournament menu
        public void goToLoadTournament(View v) {
            Intent intent = new Intent(this, LoadScreen.class);
            startActivity(intent);
        }
        //go to team manager menu
        public void goToManageTeams(View v) {
            Intent intent = new Intent(this, TeamManager.class);
            startActivity(intent);
        }
}

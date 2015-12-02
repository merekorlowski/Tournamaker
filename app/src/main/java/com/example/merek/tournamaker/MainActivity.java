package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(com.example.merek.tournamaker.R.layout.activity_main);
            TournamentMaker tournamaker = TournamentMaker.getInstance();
        }

        public void startHere(View v){

            //Open the stats page
            Intent intent = new Intent(this, SelectTypeActivity.class);
            startActivity(intent);
        }

        public void goToLoadTournament(View v) {
          Intent intent = new Intent(this, LoadScreen.class);
            startActivity(intent);
        }

        public void goToManageTeams(View v) {
            Intent intent = new Intent(this, TeamManager.class);
            startActivity(intent);
        }
}

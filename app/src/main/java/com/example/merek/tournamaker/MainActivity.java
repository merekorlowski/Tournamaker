package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TournamentMaker tournamaker;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //show the home menu
            setContentView(com.example.merek.tournamaker.R.layout.activity_main);
            tournamaker = TournamentMaker.getInstance();
        }

        public void goToCreatTournament(View v){
            Intent intent = new Intent(this, SelectTypeActivity.class);
            intent.putExtra("Tournamaker", tournamaker);
            startActivity(intent);
        }

        public void goToLoadTournament(View v) {
            Intent intent = new Intent(this, LoadScreen.class);
            intent.putExtra("Tournamaker", tournamaker);
            startActivity(intent);
        }

        public void goToManageTeams(View v) {
            Intent intent = new Intent(this, TeamManager.class);
            intent.putExtra("Tournamaker", tournamaker);
            startActivity(intent);
        }
}

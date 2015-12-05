package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

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

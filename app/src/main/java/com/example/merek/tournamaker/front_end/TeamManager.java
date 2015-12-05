package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.Tournament;

public class TeamManager extends AppCompatActivity {

    //for the drawer
    private ListView mDrawerList;
    private ArrayAdapter<String> mAdapter;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

        /*new Thread(new Runnable() {
            public void run() {
                LinearLayout layout =(LinearLayout)findViewById(R.id.teamManagerLinearLayout);
                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
            }
        }).start();*/


        //setup for drawer
        mDrawerList = (ListView)findViewById(R.id.navList);
        addDrawerItems();

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

    //the drawer
    private void addDrawerItems() {
        String[] osArray = { "Back to Home", "Back to Tournament", "Load Tournament"};
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        mDrawerList.setAdapter(mAdapter);
    }

}

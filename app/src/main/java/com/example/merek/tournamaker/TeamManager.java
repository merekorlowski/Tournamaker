package com.example.merek.tournamaker;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.merek.tournamaker.R;

import java.util.ArrayList;

public class TeamManager extends AppCompatActivity {

    //for the drawer
    private ListView drawerList;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private String activityTitle;
    private Intent home;
    private Intent tournamentSetup;
    //private Intent tournamentSetup = new Intent(this, MainActivity.class);


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

//       new Thread(new Runnable() {
//            public void run() {
//                LinearLayout layout =(LinearLayout)findViewById(R.id.teamManagerLinearLayout);
//                layout.setBackgroundResource(R.drawable.adidas_soccer_ball);
//            }
//        }).start();

        populateListView();
        registerClickCallback();

        /*
        ---for the Drawer---
         */
        //drawer layout title
        drawerList = (ListView)findViewById(R.id.navList);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        activityTitle = getTitle().toString();

        //setup for drawer list
        addDrawerItems();
        setupDrawer();
        home = new Intent(this, MainActivity.class);
        tournamentSetup = new Intent(this, TournamentSetup.class);

        //button to get to drawer
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    //called when create team button is clicked
    public void createTeamClick(View view) {

        //goes to team create activity
        Intent intent = new Intent(this, TeamCreate.class);
        startActivity(intent);

    }

    //populates list view with team names
    public void populateListView() {

//        ArrayList<String> teamNames = TournamentMaker.getInstance().getTeamNames();
//
//        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, teamNames);
//        ListView listview = (ListView) findViewById(R.id.teamListView);
//        listview.setAdapter(adapter);

        String[] itemname ={
                "Safari",
                "Camera",
                "Global",
                "FireFox",
                "UC Browser",
                "Android Folder",
                "VLC Player",
                "Cold War"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            this, R.layout.team_list,
            R.id.Itemname,itemname);
            ListView listview = (ListView) findViewById(R.id.teamListView);
            listview.setAdapter(adapter);
    }

    //edit selected team
    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.teamListView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TeamEdit.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void exitTeamManagerOnClick(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


    /*
    -----The Drawer-----
     */

    private void addDrawerItems() {
        String[] osArray = { "Home", "Tournament Setup"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        drawerList.setAdapter(adapter);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemName = ((TextView)view).getText().toString();

                if (itemName == "Home") {
                    //Toast.makeText(getBaseContext(), "Working", Toast.LENGTH_LONG).show();
                    startActivity(home);
                }

                if (itemName == "Tournament Setup") {
                    //Toast.makeText(getBaseContext(), "Working", Toast.LENGTH_LONG).show();
                    startActivity(tournamentSetup);
                }
            }
        });
    }


    private void setupDrawer() {
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.drawer_open, R.string.drawer_close) {

             //Called when a drawer has settled in a completely open state
             public void onDrawerOpened(View drawerView) {
                 super.onDrawerOpened(drawerView);
                 getSupportActionBar().setTitle("Navigate");
                 invalidateOptionsMenu();
            }

            //Called when a drawer has settled in a completely closed state.
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                getSupportActionBar().setTitle(activityTitle);
                invalidateOptionsMenu();
            }
        };

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerLayout.setDrawerListener(drawerToggle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        // Activate the navigation drawer toggle
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

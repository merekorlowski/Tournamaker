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
import android.widget.Toast;

import com.example.merek.tournamaker.R;

import java.util.List;

public class TeamManager extends AppCompatActivity {

    //for the drawer
    private ListView drawerList;
    private ArrayAdapter<String> adapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private String activityTitle;
    private Intent home;
    private Intent tournamentSetup;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_manager);

        populateListView();
        registerClickCallback();
        setDrawer();

    }

    public void setDrawer() {

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
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    //populates list view with team names
    public void populateListView() {

        List<String> teamNames = TournamentMaker.getInstance().getTeams(this);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.select_dialog_item, teamNames);
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

    /*
    -----The Drawer-----
     */

    private void addDrawerItems() {
        String[] osArray = { "Home", "Back to Tournament"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, osArray);
        drawerList.setAdapter(adapter);

        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemName = ((TextView)view).getText().toString();

                if (itemName == "Home") {
                    startActivity(home);
                }

                if (itemName == "Back to Tournament") {

                    try {
                        tournamentSetup.setFlags(tournamentSetup.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(tournamentSetup);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Problem", Toast.LENGTH_SHORT).show();
                    }
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

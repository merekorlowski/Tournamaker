package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.TournamentMaker;

public class TeamEdit extends AppCompatActivity {

    //declare variables
    int position;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent i = getIntent();

        //initialize variables from intent
        position = (int)i.getSerializableExtra("position");
        id = (String)i.getSerializableExtra("id");

        EditText team = (EditText) findViewById(R.id.editTextTeam);
        team.setText(id);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit);

    }


    public void editTeam(View view) {

        EditText inputTxt = (EditText) findViewById(R.id.editTextTeam);

        // Store input in Variable
        String name = inputTxt.getText().toString();

        //edit team name in list
        TournamentMaker.getInstance().setTeamName(position, name);

        //update the list
        ListView listView = (ListView) findViewById(R.id.listViewEdit);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);
    }

    public void deleteTeam(View view) {

        //delete team from list
        TournamentMaker.getInstance().deleteTeam(position);

        //update the list
        ListView listView = (ListView) findViewById(R.id.listViewEdit);
        ArrayAdapter adapter = (ArrayAdapter)listView.getAdapter();
        adapter.notifyDataSetChanged();

        Intent intent = new Intent(this, TeamEditList.class);
        startActivity(intent);
    }


}

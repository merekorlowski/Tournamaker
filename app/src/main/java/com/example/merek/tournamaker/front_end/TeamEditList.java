package com.example.merek.tournamaker.front_end;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.merek.tournamaker.R;
import com.example.merek.tournamaker.back_end.TournamentMaker;

public class TeamEditList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_edit_list);
        populateListView();
        registerClickCallback();
    }

    public void populateListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, TournamentMaker.getInstance().getTeamNames());
        ListView listview = (ListView) findViewById(R.id.listViewEdit);
        listview.setAdapter(adapter);
    }

    public void registerClickCallback() {

        ListView list = (ListView) findViewById(R.id.listViewEdit);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), TeamEdit.class);
                intent.putExtra("position", position);
                intent.putExtra("id", String.valueOf(id));
                startActivity(intent);
            }
        });
    }

}
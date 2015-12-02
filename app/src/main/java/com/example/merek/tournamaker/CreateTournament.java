package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import android.view.Menu;
//import android.view.MenuItem;

public class CreateTournament extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tournament);
    }


    public void createClick(View view) {
        //create an instance of tournament, according to type

        Intent intent = new Intent(this, edit.class);
        startActivity(intent);

    }

}

package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.app.Dialog;
import android.widget.Button;
import android.widget.EditText;

public class SelectTypeActivity extends AppCompatActivity {

    /*Dialog selectTypeDialog;
    String theText;*/

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
    }

    public void roundRobin(View view){

        Button btnTxt = (Button) findViewById(R.id.roundRobinBtn);
        String type = btnTxt.getText().toString();

        Intent intent = new Intent(this, CreateTournament.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void knockout(View view){
        //something happens, or get's passed to the next activity
        Button btnTxt = (Button) findViewById(R.id.knockoutBtn);
        String type = btnTxt.getText().toString();

        Intent intent = new Intent(this, CreateTournament.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    public void roundRobinKnockout(View view){
        //something happens, or get's passed to the next activity
        Button btnTxt = (Button) findViewById(R.id.roundRobinKnockoutBtn);
        String type = btnTxt.getText().toString();

        Intent intent = new Intent(this, CreateTournament.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }
}




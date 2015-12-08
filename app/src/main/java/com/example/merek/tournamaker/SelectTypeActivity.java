package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

public class SelectTypeActivity extends AppCompatActivity {

    //declare variables
    private Button btnTxt;
    private String type;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
    }

    public void typeBtn(View view){

        //initialize variables
        switch(view.getId())
        {
            case R.id.roundRobinBtn:
                btnTxt = (Button) findViewById(R.id.roundRobinBtn);
                break;

            case R.id.knockoutBtn:
                btnTxt = (Button) findViewById(R.id.knockoutBtn);
                break;

            case R.id.roundRobinKnockoutBtn:
                btnTxt = (Button) findViewById(R.id.roundRobinKnockoutBtn);
                break;
        }

        type = btnTxt.getText().toString();

        //create round-robin tournament
        Intent intent = new Intent(this, CreateTournament.class);
        intent.putExtra("type", type); //pass the tournament type to the next activity
        startActivity(intent);
    }

}




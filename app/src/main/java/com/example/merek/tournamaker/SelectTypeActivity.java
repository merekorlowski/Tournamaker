package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.app.Dialog;
import android.widget.EditText;

public class SelectTypeActivity extends AppCompatActivity {

    /*Dialog selectTypeDialog;
    String theText;*/




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_type);
    }


    //reguardless of type selected, the next screen is the same
    private Intent creatTournamentIntent(){
       Intent intent = new Intent(this, CreateTournament.class);
        return intent;
    }


    public void roundRobin(View view){
        //something happens, or get's passed to the next activity

        startActivity(creatTournamentIntent());
    }

    public void knockout(View view){
        //something happens, or get's passed to the next activity

        startActivity(creatTournamentIntent());
    }

    public void roundRobinKnockout(View view){
        //something happens, or get's passed to the next activity

        startActivity(creatTournamentIntent());
    }




/*

    public void tournamentTypeDialog(View v) {
        selectTypeDialog = new Dialog(SelectTypeActivity.this);
        selectTypeDialog.setTitle("Create a Tournament");
        selectTypeDialog.setContentView(com.example.merek.tournamaker.R.layout.activity_select_type_popup);
        selectTypeDialog.show();
        EditText et = (EditText) findViewById(R.id.tournamentNameEditText);
        theText = et.getText().toString();
    }

    public void cancel(View view) {
        selectTypeDialog.dismiss();
    }

    public void goToTournamentSetup(View v) {

        //Open tournament setup
        Intent intent = new Intent(this, TournamentSetup.class);
        intent.putExtra("text_label", theText);
        startActivity(intent);
    }*/
}




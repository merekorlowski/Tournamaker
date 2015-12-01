package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class TournamentSetup extends AppCompatActivity {

    String s;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_setup);
        Intent i = getIntent();
        s = i.getStringExtra("text_label");
        t = (TextView) findViewById(R.id.textView5); ;
        t.setText(s);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tournament_setup, menu);
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

        return super.onOptionsItemSelected(item);
    }*/

    public void selectTeamsClick(View view) {
        Intent intent = new Intent(this, SelectTeams2.class); //Application Context and Activity
        startActivity(intent);
    }

    public void teamManagerClick (View view) {
        Intent intent = new Intent(this, TeamManager.class); //Application Context and Activity
        startActivity(intent);
    }

    public void startClick (View view) {
        Intent intent = new Intent(this, RoundActivity.class); //Application Context and Activity
        startActivity(intent);
    }
}

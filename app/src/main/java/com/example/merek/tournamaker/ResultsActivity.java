package com.example.merek.tournamaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    int r = 1;
    int num = 1;
    TextView tView;
    Button clickhere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //check if extra intent was passed, specifically roundNumber
        if (this.getIntent().getExtras() != null && this.getIntent().getExtras().containsKey("roundNumber")) {
            int round = getIntent().getExtras().getInt("roundNumber");
            r = round;
        }
    }

    public void gotToNextRoundClick(View v) {

       /* tView = (TextView) findViewById(R.id.textView7);
        clickhere = (Button) findViewById(id.buttonContinue);

        clickhere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tView.setText("Round " + num);
            }
        });*/
        Intent intent = new Intent(this, RoundActivity.class);
        startActivity(intent);
    }


}
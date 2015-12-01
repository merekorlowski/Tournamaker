package com.example.merek.tournamaker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class EditTeam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);
    }
    /*public void goToTeam(View view) {
        Intent intent = new Intent(this, edit.class);
        startActivity(intent);
    }*/

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_team, menu);
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
    }



    <ScrollView
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="vertical" >



    <TextView
    android:id="@+id/tv_long"
    android:layout_width="wrap_content"
    android:layout_height="match_parent"
    android:text="@string/really_long_string" >
    </TextView>

    int numTeams = 5;
    Button [] = new Button[numTeams];//
    for (int i=0;i<oNumber;i++){
        btn[i] = new Button(this); // initialize it
        btn[i].setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));
        btn[i].setText(oName[i]);
        System.out.println("Team" + i);
        layout.addView(btn[i]);
    }

    <Button
    android:id="@+id/btn_act"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="View" >
    </Button>
    </LinearLayout>
    </ScrollView>*/
}

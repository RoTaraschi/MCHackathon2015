package com.dashmarked.gamifyyourlyf;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;


import com.dashmarked.gamifyyourlyf.model.Morning;


public class Leaderboard extends ActionBarActivity implements View.OnClickListener {

    Button nextActivityButton;

    TextView firstPlace;
    TextView secondPlace;
    TextView thirdPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_leaderboard);


        Morning first = null;
        Morning second = null;
        Morning third = null;
        if(Morning.getAllMornings() != null) {
            for (Morning morning : Morning.getAllMornings()) {
                if(first == null || morning.calculateTime() < first.calculateTime()){
                    first = morning;
                }
                else if(second == null || morning.calculateTime() < second.calculateTime()){
                    second = morning;
                }
                else if(third == null || morning.calculateTime() < third.calculateTime()){
                    third = morning;
                }
            }
        }

        firstPlace = (TextView)findViewById(R.id.textView8);
        secondPlace = (TextView)findViewById(R.id.textView9);
        thirdPlace = (TextView)findViewById(R.id.textView10);

        if(first != null){
            firstPlace.setText("date:" +first.getDate().getDate() + " score: " + first.calculateTime()/60000 + ":" +((first.calculateTime()%60000)/1000));
        }
        else{
            firstPlace.setText("");
        }
        if(second != null){
            secondPlace.setText("date:" +second.getDate().getDate() + " score: " + second.calculateTime()/60000 + ":" + ((second.calculateTime()%60000)/1000));
        }
        else{
            secondPlace.setText("");
        }
        if(third != null){
            thirdPlace.setText("date:" +third.getDate().getDate() + " score: " + third.calculateTime()/60000 + ":" + ((third.calculateTime()%60000)/1000));
        }
        else{
            thirdPlace.setText("");
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_leaderboard, menu);
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

    @Override
    public void onClick(View v) {
    }
}

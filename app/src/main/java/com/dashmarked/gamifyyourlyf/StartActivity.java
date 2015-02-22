package com.dashmarked.gamifyyourlyf;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.dashmarked.gamifyyourlyf.model.Routine;
import com.dashmarked.gamifyyourlyf.model.Task;
import com.dashmarked.gamifyyourlyf.model.Time;
import com.dashmarked.gamifyyourlyf.model.Morning;


import java.util.ArrayList;
import java.util.Date;


public class StartActivity extends ActionBarActivity implements View.OnClickListener {


    Chronometer chrono;
    Button startButton;
    Button stopButton;
    TextView activityName;
    ArrayList<Task> tasks = null;
    Date startStamp;
    Morning today = Morning.addMorning();
    int count = 0;

    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);

        tasks = Routine.getCurrentRoutine().getRoutineTasks();

        chrono = (Chronometer) findViewById(R.id.chronometer);

        startStamp = new Date();

        activityName = (TextView)findViewById(R.id.textView7);
        activityName.setText(tasks.get(count++).getName());

        startButton = (Button)findViewById(R.id.button11);
        startButton.setOnClickListener(this);

        stopButton = (Button)findViewById(R.id.button12);
        stopButton.setOnClickListener(this);
        stopButton.setText("Next Task!");

        chrono.setBase(SystemClock.elapsedRealtime());
        chrono.start();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
        return true;
    }

    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.button11:

                String ButtonText = startButton.getText().toString();
                if(ButtonText.equals("PAUSE")) {

                    //save time when stopped
                    timeWhenStopped = chrono.getBase() - SystemClock.elapsedRealtime();
                    chrono.stop();

                    //back to resume button
                    startButton.setText("RESUME");

                    chrono.stop();
                }
                else if (ButtonText.equals("RESUME")) {

                    //switch to pause
                    startButton.setText("PAUSE");

                    //resume from the time when last stopped
                    chrono.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    chrono.start();


                }


                break;

            case R.id.button12:
                today.addTime(tasks.get(count - 1), startStamp, new Date());
                startStamp = new Date();
                if(count < tasks.size())
                    activityName.setText(tasks.get(count++).getName());
                else{
                    Intent intent = new Intent(this, Leaderboard.class);
                    startActivity(intent);
                }
                break;

        }

    }
}

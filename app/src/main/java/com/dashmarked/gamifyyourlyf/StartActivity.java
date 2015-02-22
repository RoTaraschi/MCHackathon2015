package com.dashmarked.gamifyyourlyf;

import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;


public class StartActivity extends ActionBarActivity implements View.OnClickListener {

    Chronometer chrono;
    Button startButton;
    Button stopButton;

    long timeWhenStopped = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        chrono = (Chronometer) findViewById(R.id.chronometer);

        startButton = (Button) findViewById(R.id.button11);
        startButton.setOnClickListener(this);

        stopButton = (Button)findViewById(R.id.button12);
        stopButton.setOnClickListener(this);

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
                if(ButtonText.equals("START/PAUSE")) {

                    chrono.setBase(SystemClock.elapsedRealtime());
                    chrono.start();

                    //switch to pause when first clicked
                    startButton.setText("PAUSE");
                }
                else if(ButtonText.equals("RESUME")) {

                    //switch to pause
                    startButton.setText("PAUSE");

                    //resume from the time when last stopped
                    chrono.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);
                    chrono.start();

                } else {

                    //save time when stopped
                    timeWhenStopped = chrono.getBase() - SystemClock.elapsedRealtime();
                    chrono.stop();

                    //back to resume button
                    startButton.setText("RESUME");

                    chrono.stop();
                }


                break;

            case R.id.button12:

                chrono.stop();
                break;

        }

    }
}

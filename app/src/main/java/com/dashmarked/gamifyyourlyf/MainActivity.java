package com.dashmarked.gamifyyourlyf;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    Button startButton;
    Button leaderboardButton;
    Button addTaskButton;
    ImageButton twitterButton;
    ImageButton fbButton;
    ImageButton gpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.button);
        startButton.setOnClickListener(this);

        leaderboardButton = (Button) findViewById(R.id.button2);
        leaderboardButton.setOnClickListener(this);

        addTaskButton = (Button) findViewById(R.id.button3);
        addTaskButton.setOnClickListener(this);

        twitterButton = (ImageButton)findViewById(R.id.btnTW);
        twitterButton.setOnClickListener(imgButtonHandler);

        fbButton = (ImageButton)findViewById(R.id.btnFB);
        fbButton.setOnClickListener(imgButtonHandler);

        gpButton = (ImageButton)findViewById(R.id.btnGP);
        gpButton.setOnClickListener(imgButtonHandler);

    }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            twitterButton.setBackgroundResource(R.drawable.tw1);
            fbButton.setBackgroundResource(R.drawable.fb1);
            gpButton.setBackgroundResource(R.drawable.gp1);



        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


        switch(v.getId()){

            case R.id.button :
                Intent intent1 = new Intent(this, Tasks.class);
                startActivity(intent1);
                break;

            case R.id.button2 :
                Intent intent2 = new Intent(this, Leaderboard.class);
                startActivity(intent2);
                break;

            case R.id.button3 :
                Intent intent3 = new Intent(this, AddTask.class);
                startActivity(intent3);
                break;

        }
    }
}

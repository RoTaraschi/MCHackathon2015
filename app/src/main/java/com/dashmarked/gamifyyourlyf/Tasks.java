package com.dashmarked.gamifyyourlyf;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.dashmarked.gamifyyourlyf.model.Routine;
import com.dashmarked.gamifyyourlyf.model.Task;

import java.util.ArrayList;


public class Tasks extends ActionBarActivity implements View.OnClickListener {

    LinearLayout dbLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        Button startTask = (Button) findViewById(R.id.btnGO);
        startTask.setOnClickListener(this);



        dbLayout = (LinearLayout) findViewById(R.id.scrlLinearLayout_Task_Acts);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        for (int i = 0; i < Task.getAllTasks().size(); i++) {
            LinearLayout dbLinearLayout = new LinearLayout(this);
            dbLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            final CheckBox cbx= new CheckBox(this);
            cbx.setId(i);
            cbx.setText(Task.getAllTasks().get(i).getName());
            cbx.setLayoutParams(params);



            dbLinearLayout.addView(cbx);

            dbLayout.addView(dbLinearLayout);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tasks, menu);
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

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnGO :

                ArrayList<Task> addRoutine = new ArrayList<Task>();

                for(int i=0; i<Task.getAllTasks().size(); i++) {


                    CheckBox checkBox = (CheckBox) findViewById(i);
                    if (checkBox.isChecked()) {

                        addRoutine.add(   Task.getAllTasks().get(i)  );

                    }

                   Routine.setCurrentRoutine(Routine.addRoutine(addRoutine));

                }
                Intent addTaskIntent = new Intent(this, StartActivity.class);
                startActivity(addTaskIntent);
                break;
        }
    }
}

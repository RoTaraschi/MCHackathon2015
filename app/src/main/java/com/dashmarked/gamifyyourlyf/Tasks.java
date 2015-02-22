package com.dashmarked.gamifyyourlyf;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dashmarked.gamifyyourlyf.model.Task;

import java.util.ArrayList;


public class Tasks extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        final LinearLayout dbLayout = (LinearLayout) findViewById(R.id.scrlLinearLayout_Task_Acts);


        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        ArrayList<Task> ActivityTask = Task.getAllTasks();

        //Create four
        for (int i = 0; i < ActivityTask.size(); i++) {
            LinearLayout dbLinearLayout = new LinearLayout(this);
            dbLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

            final Button btn = new Button(this);
            btn.setId(i);
            btn.setText(ActivityTask.get(i).getName());
            btn.setLayoutParams(params);


            //btn.setOnClickListener(new OnClickListener() {
            // public void onClick(View v) {

            //Intent newIntent = new Intent(this, StartActivity.class);
            //startActivity(newIntent);


            //}


            //Add button to LinearLayout
            dbLinearLayout.addView(btn);
            //Add button to LinearLayout defined in XML
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

            case R.id.button7:
                Intent addTaskIntent = new Intent(this, StartActivity.class);
                startActivity(addTaskIntent);
                break;


        }
    }
}

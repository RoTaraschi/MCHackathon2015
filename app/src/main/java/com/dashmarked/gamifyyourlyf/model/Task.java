package com.dashmarked.gamifyyourlyf.model;

import java.util.ArrayList;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Task {
    private static int numTask = 0;
    private int id;
    private String name;
    private static ArrayList<Task> tasks = null;
    //TODO: implement this properly
    private Task(){
        numTask++;
        id = numTask;
    }
    //TODO: implement this properly
    public int getId(){
        return id;
    }
    //TODO: implement this properly
    public String getName(){
        return "ExampleTask"+getId();
    }
    //TODO: implement this properly
    public void setName(String name) { this.name = name; }
    //TODO: implement this properly
    public static ArrayList<Task> getAllTasks(){
        if (tasks == null) {
            tasks = new ArrayList<Task>();
            for(int i = 0; i < 10; i++){
                tasks.add(new Task());
            }
        }
        return tasks;
    }
    //TODO: implement
    public Task getTask(int id){
        return null;
    }
    //TODO: implement this properly
    public static Task addTask(String name) {
        Task task = new Task();
        task.setName(name);
        tasks.add(task);
        return task;
    }

}

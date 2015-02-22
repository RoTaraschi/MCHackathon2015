package com.dashmarked.gamifyyourlyf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import java.util.ArrayList;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Task implements Serializable{
    private static final long serialVersionUID = 9113402515928091850L;
    private static ArrayList<Task> tasks = null;
    private int id;
    private String name;
    private Task(){
        id = getAllTasks().size();
    }
    private Task(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static ArrayList<Task> getAllTasks(){
        //if tasks are not initialized
        if (tasks == null) {
            try{
                //get input from file
                File file = new File("tasks.dogening");
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                tasks = (ArrayList<Task>) input.readObject();
            }
            catch(Exception e){
                System.out.println("SOMETHING WENT WRONG OMG.");
            }
            //if file didn't exist or was null, initialize the values
            if(tasks == null) {
                tasks = new ArrayList<Task>();
                for (int i = 0; i < 10; i++) {
                    tasks.add(new Task());
                }
                tasks.get(0).setName("wake up");
                tasks.get(1).setName("brush teeth");
                tasks.get(2).setName("shower");
                tasks.get(3).setName("eat breakfast");
                tasks.get(4).setName("walk dog");
                tasks.get(5).setName("walk and chew bubble gum");
                tasks.get(6).setName("use the force");
                tasks.get(7).setName("pick your nose");
                tasks.get(8).setName("jog");
                tasks.get(9).setName("let them eat cake");
            }
        }
        return tasks;
    }
    public static Task getTask(int id){
        ArrayList<Task> tasklist = getAllTasks();
        if(tasklist != null) {
            for (Task task : tasklist) {
                if (task.id == id) {
                    return task;
                }
            }
        }
        return null;
    }
    public static Task addTask(String name) {
        ArrayList<Task> tasklist = getAllTasks();
        Task task = new Task();
        task.setName(name);
        tasklist.add(task);
        return task;
    }
    public static void SerializeTasks(){
        try{
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/tasks.dogening");
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(tasks);
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("DID A BAD THING AND STUFF");
        }
    }

}

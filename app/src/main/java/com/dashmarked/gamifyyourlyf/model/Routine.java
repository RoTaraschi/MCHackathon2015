package com.dashmarked.gamifyyourlyf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;
/**
 * Created by geoffrey on 2/21/15.
 */
public class Routine implements Serializable {
    private static final long serialVersionUID = 9112652515928091850L;

    private static Routine currentRoutine = null;
    private static ArrayList<Routine> routines = null;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private int id;

    public Routine(ArrayList tasks) {
        if(routines != null) {
            this.id = routines.size();
        }
        else{
            routines = new ArrayList<Routine>();
            this.id = 0;
        }
        this.tasks = tasks;
    }
    public int getId() {
        return id;
    }
    public ArrayList<Task> getRoutineTasks() {
        return tasks;
    }
    public static Routine getCurrentRoutine() {
        if(currentRoutine == null){
            currentRoutine = getAllRoutines().get(0);
        }
        return currentRoutine;
    }
    public static void setCurrentRoutine(Routine routine) {
        currentRoutine = routine;
    }

    public static ArrayList<Routine> getAllRoutines(){
        if(routines == null){
            DeSerializeRoutines();
            if(routines == null){
                ArrayList<Task> tasks = Task.getAllTasks();
                Routine routine = new Routine(tasks);
                routines = new ArrayList<Routine>();
                routines.add(routine);
                setCurrentRoutine(routine);
            }
        }
        return routines;
    }
    public static Routine addRoutine(ArrayList<Task> tasks) {
        Routine routine = new Routine(tasks);
        routines.add(routine);
        SerializeRoutines();
        return routine;
    }
    public static Routine getRoutine(int id) {
        for (Routine routine : getAllRoutines()) {
            if (routine.id == id) {
                return routine;
            }
        }
        return null;
    }

    public static void DeSerializeRoutines(){
        try {
            //get input from file
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/routines.dogening");
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            routines = (ArrayList<Routine>) input.readObject();
        }
        catch(Exception e){

        }
    }

    public static void SerializeRoutines() {
        try {
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/routines.dogening");
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(getAllRoutines());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DID A BAD THING AND STUFF");
        }
    }
}

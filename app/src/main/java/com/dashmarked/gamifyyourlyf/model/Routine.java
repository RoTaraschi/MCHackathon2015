package com.dashmarked.gamifyyourlyf.model;

import java.util.ArrayList;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Routine {
    private static int numRoutines;
    private static Routine currentRoutine= null;
    private static ArrayList<Routine> routines = null;
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private int id;

    public Routine(ArrayList tasks){
        numRoutines++;
        this.id = numRoutines;
        this.tasks = tasks;
    }
    public int getId(){
        return id;
    }
    //todo: implement
    public ArrayList<Task> getRoutineTasks(){
        return tasks;
    }
    //TODO: implement
    public static Routine getCurrentRoutine(){
        return currentRoutine;
    }
    //TODO: implement
    public void setCurrentRoutine(Routine routine){
        currentRoutine = routine;
    }
    //TODO: implement
    public static Routine addRoutine(ArrayList<Task> tasks){
        Routine routine = new Routine(tasks);
        routines.add(routine);
        return routine;

    }
    //TODO: implement
    public static Routine getRoutine(int id){
        for(Routine routine : routines){
            if(routine.id == id){
                return routine;
            }
        }
        return null;
    }
}

package com.dashmarked.gamifyyourlyf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Time implements Serializable{
    private static ArrayList<Time> times = null;
    private Task task;
    private Date start;
    private Date end;
    private int id;

    //TODO: implement
    private Time(Task task, Date start, Date end){
        id = getAllTimes().size();
        this.task = task;
        this.start = start;
        this.end = end;
    }
    public static ArrayList<Time> getAllTimes(){
        if (times == null) {
            DeSerializeTimes();
            if(times == null){
                times = new ArrayList<Time>();
            }
        }
        return times;
    }
    public int getId(){
        return id;
    }
    public Date getStart(){
        return start;
    }
    public Date getEnd(){
        return end;
    }
    public Task getTask(){
        return task;
    }
    public static Time addTime(Task task, Date start, Date end){
        Time time = new Time(task, start, end);
        getAllTimes().add(time);
        SerializeTimes();
        return time;
    }
    public static Time getTime(int id){
        for(Time time: getAllTimes()){
            if(time.getId() == id){
                return time;
            }
        }
        return null;
    }

    public static void DeSerializeTimes(){
        try {
            //get input from file
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/times.dogening");
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
            times = (ArrayList<Time>) input.readObject();
        } catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG OMG.");
        }
    }
    public static void SerializeTimes(){
        try{
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/times.dogening");
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(getAllTimes());
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("DID A BAD THING AND STUFF");
        }
    }
}

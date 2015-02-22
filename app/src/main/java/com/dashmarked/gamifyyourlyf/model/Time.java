package com.dashmarked.gamifyyourlyf.model;

import java.util.Date;
import java.util.ArrayList;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Time {
    private static int numTimes = 0;
    private Task task;
    private Date start;
    private Date end;
    private int id;
    private static ArrayList<Time> times = null;

    //TODO: implement
    private Time(Task task, Date start, Date end){
        numTimes++;
        id = numTimes;
        this.task = task;
        this.start = start;
        this.end = end;
    }
    //TODO: implement
    public int getId(){
        return id;
    }
    //TODO: implement
    public Date getStart(){
        return start;
    }
    //TODO: implement
    public Date getEnd(){
        return end;
    }
    //TODO: implement
    public Task getTask(){
        return task;
    }
    //TODO: implement
    public static Time addTime(Task task, Date start, Date end){
        Time time = new Time(task, start, end);
        times.add(time);
        return time;
    }
    //TODO: implement
    public static Time getTime(int id){
        for(Time time: times){
            if(time.getId() == id){
                return time;
            }
        }
        return null;
    }
}

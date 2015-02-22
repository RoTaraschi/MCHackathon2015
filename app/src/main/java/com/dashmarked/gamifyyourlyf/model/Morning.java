package com.dashmarked.gamifyyourlyf.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Morning {
    private static int numMornings;
    private static ArrayList<Morning> mornings = new ArrayList<Morning>();
    private ArrayList<Time> times = new ArrayList<Time>();
    private int id;
    //TODO: implement
    private Morning(){
        numMornings++;
        id = numMornings;
    }
    //TODO: implement
    public static Morning addMorning(){
        Morning morning = new Morning();
        mornings.add(morning);
        return morning;
    }
    //TODO: implement
    public static Morning getMorning(int id){
        for(Morning morning : mornings){
            if (morning.id == id){
                return morning;
            }
        }
        return null;
    }
    //TODO: implement
    public void addTime(Task task, Date start, Date end){
        Time time = Time.addTime(task, start, end);
        this.times.add(time);
    }
    public ArrayList<Time> getTimes(){
        return times;
    }
}

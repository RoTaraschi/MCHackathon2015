package com.dashmarked.gamifyyourlyf.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by geoffrey on 2/21/15.
 */
public class Morning {
    private static ArrayList<Morning> mornings = null;
    private ArrayList<Time> times = new ArrayList<Time>();
    private Date date;
    private int id;
    //TODO: implement
    private Morning(){
        date = new Date();
        id = getAllMornings().size();
    }
    //TODO: implement
    public static Morning addMorning(){
        Morning morning = new Morning();
        getAllMornings().add(morning);
        return morning;
    }
    //TODO: implement
    public static Morning getMorning(int id){
        for(Morning morning : getAllMornings()){
            if (morning.id == id){
                return morning;
            }
        }
        return null;
    }
    public static ArrayList<Morning> getAllMornings(){
        if(mornings == null){
            try {
                //get input from file
                File file = new File("mornings.dogening");
                ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
                mornings = (ArrayList<Morning>) input.readObject();
            }
            catch(Exception e){

            }
            if(mornings == null){
                mornings = new ArrayList<Morning>();
            }
        }
        return mornings;
    }
    //TODO: implement
    public void addTime(Task task, Date start, Date end){
        Time time = Time.addTime(task, start, end);
        this.times.add(time);
    }
    public ArrayList<Time> getTimes(){
        return times;
    }

    public static void SerializeMornings() {
        try {
            File file = new File(android.os.Environment.getExternalStorageDirectory(),"doge/mornings.dogening");
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(getAllMornings());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DID A BAD THING AND STUFF");
        }
    }

    public long calculateTime(){
        long sum = 0;
        for(Time time : times){
            sum+= (time.getEnd().getTime()-time.getStart().getTime());
        }
        return sum;
    }

    public Date getDate(){
        return date;
    }

}

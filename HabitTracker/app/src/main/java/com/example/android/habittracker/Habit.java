package com.example.android.habittracker;

/**
 * Created by yagro on 7/3/2016.
 */
public class Habit {
    private int habitID;
    private String habitName;
    private int habitFrequency;

    public Habit(){
        //default constructor
    }

    /**
     * contructor with 2 arguements
     * @param name
     * @param frequency
     */
    public Habit(String name, int frequency){
        habitName = name;
        habitFrequency = frequency;
    }

    //getters & setters
    public int getHabitID(){
        return habitID;
    }

    public String getHabitName(){
        return habitName;
    }

    public int getHabitFrequency(){
        return habitFrequency;
    }

    public void setHabitID(int id){
        habitID = id;
    }

    public void setHabitName(String name){
        habitName = name;
    }

    public void setHabitFrequency(int frequency){
        habitFrequency = frequency;
    }


}

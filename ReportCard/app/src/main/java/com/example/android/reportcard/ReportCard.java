package com.example.android.reportcard;

/**
 * Created by yagro on 6/30/2016.
 */
public class ReportCard {
    private int mStudentID;
    private int mClassID;
    private double mGrade;
    private char mLetterGrade;
    //default constructor
    public ReportCard(int sID){
        mStudentID = sID;
    }
    //method to set class with grade
    public void setClassWithGrade(int classID, double grade, char letterGrade){
        mClassID = classID;
        mGrade = grade;
        mLetterGrade = letterGrade;
    }
    //getter for studentID
    public int getStudentID(){
        return mStudentID;
    }
    //getter for classID
    public int getClassID(){
        return  mClassID;
    }
    //getter for Grade
    public double getGrade(){
        return mGrade;
    }
    //getter for LetterGrade
    public char getLetterGrade(){
        return mLetterGrade;
    }
    //getter for report card
    public String getReportCard(){
        return ("Student ID: "+mStudentID+"\nClass ID: "+mClassID+"\nGrade: "+mGrade+"\nLetter Grade: "+mLetterGrade);
    }

}

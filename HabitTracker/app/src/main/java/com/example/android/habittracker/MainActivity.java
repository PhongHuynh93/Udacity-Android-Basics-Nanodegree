package com.example.android.habittracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("test", "Creating db");

        habitDBOpenHelper habitDB = new habitDBOpenHelper(this);

        Log.v("Query ", dbContract.Table.CREATE_TABLE);

        habitDB.addHabit(new Habit("Internet", 8));
        habitDB.addHabit(new Habit("Coffee", 4));

        Cursor c = habitDB.readHabit(2);
        Habit h1 = new Habit((c.getString(1)),c.getInt(2));
        Log.v("test: ",h1.getHabitName()+"\n"+h1.getHabitFrequency());
    }
}

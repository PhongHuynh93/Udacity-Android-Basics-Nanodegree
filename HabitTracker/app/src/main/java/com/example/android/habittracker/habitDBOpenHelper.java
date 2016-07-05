package com.example.android.habittracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class habitDBOpenHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "HabitTracker";
    Context context;

    public habitDBOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(dbContract.Table.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        context.deleteDatabase(DATABASE_NAME);
        onCreate(db);
    }

    // Add
    void addHabit(Habit newHabit) {
        //Create a Database Connection and insert row into database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbContract.Table.NAME, newHabit.getHabitName());
        values.put(dbContract.Table.FREQUENCY, newHabit.getHabitFrequency());
        db.insert(dbContract.Table.TABLE_NAME, null, values);
        db.close(); // Close database connection
    }

    public Cursor readHabit(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                dbContract.Table.TABLE_NAME,
                new String[]{dbContract.Table.KEY_ID,
                        dbContract.Table.NAME,
                        dbContract.Table.FREQUENCY},
                dbContract.Table.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        return cursor;
    }

    // Update single entry
    public void updateHabitRow(double rowId, String newContent, String newContent1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(dbContract.Table.NAME, newContent);
        values.put(dbContract.Table.FREQUENCY, newContent1);
        db.update(dbContract.Table.TABLE_NAME, values, dbContract.Table.KEY_ID + "=" + rowId, null);
    }

    // Delete single entry
    public void deleteHabitTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + dbContract.Table.TABLE_NAME);
    }
}
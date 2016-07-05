package com.example.android.habittracker;

import android.provider.BaseColumns;

public final class dbContract {
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private dbContract() {
        //default constructor
    }

    public static abstract class Table implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "habits";
        // Table Columns names
        public static final String KEY_ID = "id";
        public static final String NAME = "name";
        public static final String FREQUENCY = "frequency";

        public static final String CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        KEY_ID + " INTEGER PRIMARY KEY UNIQUE ," +
                NAME + TEXT_TYPE + COMMA_SEP +
                FREQUENCY + " INTEGER" + " )";

        public static final String DELETE_TABLE = "DROP TABLE " + TABLE_NAME;
    }
}

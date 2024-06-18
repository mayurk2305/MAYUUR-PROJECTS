package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "StarRatings.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_RATINGS = "Ratings";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_RATING = "rating";

    // SQL statement to create the Ratings table
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_RATINGS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_RATING + " REAL);";
    private String recordId;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RATINGS);
        onCreate(db);
    }

    public boolean updateRating(float newRating, int recordId) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_RATING, newRating);

            String condition = COLUMN_ID + " = " + recordId;

            int updatedRows = db.update(TABLE_RATINGS, values, condition, null);
            db.close();

            return updatedRows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRating(float rating) {
        return false;
    }
}






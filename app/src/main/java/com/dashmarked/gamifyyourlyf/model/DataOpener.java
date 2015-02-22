package com.dashmarked.gamifyyourlyf.model;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
import android.database.SQLException;
/**
 * Created by geoffrey on 2/21/15.
 */
class DataOpener extends SQLiteOpenHelper {
    private static SQLiteDatabase database = null;
    private static SQLiteOpenHelper dbHelper = null;

    private static final String DATABASE_NAME = "data.db";
    private static final String DATABASE_CREATE =
            "CREATE TABLE task(id INT PRIMARY KEY, name VARCHAR(250));"+
            "CREATE TABLE routine(id INT PRIMARY KEY, curr int);"+
            "CREATE TABLE routine_task(routine_id INT, task_id INT, order_num INT, PRIMARY KEY(routine_id, task_id));"+
            "CREATE TABLE morning(id INT PRIMARY KEY, day DATE);"+
            "CREATE TABLE time(id INT PRIMARY KEY, task_id INT, start date, end date);"+
            "CREATE TABLE morning_time(morning_id, time_id, PRIMARY KEY(morning_id, time_id));";
    private static final String DATABASE_DROP =
            "DROP TABLE IF EXISTS task;"+
            "DROP TABLE IF EXISTS routine;"+
            "DROP TABLE IF EXISTS routine_task;"+
            "DROP TABLE IF EXISTS morning;"+
            "DROP TABLE IF EXISTS time;"+
            "DROP TABLE IF EXISTS morning_time;";

    private static final int DATABASE_VERSION = 1;

    public DataOpener (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL(DATABASE_DROP);
        onCreate(database);
    }
    public static SQLiteDatabase open() throws SQLException {
        return dbHelper.getWritableDatabase();
    }
}

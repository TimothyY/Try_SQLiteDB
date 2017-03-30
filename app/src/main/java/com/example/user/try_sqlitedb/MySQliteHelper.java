package com.example.user.try_sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 3/30/2017.
 */

public class MySQliteHelper  extends SQLiteOpenHelper{

    public static final String name = "myDB";
    public static final SQLiteDatabase.CursorFactory factory = null;
    public static final int version = 1;

    public static String TABLE_MS_USER = "MsUser";
    public static String FIELD_MS_USER_USERNAME = "username";
    public static String FIELD_MS_USER_PASSWORD = "password";

    public MySQliteHelper(Context context) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qCreateMSuser="CREATE TABLE IF NOT EXISTS '"+TABLE_MS_USER+"' (\n"+
                "'"+FIELD_MS_USER_USERNAME+"' TEXT, \n"+
                "'"+FIELD_MS_USER_PASSWORD+"' TEXT, \n"+
                " PRIMARY KEY("+FIELD_MS_USER_USERNAME+"));";
        db.execSQL(qCreateMSuser);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

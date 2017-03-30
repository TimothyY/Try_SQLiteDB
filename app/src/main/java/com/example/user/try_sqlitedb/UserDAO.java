package com.example.user.try_sqlitedb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by User on 3/30/2017.
 */

public class UserDAO {

    public void addUser(Context ctx, String username, String password){

        MySQliteHelper mySQliteHelper = new MySQliteHelper(ctx);
        SQLiteDatabase db = mySQliteHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(MySQliteHelper.FIELD_MS_USER_USERNAME,username);
        cv.put(MySQliteHelper.FIELD_MS_USER_PASSWORD,password);

        db.insertWithOnConflict(
                MySQliteHelper.TABLE_MS_USER,
                null,
                cv, SQLiteDatabase.CONFLICT_REPLACE);

        db.close();
    }

    public String getUsername(Context ctx, String username, String password){

        MySQliteHelper mySQliteHelper = new MySQliteHelper(ctx);
        SQLiteDatabase db = mySQliteHelper.getReadableDatabase();

        String selectionString = "username=? AND password=?";
        String []selectionArgs = {username,password};

        Cursor resultCursor = db.query(MySQliteHelper.TABLE_MS_USER,null,
                selectionString,selectionArgs,null,null,null);

        String resultUsername = null;
        if(resultCursor.moveToFirst()){
            resultUsername = resultCursor.getString(0);
        }

        return resultUsername;
    }

    public ArrayList<String> getUsernames(Context ctx){

        MySQliteHelper mySQliteHelper = new MySQliteHelper(ctx);
        SQLiteDatabase db = mySQliteHelper.getReadableDatabase();

        String selectionString = null;
        String []selectionArgs = null;

        Cursor resultCursor = db.query(MySQliteHelper.TABLE_MS_USER,null,
                selectionString,selectionArgs,null,null,null);

        ArrayList<String> resultUsernames = new ArrayList<>();
        while(resultCursor.moveToNext()){
            resultUsernames.add(resultCursor.getString(0));
        }

        return resultUsernames;
    }
}

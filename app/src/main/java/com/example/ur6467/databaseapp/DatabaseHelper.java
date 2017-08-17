package com.example.ur6467.databaseapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ur6467 on 7/26/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{


    private static final String DATABASE_NAME = "Contacts.db";
    private static final String TABLE_NAME = "contact";
    private static final String STR = "FIX";

    //public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);

        SQLiteDatabase obj = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,MOBILE_NUMBER INTEGER,EMAIL TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(String name, long mobile_no, String Email)
    {
        Log.i(STR, "In insert");
        SQLiteDatabase obj = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("MOBILE_NUMBER", mobile_no);
        contentValues.put("EMAIL", Email);
        long res = obj.insert(TABLE_NAME, null, contentValues);
        // long result = insert;
        Log.i(STR, String.valueOf(res));
        obj.close();
        if (res == -1) {
            Log.i(STR, "Fail insert");
            return false;
        } else {
            Log.i(STR, "Pass insert");
            return true;
        }
    }

    public Cursor getData(String name) {
        SQLiteDatabase db = this.getWritableDatabase();

        System.out.println("In DB");
        //Get data from table
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE NAME = '" + name + "'";

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }
    public void deleteData(String name)
    {

        SQLiteDatabase db = this.getWritableDatabase();

        //delete data from table
        db.delete(TABLE_NAME, "NAME = '"+name+"'",null);

        //      db.close();
    }

    public void updateData( String name, String number, String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("NAME",name);

        contentValues.put("EMAIL",email);
System.out.println("Calling Update");
        //updating values in database
        db.update(TABLE_NAME, contentValues, "MOBILE_NUMBER = '" + number+"'",null );
        //db.close();
//        db.update(TABLE_NAME, contentValues, "NAME LIKE '%name%'",null );
        //  Toast.makeText(,"Record updated",Toast.LENGTH_LONG);
        // Toast.makeText(DatabaseHelper.this,"record saved",Toast.LENGTH_LONG).show();
//        db.close();
    }





}

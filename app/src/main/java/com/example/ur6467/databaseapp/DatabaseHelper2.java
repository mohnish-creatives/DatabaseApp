package com.example.ur6467.databaseapp;


            import android.content.ContentValues;
            import android.content.Context;
            import android.database.Cursor;
            import android.database.sqlite.SQLiteDatabase;
            import android.database.sqlite.SQLiteDatabaseLockedException;
            import android.database.sqlite.SQLiteOpenHelper;
            import android.widget.Toast;

            import java.util.ArrayList;

    /**
     * Created by Nihal on 1/24/2017.
     */

    public class DatabaseHelper2 extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "MyPlate.db";
        public static final String CARS_TABLE_NAME = "CarNumber";
        public static final String CARS_COLUMN_ID = "id";
        public static final String CARS_COLUMN_NAME = "c_number";
        public static final String CARS_COLUMN_COLOR = "c_Color";
        public static final String CARS_COLUMN_PLACE = "c_Place";

        public DatabaseHelper2(Context context) {
            super(context, DATABASE_NAME, null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table  " +           CARS_TABLE_NAME+
                    "(_id integer primary key AUTOINCREMENT NOT NULL,"+  CARS_COLUMN_NAME+
                    " Text,"+                    CARS_COLUMN_COLOR+
                    " Text,"+                    CARS_COLUMN_PLACE+
                    " Text)"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS "+ DATABASE_NAME);
            onCreate(db);
        }

        public boolean insertPlate(int number, String color, String place) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("c_number", number);
            contentValues.put("c_Color", color);
            contentValues.put("c_Place", place);

            db.insert(CARS_TABLE_NAME, null, contentValues);
            db.close();
            return true;
        }

        public Cursor findData(String ID) {
            SQLiteDatabase db = this.getWritableDatabase();
            System.out.println("InSearch");

            //Get data from table
            String query = "SELECT * FROM " + CARS_TABLE_NAME + " WHERE c_number = '" + ID + "'";

            Cursor cursor = db.rawQuery(query, null);

            return cursor;
        }


        public ArrayList<Cars> getData() {
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<Cars> car= new ArrayList<Cars>();
            Cursor result = db.rawQuery("select * from "+CARS_TABLE_NAME , null);
            while(result.moveToNext()){
                car.add( new Cars(result.getString(result.getColumnIndex(CARS_COLUMN_COLOR)), result.getString(result.getColumnIndex(CARS_COLUMN_NAME)),result.getString(result.getColumnIndex(CARS_COLUMN_PLACE))));

            }
            return car;
        }

        public void deleteData(String name)
        {

            SQLiteDatabase db = this.getWritableDatabase();

            //delete data from table
            db.delete(CARS_TABLE_NAME, "c_number = '"+name+"'",null);

                 db.close();
        }


/*
        public void deleteData(String name)
        {

            SQLiteDatabase db = this.getWritableDatabase();

            //delete data from table
            db.delete(CARS_TABLE_NAME, "NAME = '"+name+"'",null);

                  db.close();
        }
*/

        public void updateData(String name, String color, String place) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("c_color", color);
            contentValues.put("c_place", place);
            System.out.println("Calling Update");
            //updating values in database
            db.update(CARS_TABLE_NAME, contentValues, "c_number = '" + name+"'",null );

           // db.update(CARS_TABLE_NAME, contentValues, "id = ? ", new String[]{name});
           // int record= db.update(CARS_TABLE_NAME, contentValues, "id = ? ", new String[]{name});
            // = db.update(CARS_TABLE_NAME, contentValues, "c_number = '" + name + "'", null);
            db.close();
           // return  true;
            //db.close();
//        db.update(TABLE_NAME, contentValues, "NAME LIKE '%name%'",null );
            //  Toast.makeText(,"Record updated",Toast.LENGTH_LONG);
            // Toast.makeText(DatabaseHelper.this,"record saved",Toast.LENGTH_LONG).show();
//        db.close();
        }


        public boolean updatePlates(int id, int number, int color, int place) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("c_number", number);
            contentValues.put("c_Color", color);
            contentValues.put("c_Place", place);

            db.update(CARS_TABLE_NAME, contentValues, "id = ? ", new String[]{Integer.toString(id)});
            return true;
        }

        public Integer deletePlates(Integer id) {
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(CARS_TABLE_NAME,
                    "id = ? ",
                    new String[]{Integer.toString(id)});
        }

        public void insertSomeCars() {

            insertPlate(1,"Blue","Honda Civic");
            insertPlate(2,"Brown","Rolls Royce");
            insertPlate(3,"Blue","Honda Civic");
            insertPlate(4,"Black","Nissan Patrol <3");
            insertPlate(5,"Yellow","Tiida");
            insertPlate(6,"Grey","Rolls Royce");

        }

    }
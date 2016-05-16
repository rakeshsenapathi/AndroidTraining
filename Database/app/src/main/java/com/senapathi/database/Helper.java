package com.senapathi.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Senapathi on 12-05-2016.
 */
public class Helper extends SQLiteOpenHelper {

    List<Employ> mRecords = new ArrayList<>();
    public static class EmployTable {

        public static final String TABLE_NAME = "Employ";
        public static final String DATABASE_NAME = "Employ.db";
        public static final int VERSION = 1;
        public static final String ID = "_id";
        public static final String NAME = "_name";
        public static final String CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " ( " + ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT,  " + NAME
                + "  TEXT NOT NULL ); ";


    }

    public Helper(Context context) {

        super(context, EmployTable.DATABASE_NAME, null, 1);

    }

//    public void addrecords(List<Employ> list){
//
//        mRecords = new ArrayList<>(list);
//        notify();
//
//    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EmployTable.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//
    }

    //create
    public long insertData(String id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(EmployTable.ID, id);
        c.put(EmployTable.NAME, name);


        long rowId = db.insert(EmployTable.TABLE_NAME, null, c);

        return rowId;


    }

    //update
    public long updateData(String id, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put(EmployTable.NAME, name);
        long count = db.update(EmployTable.TABLE_NAME, c, "_id=?", new String[]{id});
        return count;


    }


//    //display
//    public long displayData(){
//
//     SQLiteDatabase db = getReadableDatabase();
//        db.query(EmployTable.TABLE_NAME,null,null,null,null,null,null);
//
//
//    }


    //delete
    public long deleteData(String id) {
        SQLiteDatabase db = getWritableDatabase();
        long count = db.delete(EmployTable.TABLE_NAME, "_id=?", new String[]{id});
        return count;


    }


    //read
    public List<Employ> populateRecords() {
        // id,name
        List<Employ> employList = new ArrayList<>();
        SQLiteDatabase db = getWritableDatabase();

        //TODO: Populate values from database table
        Cursor cursor = db.rawQuery("select * from " + EmployTable.TABLE_NAME, null);
        //
        if (cursor.moveToFirst()) {
            do {
                //
                int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("_name"));
                //
                Employ employ = new Employ();
                employ.setId(id);
                employ.setName(name);
                employList.add(employ);
            } while (cursor.moveToNext());
        }

        return employList;


    }

    public class Employ {
        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


}

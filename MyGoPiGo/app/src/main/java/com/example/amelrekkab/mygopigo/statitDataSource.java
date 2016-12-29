package com.example.amelrekkab.mygopigo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import org.w3c.dom.Comment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.id;

/**
 * Created by Amel Rekkab on 27/12/2016.
 */

public class statitDataSource {

    // Champs de la base de données
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;
    private String[] allColumns = { MySQLiteHelper.COLUMN_ID,
            MySQLiteHelper.COLUMN_Temperature, MySQLiteHelper.COLUMN_Lumunisite, MySQLiteHelper.COLUMN_Distance };

    public statitDataSource(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public statit createDistance(String distance) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_Distance, distance);
        long insertId = database.insert(MySQLiteHelper.TABLE_statit, null,
                values);
        Cursor cursor = database.query(MySQLiteHelper.TABLE_statit,
                allColumns, MySQLiteHelper.COLUMN_ID + " = " + insertId, null,
                null, null, null);
        cursor.moveToFirst();
        statit newDistance= (statit) cursorToComment(cursor);
        cursor.close();
        return newDistance;
    }

    public void deleteDistance(statit distance) {
       // long id = statit.getId();
        System.out.println("distance deleted with id: " + id);
        database.delete(MySQLiteHelper.TABLE_statit, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<statit> getAllstatit() {
        List<statit> statit = new ArrayList<statit>();

        Cursor cursor = database.query(MySQLiteHelper.TABLE_statit,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Comment comment = cursorToComment(cursor);
            //statit.add(comment);
            cursor.moveToNext();
        }
        // assurez-vous de la fermeture du curseur
        cursor.close();
        return statit;
    }

    private Comment cursorToComment(Cursor cursor) {
        Comment comment = (Comment) new statit();
        //comment.setId(cursor.getLong(0));
       // comment.setComment(cursor.getString(1));
        return comment;
    }
}

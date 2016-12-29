package com.example.amelrekkab.mygopigo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Amel Rekkab on 27/12/2016.
 */

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String TABLE_statit = "gopigo";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_Temperature = "Température";
    public static final String COLUMN_Lumunisite = "Luminisite";
    public static final String COLUMN_Distance = "Distance";

    private static final String DATABASE_NAME = "gopigo.db";
    private static final int DATABASE_VERSION = 1;

    // Commande sql pour la création de la base de données
    private static final String DATABASE_CREATE = "create table "
            + TABLE_statit + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_Temperature
            + " integer primary key autoincrement, " + COLUMN_Lumunisite
            + " integer primary key autoincrement, " + COLUMN_Distance
            + " text not null);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_statit);
        onCreate(db);
    }
}

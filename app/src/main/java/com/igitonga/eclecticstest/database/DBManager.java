package com.igitonga.eclecticstest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBManager extends SQLiteOpenHelper {

    public static final String USER_TABLE = "USER";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public DBManager(@Nullable Context context) {
        super(context, "user.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String TABLE_NAME = "CREATE TABLE " + USER_TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME + " VARCHAR(50), " + PASSWORD + " VARCHAR(255))";

        sqLiteDatabase.execSQL(TABLE_NAME);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addUser(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(USERNAME, userModel.getUsername());
        contentValues.put(PASSWORD, userModel.getPassword());

        long insert = db.insert(USER_TABLE, null, contentValues);
        if (insert == 1){
            return true;
        }
        else {
            return false;
        }
    }
}

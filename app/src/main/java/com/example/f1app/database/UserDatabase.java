package com.example.f1app.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.f1app.model.room.User;

@Database(entities = User.class, version = 1,exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    private static UserDatabase instance;

    public abstract UserDao contactDao();

    public static UserDatabase getInstance(Context context){
        if (instance == null){
            String DB_NAME = "db_user";
            instance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}

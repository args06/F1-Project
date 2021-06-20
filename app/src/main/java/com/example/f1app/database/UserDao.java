package com.example.f1app.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.f1app.model.room.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAllData();

    @Insert
    void insertData(User contact);

    @Update
    void updateData(User contact);

    @Delete
    void deleteData(User contact);
}

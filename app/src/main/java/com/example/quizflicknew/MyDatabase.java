package com.example.quizflicknew;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserTable.class},version = 1)
public abstract class MyDatabase extends RoomDatabase {

public abstract UserDao getDao();
}

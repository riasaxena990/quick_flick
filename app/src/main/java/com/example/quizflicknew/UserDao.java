package com.example.quizflicknew;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {
    @Insert
    void insertUser(UserTable userTable);

    @Query("SELECT EXISTS (SELECT * FROM UserTable WHERE userName=:userName)")
    boolean is_taken(String userName);

    @Query("SELECT EXISTS (SELECT * FROM UserTable WHERE userName=:userName AND password=:password)")
    boolean login(String userName,String password);
}

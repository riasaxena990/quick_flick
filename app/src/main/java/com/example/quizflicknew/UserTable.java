package com.example.quizflicknew;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserTable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName;
    private String password;

    public UserTable(int id, String userName, String password) {
        this.password = password;
        this.id = id;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

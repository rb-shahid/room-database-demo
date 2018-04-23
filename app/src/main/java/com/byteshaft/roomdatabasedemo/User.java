package com.byteshaft.roomdatabasedemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class User {

    public User(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo (name = "user_id")
    private int id;

    @ColumnInfo (name = "first_name")
    private String firstName;
    @ColumnInfo (name = "last_name")
    private String lastName;
    @ColumnInfo (name = "email_address")
    private String emailId;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }
}

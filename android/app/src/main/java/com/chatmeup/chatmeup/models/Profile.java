package com.chatmeup.chatmeup.models;
import java.util.Date;


public class Profile {
    private String fName;
    private String lName;
    private String username;
    private String sex;
    private Date dob;
    private String hobby;
    private String department;
    private String origin;
    private String status;

    private static int count = 0; // number of objects in memory

    public Profile(String firstName, String lastName, String username)
    {
        fName = firstName;
        lName = lastName;
        this.username = username;

        count++; // increment static count of Profiles
    }

    // static method to get static count value
    public static int getCount()
    {
        return count;
    }
}



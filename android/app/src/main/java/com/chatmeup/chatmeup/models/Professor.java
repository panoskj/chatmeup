package com.chatmeup.chatmeup.models;

public class Professor extends User {

    public final String department;

    public Professor(long id, String username, String department)
    {
        super(id, username);
        this.department = department;
    }
}

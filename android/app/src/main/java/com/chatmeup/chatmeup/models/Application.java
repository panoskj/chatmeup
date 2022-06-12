package com.chatmeup.chatmeup.models;

public class Application extends User{

    public final String department;

    public Application(long id, String username, String department)
    {
        super(id, username);
        this.department = department;
    }
}
package com.chatmeup.chatmeup.models;


public class Professor {

    public final long professorId;
    public String professorDepartment;


    public Professor(User User, String department) {
        this.professorId = User.id;
        this.professorDepartment = department;
    }


}

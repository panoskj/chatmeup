package com.chatmeup.chatmeup.models;


import com.chatmeup.chatmeup.models.chats.VerifiedClassChat;

public class Professor {

    public final long professorId;
    public String professorDepartment;


    public Professor(User User, String department) {
        this.professorId = User.id;
        this.professorDepartment = department;
    }


    public void CreateVerifiedChat(){
    }

    public boolean DeleteVerifiedChat(VerifiedClassChat A){
       return false;
    }
}

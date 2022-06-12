package com.chatmeup.chatmeup.controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;
import com.chatmeup.chatmeup.models.Professor;

@RequiresApi(api = Build.VERSION_CODES.N)
public class VerifyProfessorController {
    
    public final User[] hardcodedUsers;
    public final Admin[] hardcodedAdmins;
    public final List<Applications> hardcodedApplications;
    public final boolean approve = false;
    public final Professor hardcodedProfessor;

    public VerifyProfessorController() {

        hardcodedUser = new User[]{
                new User(1000,"Papagianhs"),
                new User(1001,"Antoniou"),
        };

        hardcodedAdmins = new Admin[]{
                new Admin(10000, "admin"),
                new Admin(10001, "admin1")
        };

        hardcodedApplications = new ArrayList<>();
    }

    public ProfessorApply(Professor professor) {
        hardcodedApplications = new Application[]{
            new Application(1000, "Papagianhs", "University of Patras"),
            new Application(1001, "Antoniou", "Panteion University")
        };
    }

    public AdminHandleApplication(Admin admin, Application application){
        if (approve == true){
            hardcodedProfessor = new Professor[]{
                new Professor(1000,"Papagianhs", Application.department),
                new Professor(1001,"Antoniou", Application.department),
        };
        }
    }
}
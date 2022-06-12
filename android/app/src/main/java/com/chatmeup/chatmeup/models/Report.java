package com.chatmeup.chatmeup.models;

import java.util.Date;

public class Report {

    public final int id;
    public final String reason;
    public final String description;
    public final Date date;
    public final User reportingUser;
    public final User reportedUser;

    public Report(int id,
                  String reason,
                  String description,
                  Date date,
                  User reportingUser,
                  User reportedUser) {
        this.id = id;
        this.reason = reason;
        this.description = description;
        this.date = date;
        this.reportingUser = reportingUser;
        this.reportedUser = reportedUser;
    }
}

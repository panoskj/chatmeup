package com.chatmeup.chatmeup.models;

import java.util.List;

public class Ban {

    public final List<Report> reports;
    public final Admin admin;
    public final User banned;

    public Ban(List<Report> reports, Admin admin, User banned)
    {
        this.reports = reports;
        this.admin = admin;
        this.banned = banned;
    }
}

package com.chatmeup.chatmeup.controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.chatmeup.chatmeup.models.Admin;
import com.chatmeup.chatmeup.models.Ban;
import com.chatmeup.chatmeup.models.Report;
import com.chatmeup.chatmeup.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class ReportBanController {

    public final User[] hardcodedUsers;
    public final List<Report> hardcodedReports;
    public final List<Ban> hardcodedBans;

    public final Admin[] hardcodedAdmins;

    public ReportBanController() {

        hardcodedBans = new ArrayList<>();

        hardcodedUsers = new User[]{
                new User(1000, "reporter1", "123"),
                new User(1001, "reported1", "123"),
        };

        hardcodedReports = new ArrayList<>(Collections.singletonList(new Report(1,
                "some reason",
                "some description",
                new Date(),
                hardcodedUsers[0],
                hardcodedUsers[1])));

        hardcodedAdmins = new Admin[]{
                new Admin(10000, "admin", "admin")
        };
    }


    public Map<User, List<Report>> GetReportedUsers()
    {
        Set<Long> bannedUserIds = hardcodedBans
                .stream()
                .map(ban -> ban.banned.id)
                .collect(Collectors.toSet());

        Report[] reports = (Report[])hardcodedReports
                .stream()
                .filter(x -> !bannedUserIds.contains(x.reportedUser.id))
                .toArray();

        HashMap<User, List<Report>> results = new HashMap<>();

        for (Report report : reports) {

            if (!results.containsKey(report.reportedUser))
            {
                results.put(report.reportedUser, new ArrayList<>());
            }

            results.get(report.reportedUser).add(report);
        }

        return results;
    }

    public void Ban(long adminId, Map<Integer, Integer[]> users)
    {
        Admin admin = (Admin) Arrays.stream(hardcodedAdmins)
                .filter(x -> x.id == adminId)
                .toArray()[0];

        for (Integer userId : users.keySet())
        {
            Integer[] reportIds = users.get(userId);

            if (reportIds == null) continue;

            User user = (User) Arrays
                    .stream(hardcodedUsers)
                    .filter(x -> x.id == userId)
                    .toArray()[0];

            Set<Integer> reportIdsSet = Arrays
                    .stream(reportIds)
                    .collect(Collectors.toSet());

            List<Report> reports = hardcodedReports
                    .stream()
                    .filter(x -> reportIdsSet.contains(x.id))
                    .collect(Collectors.toList());

            hardcodedBans.add(new Ban(reports, admin, user));
        }
    }
}

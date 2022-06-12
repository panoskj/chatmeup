package com.chatmeup.chatmeup.controllers;

import com.chatmeup.chatmeup.SearchResults;
import com.chatmeup.chatmeup.models.Contact;
import com.chatmeup.chatmeup.models.User;
import com.chatmeup.chatmeup.models.chats.GroupChat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchController {

    final List<User> hardcodedUsers;
    final List<GroupChat> hardcodedGroups;

    public SearchController() {
        hardcodedGroups = new ArrayList<>();
        hardcodedUsers = new ArrayList<>();
    }

    public SearchResults Search(User user, String query)
    {
        List<Contact> contacts = user
                .SearchContacts(query);

        Set<Long> contactUserIds = contacts
                .stream()
                .map(c -> c.user.id)
                .collect(Collectors.toSet());

        List<GroupChat> joinedGroups = user
                .SearchGroups(query);

        Set<String> joinedGroupIds = joinedGroups
                .stream()
                .map(g -> g.chatId)
                .collect(Collectors.toSet());

        List<User> otherUsers = hardcodedUsers
                .stream()
                .filter(u -> u.MatchesSearch(query)
                        && u.id != user.id
                        && !contactUserIds.contains(u.id)
                        && !u.HasBlocked(user))
                .collect(Collectors.toList());

        List<GroupChat> otherGroups = hardcodedGroups
                .stream()
                .filter(g -> g.MatchesSearch(query)
                        && !joinedGroupIds.contains(g.chatId))
                .collect(Collectors.toList());

        return new SearchResults(contacts, joinedGroups, otherUsers, otherGroups);
    }
}

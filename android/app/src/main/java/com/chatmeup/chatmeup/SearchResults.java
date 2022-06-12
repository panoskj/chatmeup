package com.chatmeup.chatmeup;

import com.chatmeup.chatmeup.models.Contact;
import com.chatmeup.chatmeup.models.User;
import com.chatmeup.chatmeup.models.chats.GroupChat;

import java.util.List;

public class SearchResults {

    public final List<Contact> contacts;
    public final List<GroupChat> joinedGroups;
    public final List<User> otherUsers;
    public final List<GroupChat> otherGroups;

    public SearchResults(List<Contact> contacts, List<GroupChat> joinedGroups, List<User> otherUsers, List<GroupChat> otherGroups) {
        this.contacts = contacts;
        this.joinedGroups = joinedGroups;
        this.otherUsers = otherUsers;
        this.otherGroups = otherGroups;
    }
}



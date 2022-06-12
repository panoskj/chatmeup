package com.chatmeup.chatmeup.models;

import com.chatmeup.chatmeup.models.chats.PrivateChat;

import java.util.Date;

public class Contact {

    public final User user;
    public final Date dateAdded;
    public final PrivateChat chat;

    public Contact(User user, Date dateAdded, PrivateChat chat) {
        this.user = user;
        this.dateAdded = dateAdded;
        this.chat = chat;
    }
}

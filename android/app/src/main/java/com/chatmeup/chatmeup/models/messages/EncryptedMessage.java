package com.chatmeup.chatmeup.models.messages;

import com.chatmeup.chatmeup.models.User;
import com.chatmeup.chatmeup.models.keys.Key;

import java.util.Date;

public class EncryptedMessage {

    public final User sender;
    public final User receiver;
    public final Date destroyAfter;
    public final String chatId;
    public final byte[] messageContent;

    public EncryptedMessage(User sender, User receiver, Date destroyAfter, String chatId, byte[] messageContent) {
        this.sender = sender;
        this.receiver = receiver;
        this.destroyAfter = destroyAfter;
        this.chatId = chatId;
        this.messageContent = messageContent;
    }

    public Message DecryptMessage(Key key) {

        return null;

    }
}

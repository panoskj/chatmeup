package com.chatmeup.chatmeup.models.messages;

import com.chatmeup.chatmeup.models.User;

import java.util.Date;

public class Message {

    public final User sender;
    public final User receiver;
    public final Date destroyAfter;
    public final String chatId;

    public Message(EncryptedMessage encryptedMessage, String groupChatId) {
        this.sender = encryptedMessage.sender;
        this.receiver = encryptedMessage.receiver;
        this.destroyAfter = encryptedMessage.destroyAfter;
        this.chatId = groupChatId;
    }
}

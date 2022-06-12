package com.chatmeup.chatmeup.models.chats;

import com.chatmeup.chatmeup.models.keys.SharedKey;

public class EncryptedChat {

    public final String chatId;
    public final SharedKey sharedKey;

    public EncryptedChat(String chatId, SharedKey sharedKey) {
        this.chatId = chatId;
        this.sharedKey = sharedKey;
    }
}

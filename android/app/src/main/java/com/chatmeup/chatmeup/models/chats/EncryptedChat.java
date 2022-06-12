package com.chatmeup.chatmeup.models.chats;

import com.chatmeup.chatmeup.models.keys.SharedKey;

public class EncryptedChat {

    public final long chatId;
    public final SharedKey sharedKey;

    public EncryptedChat(long chatId, SharedKey sharedKey) {
        this.chatId = chatId;
        this.sharedKey = sharedKey;
    }
}

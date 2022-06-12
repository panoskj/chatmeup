package com.chatmeup.chatmeup.models.messages;

public class Call extends Message{
    public long[] call;

    public Call(EncryptedMessage encryptedMessage, String groupChatId, long[] call) {
        super(encryptedMessage, groupChatId);
        this.call = call;
    }
}

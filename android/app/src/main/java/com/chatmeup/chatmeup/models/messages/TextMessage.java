package com.chatmeup.chatmeup.models.messages;

public class TextMessage extends Message {

    public final String text;

    public TextMessage(EncryptedMessage encryptedMessage, long groupChatId, String text) {
        super(encryptedMessage, groupChatId);
        this.text = text;
    }

}

package com.chatmeup.chatmeup.models.chats;

import com.chatmeup.chatmeup.models.keys.SharedKey;
import com.chatmeup.chatmeup.models.messages.EncryptedMessage;
import com.chatmeup.chatmeup.models.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class EncryptedChat {

    public final String chatId;
    public final SharedKey sharedKey;
    public final List<Message> messages;

    public EncryptedChat(String chatId, SharedKey sharedKey) {
        this.chatId = chatId;
        this.sharedKey = sharedKey;
        messages = new ArrayList<>();
    }

    public void AddMessage(EncryptedMessage encryptedMessage){

        Message message = encryptedMessage.DecryptMessage(sharedKey);

        if (message != null) messages.add(message);
    }
}

package com.chatmeup.chatmeup.controllers;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.chatmeup.chatmeup.models.User;
import com.chatmeup.chatmeup.models.chats.EncryptedChat;
import com.chatmeup.chatmeup.models.messages.EncryptedMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class EncryptedCommunicationController {

    final List<EncryptedMessage> hardcodedPendingMessages;

    public EncryptedCommunicationController() {
        hardcodedPendingMessages = new ArrayList<>();
    }

    public void GetPendingMessages(User user) {

        List<EncryptedMessage> newMessages = hardcodedPendingMessages
                .stream()
                .filter(x -> x.receiver.id == user.id)
                .collect(Collectors.toList());

        for (EncryptedMessage encryptedMessage : newMessages)
        {
            user.ProcessEncryptedMessage(encryptedMessage);
            hardcodedPendingMessages.remove(encryptedMessage);
        }
    }
}

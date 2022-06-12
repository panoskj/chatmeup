package com.chatmeup.chatmeup.models;

// 1. Create classes for models
// 2. Create controllers/services (hardcoded results)

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.chatmeup.chatmeup.models.chats.EncryptedChat;
import com.chatmeup.chatmeup.models.chats.GroupChat;
import com.chatmeup.chatmeup.models.chats.PrivateChat;
import com.chatmeup.chatmeup.models.keys.PrivateKey;
import com.chatmeup.chatmeup.models.keys.PublicKey;
import com.chatmeup.chatmeup.models.keys.SharedKey;
import com.chatmeup.chatmeup.models.messages.EncryptedMessage;
import com.chatmeup.chatmeup.models.messages.Message;
import com.chatmeup.chatmeup.models.messages.TextMessage;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class User {

    public final long id;
    public final String username;
    public String password;
    public String email;
    public String phone;
    public int age;
    public String pin;
    public Donation[] donations;
    public List<Contact> requests;
    public List<Contact> contacts;
    public List<GroupChat> groupChats;
    public PublicKey publicKey;
    public PrivateKey privateKey;

    public User(long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    private boolean MatchesSearch(String query) {

        query = query.toLowerCase();

        return username.toLowerCase().contains(query)
                || email.toLowerCase().contains(query)
                || phone.equals(query);
    }

    public List<Contact> SearchContacts(String query) {
        return contacts
                .stream()
                .filter(contact -> contact.user.MatchesSearch(query))
                .collect(Collectors.toList());
    }

    public PrivateChat GetPrivateChat(User otherUser) {

        PrivateChat privateChat = contacts
                .stream()
                .filter(contact -> contact.user.id == otherUser.id)
                .findFirst()
                .map(contact -> contact.chat)
                .orElse(null);

        if (privateChat != null) return privateChat;

        return requests
                .stream()
                .filter(contact -> contact.user.id == otherUser.id)
                .findFirst()
                .map(contact -> contact.chat)
                .orElse(null);
    }

    public GroupChat GetGroupChat(String chatId) {

        return groupChats
                .stream()
                .filter(groupChat -> groupChat.chatId.equals(chatId))
                .findFirst()
                .orElse(null);
    }

    public EncryptedChat GetChatById(String chatId) {

        PrivateChat privateChat = contacts
                .stream()
                .map(contact -> contact.chat)
                .filter(chat -> chat.chatId.equals(chatId))
                .findFirst()
                .orElse(null);

        if (privateChat != null) return privateChat;

        return GetGroupChat(chatId);
    }

    public void ProcessEncryptedMessage(EncryptedMessage encryptedMessage)
    {
        EncryptedChat chat = GetChatById(encryptedMessage.chatId);

        User sender = encryptedMessage.sender;

        if (chat == null && GetPrivateChat(sender) == null) {

            ProcessFriendRequest(encryptedMessage);
        }
        else {




        }
    }

    public void ProcessFriendRequest(EncryptedMessage encryptedMessage){

        User sender = encryptedMessage.sender;

        TextMessage message = (TextMessage)encryptedMessage.DecryptMessage(privateKey);

        String chatId = "private:" + sender.id + ":" + id;

        PrivateChat newChat = new PrivateChat(chatId, new SharedKey(message), sender);

        requests.add(new Contact(message.sender, new Date(), newChat));
    }
}

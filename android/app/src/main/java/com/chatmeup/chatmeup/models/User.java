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

import java.util.List;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class User {

    public final long id;
    public final String username;
    public String password;
    public String email;
    public String phone;
    public int age;
    public String pin;
    public Donation[] donations;
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

        return email.toLowerCase().contains(query.toLowerCase())
                || phone.equals(query);
    }

    public List<Contact> SearchContacts(String query) {
        return contacts
                .stream()
                .filter(contact -> contact.user.MatchesSearch(query))
                .collect(Collectors.toList());
    }

    public PrivateChat GetPrivateChat(User otherUser) {

        return contacts
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
}

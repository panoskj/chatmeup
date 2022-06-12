package com.chatmeup.chatmeup.models.chats;

import com.chatmeup.chatmeup.models.Moderator;
import com.chatmeup.chatmeup.models.User;
import com.chatmeup.chatmeup.models.keys.SharedKey;

import java.util.Date;
import java.util.LinkedList;

public class GroupChat extends EncryptedChat {
    private String groupName;
    private String groupID;
    private String encryptedSharedKey;
    protected LinkedList<String> messages;	//List of text messages that have been sent by users to the chatroom and are displayed in the chatroom
    protected Date dateLastUsed;		//The last time the chatroom was joined or had a message sent to it
    protected LinkedList<User> users;	//The clients/users that are currently in the chat
    protected LinkedList<Moderator> moderators;	//The moderators that are currently in the chat

    private int member_count = 0; // number of members in groupChat

    public GroupChat(String chatId, SharedKey sharedKey, String groupName, String groupID) {
        super(chatId, sharedKey);
        this.groupName = groupName;
        this.groupID = groupID;

        member_count++; // increment static member_count of members in groupChat
    }


    public boolean MatchesSearch(String query) {

        query = query.toLowerCase();

        return groupName.toLowerCase().contains(query);
    }
}

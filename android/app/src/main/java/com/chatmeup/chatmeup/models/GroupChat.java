package com.chatmeup.chatmeup.models;

import java.util.LinkedList;

public class GroupChat {
    private String groupName;
    private String groupID;
    private String encryptedSharedKey;
    protected LinkedList<String> messages;	//List of text messages that have been sent by users to the chatroom and are displayed in the chatroom
    protected long dateLastUsed;		//The last time the chatroom was joined or had a message sent to it
    protected LinkedList<User> users;	//The clients/users that are currently in the chat
    protected LinkedList<Moderator> moderators;	//The moderators that are currently in the chat

    private static int member_count = 0; // number of members in groupChat

    public GroupChat(String groupName, String groupID) {
        this.groupName = groupName;
        this.groupID = groupID;

        member_count++; // increment static member_count of members in groupChat
    }
}

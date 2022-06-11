package com.chatmeup.chatmeup.models;

public class PrivateChat {
    private String chat;		//Name of the chat
    private String friendEmail;
    private String friendUsername;
    protected LinkedList<String> messages;	//List of text messages that have been sent by users to the chatroom and are displayed in the chatroom
    protected long dateLastUsed;		//The last time the chatroom was joined or had a message sent to it
    protected LinkedList<User> users;	//The clients/users that are currently in the chat

    /*
     * Chatroom constructor
     */
    public PrivateChat(String name, String friendEmail) {
        dateLastUsed = System.currentTimeMillis() / 1000;		//Set the time that the chat was used last to the current UNIX Epoch time
        messages = new LinkedList<String>();
        this.friendEmail = friendEmail;
        this.chat = name;
    }

    /*
     * Adds a message into the chat
     */
    protected void addMessage(String message) {
        messages.add(message);
        dateLastUsed = System.currentTimeMillis() / 1000;
    }

    /*
     * Returns the name of the chatroom
     */
    protected String getChat() {
        return this.chat;
    }

}

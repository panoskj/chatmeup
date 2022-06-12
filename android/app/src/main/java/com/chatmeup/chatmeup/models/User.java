package com.chatmeup.chatmeup.models;

// 1. Create classes for models
// 2. Create controllers/services (hardcoded results)

import com.chatmeup.chatmeup.models.keys.PrivateKey;
import com.chatmeup.chatmeup.models.keys.PublicKey;

public class User {

    public final long id;
    public final String username;
    public String password;
    public String email;
    public String phone;
    public int age;
    public String pin;
    public Donation[] donations;
    public Contact[] contacts;
    public PublicKey publicKey;
    public PrivateKey privateKey;

    public User(long id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;

    }

    public Contact[] SearchContacts(String query)
    {
        return null;
    }
}

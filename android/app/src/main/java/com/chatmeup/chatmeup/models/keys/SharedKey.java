package com.chatmeup.chatmeup.models.keys;

import com.chatmeup.chatmeup.models.messages.TextMessage;

import java.util.Date;

public class SharedKey extends Key {

    public SharedKey(TextMessage message) {

        super((message.text + new Date()).getBytes());
    }
}

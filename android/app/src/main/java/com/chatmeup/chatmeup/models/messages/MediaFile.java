package com.chatmeup.chatmeup.models.messages;

public class MediaFile extends Message{

    public long[] mediaFile;


    public MediaFile(EncryptedMessage encryptedMessage, String groupChatId, long[] mediaFile){

        super(encryptedMessage,groupChatId);
        this.mediaFile=mediaFile;
    }

}

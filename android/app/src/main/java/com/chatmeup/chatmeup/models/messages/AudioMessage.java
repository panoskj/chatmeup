package com.chatmeup.chatmeup.models.messages;

public class AudioMessage extends MediaFile{

    public long[] audioMessageData;


    public AudioMessage(EncryptedMessage encryptedMessage, String groupChatId, long[] mediaFile,long[] audioMessageData){

        super(encryptedMessage,groupChatId,mediaFile);
        this.audioMessageData=audioMessageData;
    }

}

package com.chatmeup.chatmeup.models.messages;

public class AudioCall extends Call{

    public long[] audioCallData;




    public AudioCall(EncryptedMessage encryptedMessage, String groupChatId, long[] call, long[] audioCallData){
        super(encryptedMessage,groupChatId,call);
        this.audioCallData=audioCallData;
    }
}

package com.chatmeup.chatmeup.models.messages;

public class VideoCall extends AudioCall{

    public long[] videoCallData;

    public VideoCall(EncryptedMessage encryptedMessage, String groupChatId, long[] call, long[] audioCallData,long[] videoCallData){
        super(encryptedMessage,groupChatId,call,audioCallData);
        this.videoCallData=videoCallData;
    }
}

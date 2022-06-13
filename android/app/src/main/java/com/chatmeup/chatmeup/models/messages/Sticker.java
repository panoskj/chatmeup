package com.chatmeup.chatmeup.models.messages;

public class Sticker extends MediaFile{
    public int stickerID;

    public Sticker(EncryptedMessage encryptedMessage, String groupChatId, long[] mediaFile,int stickerID){

        super(encryptedMessage,groupChatId,mediaFile);
        this.stickerID=stickerID;
    }


}



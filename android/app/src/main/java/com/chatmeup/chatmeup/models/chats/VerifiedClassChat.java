package com.chatmeup.chatmeup.models.chats;

import com.chatmeup.chatmeup.models.Professor;
import com.chatmeup.chatmeup.models.keys.SharedKey;

public class VerifiedClassChat extends GroupChat{

    public Professor professorId;
    public GroupChat verifiedClassID;
    public String className;
    public String classDescription;
    public String classPassword;

    public VerifiedClassChat(String chatId, SharedKey sharedKey, String groupName, GroupChat groupID, Professor professorId, String classDescription) {
        super(chatId, sharedKey, groupName, groupID);
        this.professorId=professorId;
        this.verifiedClassID=groupID;
        this.className=groupName;
        this.classDescription=classDescription;
        this.classPassword = groupPwd;

    }

    public void setClassPassword(String classPassword) {
        super.SetGroupPwd(classPassword);
    }

    public void setClassName(String Name){
        super.SetGroupName(Name);
    }

    public void SetClassDescription(String classDescription){
        this.classDescription=classDescription;
    }
}

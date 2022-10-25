package com.db.community.model.document.message;

import com.db.community.model.enums.MessageType;

public abstract class SystemMessage extends Message {

    private MessageType messageType = MessageType.SYSTEM;

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }
}

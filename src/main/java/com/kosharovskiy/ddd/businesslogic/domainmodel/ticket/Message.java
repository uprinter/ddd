package com.kosharovskiy.ddd.businesslogic.domainmodel.ticket;

import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.Body;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.MessageId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Message {
    private final MessageId messageId;

    @Setter
    private Body body;
    private final List<Attachment> attachments;

    public Message(MessageId messageId, Body body) {
        this.messageId = messageId;
        this.body = body;
        this.attachments = new ArrayList<>();
    }

    void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }
}

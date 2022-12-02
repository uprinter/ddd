package com.kosharovskiy.ddd.domainmodel;

import com.kosharovskiy.ddd.domainmodel.ticket.*;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.*;

import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        var ticket = new Ticket(new TicketId(1), new Title("New bug"));
        ticket.getTitle();

        List<Message> messages = ticket.getMessages();


        ticket.setTitle(new Title("New title"));

        ticket.addMessage("New bug!");
        ticket.addAttachment(new MessageId(1), "/att");
        ticket.updateMessage(new MessageId(1), "no");

        for (Message message : messages) {
            System.out.println(message);
        }

        Optional<Message> message = ticket.getMessageById(new MessageId(1));

        if (message.isPresent()) {
            List<Attachment> attachments = message.get().getAttachments();
            AttachmentId attachmentId = attachments.get(0).getAttachmentId();
            FileName fileName = attachments.get(0).getFileName();
        }

        Title title = ticket.getTitle();

        System.out.println(ticket);
    }
}

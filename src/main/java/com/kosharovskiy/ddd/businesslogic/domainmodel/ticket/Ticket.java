package com.kosharovskiy.ddd.businesslogic.domainmodel.ticket;

import com.kosharovskiy.ddd.businesslogic.domainmodel.product.valueobject.ProductId;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.*;
import java.util.function.Predicate;

@ToString
public class Ticket {
    private final TicketId ticketId;

    @Setter
    @Getter
    private Title title;

    private final List<Message> messages;

    private final List<ProductId> productIds;

    public Ticket(Title title) {
        this(new TicketId(UUID.randomUUID().toString()), title);
    }

    private Ticket(TicketId ticketId, Title title) {
        this.ticketId = ticketId;
        this.title = title;
        this.messages = new ArrayList<>();
        this.productIds = new ArrayList<>();
    }

    public List<Message> getMessages() {
        return Collections.unmodifiableList(this.messages);
    }

    public List<ProductId> getProductIds() {
        return Collections.unmodifiableList(this.productIds);
    }

    public Message addMessage(String body) {
        if (body == null) {
            throw new IllegalArgumentException("Message can't be null");
        }

        Message message = new Message(new MessageId(1), new Body(body));
        messages.add(message);
        return message;
    }

    public void addProductId(ProductId productId) {
        productIds.add(productId);
    }

    public void updateMessage(MessageId messageId, String body) {
        getMessageById(messageId).ifPresent(message -> message.setBody(new Body(body)));
    }

    public void addAttachment(MessageId messageId, String fileName) {
        getMessageById(messageId).ifPresent(message -> message.addAttachment(new Attachment(new AttachmentId(1), new FileName(fileName))));
    }

    public Optional<Message> getMessageById(MessageId messageId) {
        Predicate<Message> filter = message -> message.getMessageId().equals(messageId);
        return messages.stream().filter(filter).findFirst();
    }
}


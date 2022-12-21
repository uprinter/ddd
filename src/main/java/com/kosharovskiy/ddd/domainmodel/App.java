package com.kosharovskiy.ddd.domainmodel;

import com.kosharovskiy.ddd.domainmodel.ticket.Message;
import com.kosharovskiy.ddd.domainmodel.ticket.Ticket;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.Title;

public class App {
    public static void main(String[] args) {
        TicketService ticketService = new TicketService(new TicketRepository() {
        });

        Ticket ticket = ticketService.createTicket(new Title("New ticket"));
        Message message = ticket.addMessage("New message");
        ticket.addAttachment(message.getMessageId(), "Attached file");

        ticket.updateMessage(message.getMessageId(), "Updated message");
    }
}

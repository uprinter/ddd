package com.kosharovskiy.ddd.domainmodel;

import com.kosharovskiy.ddd.domainmodel.ticket.Ticket;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.MessageId;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.TicketId;
import com.kosharovskiy.ddd.domainmodel.ticket.valueobject.Title;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public Ticket createTicket(Title title) {
        Ticket ticket = new Ticket(title);
        ticketRepository.save(ticket);
        return ticket;
    }

    public void addMessage(TicketId ticketId, String message) {
        Ticket ticket = ticketRepository.load(ticketId);
        ticket.addMessage(message);
        ticketRepository.save(ticket);
    }

    public void updateMessage(TicketId ticketId, MessageId messageId, String message) {
        Ticket ticket = ticketRepository.load(ticketId);
        ticket.updateMessage(messageId, message);
        ticketRepository.save(ticket);
    }

    public void addAttachment(TicketId ticketId, MessageId messageId, String fileName) {
        Ticket ticket = ticketRepository.load(ticketId);
        ticket.addAttachment(messageId, fileName);
        ticketRepository.save(ticket);
    }
}

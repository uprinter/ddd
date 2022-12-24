package com.kosharovskiy.ddd.businesslogic.domainmodel;

import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.Ticket;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.TicketId;
import com.kosharovskiy.ddd.businesslogic.domainmodel.ticket.valueobject.Title;

public interface TicketRepository {
    default Ticket load(TicketId ticketId) {
        return new Ticket(new Title("Ticket " + ticketId));
    }
    default void save(Ticket ticket) {}
}

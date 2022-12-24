package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Timestamp;
import lombok.Getter;

@Getter
public class TicketClosed extends Event {
    private final Status status = Status.CLOSED;

    public TicketClosed(TicketId ticketId, Timestamp timestamp) {
        super(ticketId, EventType.TICKET_CLOSED, timestamp);
    }
}
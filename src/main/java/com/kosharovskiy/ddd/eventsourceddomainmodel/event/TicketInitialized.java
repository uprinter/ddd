package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import lombok.Getter;

@Getter
public class TicketInitialized extends Event {
    private final Title title;
    private final Status status;

    public TicketInitialized(TicketId ticketId, Title title) {
        super(ticketId, EventType.TICKET_INITIALIZED);
        this.title = title;
        this.status = Status.NEW;
    }
}
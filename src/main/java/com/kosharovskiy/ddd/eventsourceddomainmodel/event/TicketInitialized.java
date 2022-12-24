package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Timestamp;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import lombok.Getter;

@Getter
public class TicketInitialized extends Event {
    private final Title title;
    private final Status status = Status.NEW;

    public TicketInitialized(TicketId ticketId, Title title, Timestamp timestamp) {
        super(ticketId, EventType.TICKET_INITIALIZED, timestamp);
        this.title = title;
    }
}
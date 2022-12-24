package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Timestamp;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.TicketId;
import lombok.Getter;

@Getter
public abstract class Event {
    private final EventType eventType;
    private final TicketId ticketId;
    private final Timestamp timestamp;

    public Event(TicketId ticketId, EventType eventType, Timestamp timestamp) {
        this.ticketId = ticketId;
        this.eventType = eventType;
        this.timestamp = timestamp;
    }
}

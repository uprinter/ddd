package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Timestamp;
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

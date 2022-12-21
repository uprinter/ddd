package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import lombok.Getter;

@Getter
public abstract class Event {
    private final EventType eventType;
    private final TicketId ticketId;
    private final int timestamp;
    private final int version;

    public Event(TicketId ticketId, EventType eventType) {
        this.ticketId = ticketId;
        this.eventType = eventType;
        this.timestamp = 0;
        this.version = 0;
    }
}

package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Timestamp;
import lombok.Getter;

@Getter
public class StatusChanged extends Event {
    private final Status status;

    public StatusChanged(TicketId ticketId, Status status, Timestamp timestamp) {
        super(ticketId, EventType.STATUS_CHANGED, timestamp);
        this.status = status;
    }
}
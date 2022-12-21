package com.kosharovskiy.ddd.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import lombok.Getter;

@Getter
public class StatusChanged extends Event {
    private final Status status;

    public StatusChanged(TicketId ticketId, Status status) {
        super(ticketId, EventType.STATUS_CHANGED);
        this.status = status;
    }
}
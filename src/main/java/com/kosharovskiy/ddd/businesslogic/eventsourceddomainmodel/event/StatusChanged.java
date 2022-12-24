package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.event;

import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Timestamp;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.TicketId;
import lombok.Getter;

@Getter
public class StatusChanged extends Event {
    private final Status status;

    public StatusChanged(TicketId ticketId, Status status, Timestamp timestamp) {
        super(ticketId, EventType.STATUS_CHANGED, timestamp);
        this.status = status;
    }
}
package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.event.StatusChanged;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketInitialized;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import lombok.Getter;
import lombok.ToString;

@ToString
public class TicketProjection {
    private TicketId ticketId;

    @Getter
    private Title title;

    @Getter
    private Status status;

    @Getter
    private long version;

    public void apply(TicketInitialized event) {
        ticketId = event.ticketId();
        status = event.status();
        title = event.title();
        version = 0;
    }

    public void apply(StatusChanged event) {
        status = event.status();
        version++;
    }
}
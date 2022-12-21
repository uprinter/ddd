package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.event.Event;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.StatusChanged;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketInitialized;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import lombok.Getter;
import lombok.ToString;

@ToString
public class TicketLatestStateProjection {
    private TicketId ticketId;

    @Getter
    private Title title;

    @Getter
    private Status status;

    @Getter
    private long version;

    private int timestamp;

    public void apply(TicketInitialized event) {
        status = event.getStatus();
        title = event.getTitle();
        baseApply(event);
    }

    public void apply(StatusChanged event) {
        status = event.getStatus();
        baseApply(event);
    }

    private void baseApply(Event event) {
        ticketId = event.getTicketId();
        timestamp = event.getTimestamp();
        version = event.getVersion();
    }
}
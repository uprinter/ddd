package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.command.ChangeStatus;
import com.kosharovskiy.ddd.eventsourceddomainmodel.command.CloseTicket;
import com.kosharovskiy.ddd.eventsourceddomainmodel.command.CreateTicket;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.Event;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.StatusChanged;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketClosed;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketInitialized;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Timestamp;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ToString
public class Ticket {
    private TicketId ticketId;

    @Getter
    private Title title;

    @Getter
    private Status status;

    @Getter
    private long version;

    private Timestamp timestamp;

    private final List<Event> events = new ArrayList<>();

    public Ticket(List<Event> events) {
        events.forEach(this::appendEvent);
    }

    public void executeCommand(CreateTicket command) {
        TicketId ticketId = new TicketId(UUID.randomUUID().toString());
        Title title = command.title();
        TicketInitialized event = new TicketInitialized(ticketId, title, Timestamp.now());
        appendEvent(event);
    }

    public void executeCommand(ChangeStatus command) {
        StatusChanged event = new StatusChanged(this.ticketId, command.status(), Timestamp.now());
        appendEvent(event);
    }

    public void executeCommand(CloseTicket command) {
        TicketClosed event = new TicketClosed(this.ticketId, Timestamp.now());
        appendEvent(event);
    }

    private void apply(TicketInitialized event) {
        ticketId = new TicketId(UUID.randomUUID().toString());
        status = event.getStatus();
        title = event.getTitle();
        applyVersionAndTimestamp(event);
    }

    private void apply(StatusChanged event) {
        status = event.getStatus();
        applyVersionAndTimestamp(event);
    }

    private void apply(TicketClosed event) {
        status = event.getStatus();
        applyVersionAndTimestamp(event);
    }

    private void applyVersionAndTimestamp(Event event) {
        timestamp = event.getTimestamp();
        version++;
    }

    private void appendEvent(Event event) {
        switch (event.getEventType()) {
            case TICKET_INITIALIZED -> this.apply((TicketInitialized) event);
            case STATUS_CHANGED -> this.apply((StatusChanged) event);
            case TICKET_CLOSED -> this.apply((TicketClosed) event);
        }
        this.events.add(event);
    }
}
package com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel;

import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.event.Event;
import com.kosharovskiy.ddd.businesslogic.eventsourceddomainmodel.valueobject.TicketId;

import java.util.ArrayList;
import java.util.List;

public interface EventStore {
    default void append(TicketId ticketId, List<Event> newEvents, int expectedVersion) {

    }
    default List<Event> fetch(TicketId ticketId) {
        return new ArrayList<>();
    }
}

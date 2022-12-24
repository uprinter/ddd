package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.event.Event;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;

import java.util.ArrayList;
import java.util.List;

interface EventStore {
    default void append(TicketId ticketId, List<Event> newEvents, int expectedVersion) {

    }
    default List<Event> fetch(TicketId ticketId) {
        return new ArrayList<>();
    }
}

package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.event.Event;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketInitialized;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.StatusChanged;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;

import java.util.List;

public class App {
    public static void main(String[] args) {
        EventStore eventStore = new EventStore() {};
        List<Event> events = eventStore.fetch(new TicketId("aab"));

        TicketLatestStateProjection ticketLatestStateProjection = new TicketLatestStateProjection();

        for (Event event : events) {
            switch (event.getEventType()) {
                case TICKET_INITIALIZED -> ticketLatestStateProjection.apply((TicketInitialized) event);
                case STATUS_CHANGED -> ticketLatestStateProjection.apply((StatusChanged) event);
            }
        }

        System.out.println(ticketLatestStateProjection);
    }
}

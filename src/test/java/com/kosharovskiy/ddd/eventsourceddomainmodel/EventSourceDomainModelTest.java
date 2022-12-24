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
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class EventSourceDomainModelTest {
    @Mock
    private EventStore eventStore;

    @Test
    void testTicketEvents() {
        // given
        List<Event> events = List.of(
                new TicketInitialized(new TicketId("1"), new Title("title"), Timestamp.of(ZonedDateTime.now().minusDays(6))),
                new StatusChanged(new TicketId("1"), Status.TODO, Timestamp.of(ZonedDateTime.now().minusDays(5))),
                new StatusChanged(new TicketId("1"), Status.DEVELOPMENT, Timestamp.of(ZonedDateTime.now().minusDays(4))),
                new StatusChanged(new TicketId("1"), Status.TEST, Timestamp.of(ZonedDateTime.now().minusDays(3))),
                new StatusChanged(new TicketId("1"), Status.DONE, Timestamp.of(ZonedDateTime.now().minusDays(2))),
                new TicketClosed(new TicketId("1"), Timestamp.of(ZonedDateTime.now().minusDays(1)))
        );

        // when
        Ticket ticket = new Ticket(events);

        // then
        assertThat(ticket.getVersion()).isEqualTo(6);
        assertThat(ticket.getStatus()).isEqualTo(Status.CLOSED);
        assertThat(ticket.getTitle()).isEqualTo(new Title("title"));
    }

    @Test
    public void testTicketCommands() {
        // given
        var ticket = new Ticket(Collections.emptyList());

        // when
        ticket.executeCommand(new CreateTicket(new Title("title")));
        ticket.executeCommand(new ChangeStatus(Status.TODO));
        ticket.executeCommand(new ChangeStatus(Status.DEVELOPMENT));
        ticket.executeCommand(new ChangeStatus(Status.TEST));
        ticket.executeCommand(new ChangeStatus(Status.DONE));
        ticket.executeCommand(new CloseTicket());

        // then
        assertThat(ticket.getVersion()).isEqualTo(6);
        assertThat(ticket.getStatus()).isEqualTo(Status.CLOSED);
        assertThat(ticket.getTitle()).isEqualTo(new Title("title"));
    }

}

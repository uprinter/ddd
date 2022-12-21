package com.kosharovskiy.ddd.eventsourceddomainmodel;

import com.kosharovskiy.ddd.eventsourceddomainmodel.event.StatusChanged;
import com.kosharovskiy.ddd.eventsourceddomainmodel.event.TicketInitialized;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Status;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.TicketId;
import com.kosharovskiy.ddd.eventsourceddomainmodel.valueobject.Title;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class EventSourceDomainModelTest {
    @Mock
    private EventStore eventStore;

    @Test
    public void testLatestStateProjection() {
        // given
        var projection = new TicketLatestStateProjection();
        given(eventStore.fetch(any(TicketId.class))).willReturn(List.of(
                new TicketInitialized(new TicketId("1"), new Title("title")),
                new StatusChanged(new TicketId("1"), Status.CLOSED)
        ));

        // when
        eventStore.fetch(new TicketId("1")).forEach(event -> {
            switch (event.getEventType()) {
                case TICKET_INITIALIZED -> projection.apply((TicketInitialized) event);
                case STATUS_CHANGED -> projection.apply((StatusChanged) event);
            }
        });

        // then
        assertThat(projection.getStatus()).isEqualTo(Status.CLOSED);
        assertThat(projection.getTitle()).isEqualTo(new Title("title"));
    }
}

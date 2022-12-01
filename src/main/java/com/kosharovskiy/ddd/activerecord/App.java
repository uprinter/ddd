package com.kosharovskiy.ddd.activerecord;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class App {
    public Ticket readTicket(int ticketId) {
        return Ticket.read(ticketId);
    }
}

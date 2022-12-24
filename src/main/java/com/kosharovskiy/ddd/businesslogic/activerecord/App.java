package com.kosharovskiy.ddd.businesslogic.activerecord;

import com.kosharovskiy.ddd.businesslogic.transactionscript.Database;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class App {
    private final Database database;

    public void createTicket(String summary) {
        try {
            database.startTransaction();

            Ticket ticket = new Ticket();
            ticket.setSummary(summary);
            ticket.save();

            database.commitTransaction();
        } catch (Exception e) {
            database.rollbackTransaction();
        }
    }
}

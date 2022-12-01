package com.kosharovskiy.ddd.transactionscript;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class App {
    private final Database database;

    public void createTicket(String summary) {
        database.execute("INSERT tickets INTO (summary, is_closed, assignee_id VALUES(@p1, @p2, @p3",
                summary, false, 0);
    }

    public void assignTicket(int ticketId, int assigneeId) {
        try {
            database.startTransaction();
            database.execute("UPDATE tickets SET assignee_id = @p1 WHERE ticket_id = @p2", assigneeId, ticketId);
            database.execute("UPDATE users SET assigned_tickets = assigned_tickets + 1 WHERE user_id = @p1", assigneeId);
            database.commitTransaction();
        } catch (Exception e) {
            database.rollbackTransaction();
        }
    }
}

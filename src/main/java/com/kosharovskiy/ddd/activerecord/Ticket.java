package com.kosharovskiy.ddd.activerecord;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class Ticket {
    private int ticketId;
    @Setter
    private String summary;
    private boolean isClosed;
    private User user;
    private static final Database database = new Database() {
        @Override
        public void execute(String sql, Object... params) {

        }

        @Override
        public void startTransaction() {

        }

        @Override
        public void commitTransaction() {

        }

        @Override
        public void rollbackTransaction() {

        }

        @Override
        public Map<String, String> query(String sql, Object... params) {
            return null;
        }
    };

    public static Ticket read(int ticketId) {
        Map<String, String> ticketResult = database.query("SELECT * FROM tickets WHERE ticket_id = @p1", ticketId);
        Map<String, String> userResult = database.query("SELECT * FROM users WHERE user_id = @p1", ticketResult.get("assignee_id"));
        return new Ticket(Integer.parseInt(ticketResult.get("ticket_id")), ticketResult.get("summary"), Boolean.parseBoolean(ticketResult.get("is_closed")),
                new User(Integer.parseInt(userResult.get("user_id")), userResult.get("name")));
    }
}

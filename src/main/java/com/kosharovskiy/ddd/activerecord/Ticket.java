package com.kosharovskiy.ddd.activerecord;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public class Ticket {
    private final String ticketId;

    private String summary;

    @Setter
    private boolean isClosed;

    public Ticket() {
        this.ticketId = UUID.randomUUID().toString();
    }

    public void setSummary(String summary) {
        if (summary == null) {
            throw new IllegalArgumentException("Summary can't be null");
        }

        this.summary = summary;
    }

    public void save() {
    }
}
